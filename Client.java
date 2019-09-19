import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Client {
    public static String FILE_REC = "f:/code/OSClass/Receive/";
    public final static int FILE_SIZE = 1050000000;
    /*static HandlerThread t0;
    static HandlerThread t1;
    static HandlerThread t2;
    static HandlerThread t3;*/
    static HandlerThread t[] = new HandlerThread[4];
    static boolean t0_c;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        if (args.length < 2)
            return;

        int SERVER_PORT = Integer.parseInt(args[1]);
        String HOST = args[0];
        //FILE_REC=FILE_REC+args[2];

        int byteRead;
        int current = 0;
        InputStream is=null;
        FileOutputStream fos = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        Socket sock = null;
        try {
            sock = new Socket(HOST, SERVER_PORT);
            System.out.println("Connecting...");

            // read_file
            byte[] byteArr = new byte[FILE_SIZE];
             is = sock.getInputStream(); //อยู่ในร้านก๋วยเตี๋ยว
            os = sock.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            DataInputStream clientData = new DataInputStream(is);
            String file_list  =clientData.readUTF();
            System.out.println("Select file your want to download");
            System.out.println(file_list);
            dos.writeUTF(scan.nextLine());


            String fileName = clientData.readUTF();
            FILE_REC += fileName;
            long size = clientData.readLong(); //จำนวนชาม ==300ชาม
            
            
            for(int i=0;i<4;i++){
                t[i] = new HandlerThread(i,is,size,fileName);
                t[i].start();
            }     
            threadWatch();
            fos = new FileOutputStream(FILE_REC);
            bos = new BufferedOutputStream(fos);
            System.out.println("Now start sorting....");
            for(int i=0;i<4;i++){
                File temp = new File(t[i].getPath());
                byte[] byteTemp = Files.readAllBytes(temp.toPath());
                System.out.println("now in phase "+i+" success "+25*(i+1)+"%");
                bos.write(byteTemp,0,byteTemp.length);
                temp.delete();
            }
            bos.flush();


            System.out.println("Download Success!");
        }  finally {
            if(is!=null)
                is.close();
            if (fos != null)
                fos.close();
            if (bos != null)
                bos.close();
            if (sock != null)
                sock.close();
            
        }

    }
    public static void progressBar(int _now, long max) {
        System.out.println("Now loading progress...");
        long now = _now;
        long progress = (now * 100) / max;
        String str = "";
        System.out.print(progress + "% :");
        for (int i = 0; i < progress; i++) {
            str+="I";
        }
        System.out.println(str);
        System.out.println("now loading : "+now+"/"+max+" Byte");
    }
    public static void threadWatch(){
       try{
        if(t[0].isComplete&&t[1].isComplete&&t[2].isComplete&&t[3].isComplete){
            System.out.println("finish!");
        }
        else{
            Thread.sleep(2000);
            threadWatch();
        }
    }catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

class HandlerThread extends Thread{
    public String FILE_REC = "f:/code/OSClass/Receive/";
    public FileOutputStream fos;
    public BufferedOutputStream bos;
    public InputStream is = null;
    public int index = 0;
    public int number = 0;
    public int size =0;
    public int max_size=0;
    public boolean isComplete = false;
    int byteRead;
    int current=0;
    HandlerThread(int index,InputStream is,long size,String file_name)throws IOException{
        this.max_size = (int)size;
        this.FILE_REC=this.FILE_REC+file_name+".tempdownload";
        this.FILE_REC+=Integer.toString(index); 
        this.number = index;
        this.is = is;
        this.index = ((int)size/4)*index;
        if(index<3){this.size = (int)size/4;}
        else {
            this.size = ((int)size - (3*(((int)size/4))));
            }
        this.fos = new FileOutputStream(FILE_REC);
        this.bos = new BufferedOutputStream(fos);

    }
    public String getPath(){
        return this.FILE_REC;
    }


    public void run(){
        try{
           // is.skip(index);
             System.out.println("Conected from thread : "+this.number+" size is "+this.size+"and this index:"+this.index);
            byte[] byteArr = new byte[size+index];
            byteRead = is.read(byteArr,index,size);
            current = byteRead;
            do {
                byteRead = is.read(byteArr, current, size-current);
                
                if (byteRead >= 0)
                    current += byteRead;
                   
                   // System.out.println(byteRead);
            } while (current < size);
            this.bos.write(byteArr,index,size);
            this.bos.flush();
            System.out.println("Success from thread:"+number+" size is "+current);
            this.bos.close();
            this.isComplete = true;
        }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
    }
    
}