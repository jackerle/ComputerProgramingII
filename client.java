import java.io.*;
import java.net.Socket;

public class Client {
    public static String FILE_REC = "d:/4Study/OSClass/Receive/";
    public final static int FILE_SIZE = 550000000;

    public static void main(String[] args) throws IOException {
        if (args.length < 3)
            return;

        int SERVER_PORT = Integer.parseInt(args[1]);
        String HOST = args[0];
        FILE_REC=FILE_REC+args[2];

        int byteRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        Socket sock = null;
        try {
            sock = new Socket(HOST, SERVER_PORT);
            System.out.println("Connecting...");

            // read_file
            byte[] byteArr = new byte[FILE_SIZE];
            InputStream is = sock.getInputStream();

            DataInputStream clientData = new DataInputStream(is);
            String fileName = clientData.readUTF();
            FILE_REC += fileName;
            long size = clientData.readLong();

            fos = new FileOutputStream(FILE_REC);
            bos = new BufferedOutputStream(fos);
            byteRead = is.read(byteArr, 0, byteArr.length);
            current = byteRead;
            System.out.println("Connected... will be download" + current);

            do {
                System.out.print("\033[H\033[2J");
                byteRead = is.read(byteArr, current, (byteArr.length - current));
                if (byteRead >= 0)
                    current += byteRead;
                   progressBar(current,size,fileName);
                    Thread.sleep(50);

            } while (current < size);

            System.out.println("Success!");
            bos.write(byteArr, 0, current);
            bos.flush();
            System.out.println("File" + FILE_REC + "download (" + current + "byte read)");
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
