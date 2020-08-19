import java.io.*;
import java.net.*;

public class old_Server{
    public final static int PORT = 6880;    //port for this socket
    public static String PATH = "f:/code/OSClass/Server/";
    public static String dir = "f:/code/OSClass/Server";
      //file to download

    public static void main(String [] args) throws IOException{
        ServerSocket server_socket = null;
        Socket socket = null;
        try {

            server_socket = new ServerSocket(PORT);
            while (true) {
                
                System.out.println("Server has openned on port :"+PORT);
                socket = server_socket.accept();
                System.out.println("Client has connected! :"+socket);
                Thread t = new RequestHandlerThread(dir,PATH,socket);
                t.start();
            }
        
        }finally{
            if(server_socket != null)server_socket.close();
        }
    }
}

class RequestHandlerThread extends Thread{
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        String file_name;
        Socket socket = null;
        String path;
        String dir;
        DataInputStream serverData = null;
        InputStream is = null;

        public RequestHandlerThread(String dir,String Path,Socket socket){
            this.dir = dir;
            this.path = Path;
            this.socket = socket;
            //this.file_name = file_name;
        }
        public void run(){
            try{
            os = socket.getOutputStream();
            is = socket.getInputStream();
            DataOutputStream dos = new DataOutputStream(os); 
            serverData = new DataInputStream(is);
            File directory = new File(dir);
            File[] flist = directory.listFiles();
            String _list="";
            for(File a:flist){
                _list=_list+a.getName()+" \n";
            }
            dos.writeUTF(_list);
            String file_download = serverData.readUTF();
           System.out.println("Have a new download request file : "+file_download);
            
            //File myFile = new File(path);
            File myFile = null;
            for(File a:flist){
                if(file_download.equals(a.getName())){
                    myFile = a;
                }
            }
            byte [] byteArr = new byte[(int)myFile.length()];
            fis = new FileInputStream(myFile);
            bis = new BufferedInputStream(fis);
            bis.read(byteArr,0,byteArr.length);
            dos.writeUTF(file_download);
            dos.writeLong(byteArr.length); 
           // dos.writeUTF("Hello you can do it!");
            System.out.println("Sending "+file_download+"("+byteArr.length +"bytes");
            os.write(byteArr,0,byteArr.length);
            os.flush();
            dos.flush();
            System.out.println("Done");
            bis.close();
            os.close();
            socket.close();
            fis.close();
            } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
            }
            
            
        }
}