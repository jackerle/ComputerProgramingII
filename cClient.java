import java.io.*;
import java.net.*;

public class cClient{
    



    static String path  = "f:/code/OSClass/Server/1.mkv";
    static long size = 0;
        public static void main(String[] args){
            String host = "localhost";
            int port = 9990;
            OutputStream os = null;
            Socket socket = null;
            FileInputStream fis = null;
            BufferedInputStream bis = null;
        
            try{
                socket = new Socket(host,port);
                os = socket.getOutputStream();
                System.out.println("Connected!");
                File file = new File(path);
                
                //request to server for send file size
                Long sizeFile = file.length();
                byte [] byteArr1 = new byte[(int)(sizeFile/2)];
                byte [] byteArr2 = new byte[(int)(sizeFile/2)];
                //System.out.println("size 1/2 = "+byteArr1.length);
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeLong(sizeFile);
                //------------------------------------------------
                //-------prepare buffer
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                System.out.print("prepare for buffer : 0% \r");
                bis.read(byteArr1,0,byteArr1.length);
                System.out.print("prepare for buffer : 50% \r");
                bis.read(byteArr2,0,byteArr2.length);
                System.out.println("already prepare file to byte buffer");
                System.out.print("send on outputStream : 0% \r");
                os.write(byteArr1,0,byteArr1.length);
                os.flush();
                System.out.print("send on outputStream : 50% \r");
                os.write(byteArr2,0,byteArr2.length);
                os.flush();
                System.out.println("send on outputStream : 100% ");
                System.out.println("Done!");

            }
            catch(IOException e){

            }

        }

}