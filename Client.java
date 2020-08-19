import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class old_Client {
    public static String FILE_REC = "f:/code/OSClass/Receive/";
    public final static int FILE_SIZE = 1050000000;
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
            
            
            
            fos = new FileOutputStream(FILE_REC);
            bos = new BufferedOutputStream(fos);
            System.out.println("Now start sorting....");
            byteRead = is.read(byteArr, 0, byteArr.length);
            current = byteRead;
            System.out.println("Connected... will be download" + current);

            do {
                System.out.print("\033[H\033[2J");
                byteRead = is.read(byteArr, current, (byteArr.length - current));
                if (byteRead >= 0)
                    current += byteRead;
                   progressBar(current,size,fileName);

            } while (current < size);
            bos.write(byteArr, 0, current);
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
    public static void progressBar(int _now, long max,String name) {
        System.out.println("Now loading progress..."+name);
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
    
}

