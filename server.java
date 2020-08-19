import java.io.*;
import java.net.*;

public class Server{
    public final static int PORT = 6889;    //port for this socket
    public static String PATH = "d:/4Study/OSClass/Send/";  //file to download

    public static void main(String [] args) throws IOException{
        if(args.length<1)return;
        String file_name = args[0];
        PATH+=file_name;
        ServerSocket server_socket = null;
        Socket socket = null;
        try {

            server_socket = new ServerSocket(PORT);
            while (true) {
                
                System.out.println("Server opened on port :"+PORT);
                socket = server_socket.accept();
                System.out.println("Client has connected! :"+socket);
                Thread t = new RequestHandlerThread(PATH,file_name,socket);
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

        public RequestHandlerThread(String Path,String file_name,Socket socket){
            this.path = Path;
            this.socket = socket;
            this.file_name = file_name;
        }
        public void run () {
            try{
            File myFile = new File(path);
            byte [] byteArr = new byte[(int)myFile.length()];
            fis = new FileInputStream(myFile);
            bis = new BufferedInputStream(fis);
            bis.read(byteArr,0,byteArr.length);
            os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os); 
            dos.writeUTF(file_name);
            dos.writeLong(byteArr.length); 
            System.out.println("Sending "+file_name+"("+byteArr.length +"bytes");
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