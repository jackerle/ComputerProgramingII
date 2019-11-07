import java.io.*;
import java.net.*;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.ByteBuffer;

public class zServer{
    
    static String path  = "f:/code/OSClass/Receive/";
    static int port  = 9889;
    
    public static void main(String[] args)throws IOException{
        //ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        ByteBuffer buffer = ByteBuffer.wrap(new byte[8]);
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        //Server has opened
        serverSocket.bind(new InetSocketAddress(port));
        System.out.println("Server has opened!! on :"+port);
        
        while(true){
        //Server connection has establish
        SocketChannel socketChannel  = serverSocket.accept();
        System.out.println("Server has new connected!");
        String filename = Long.toString(System.currentTimeMillis())+".mkv";
        //-----------------------------------------------------------------//

        Thread requestThread = new RequestHandlerThread(socketChannel,buffer,path+filename);
        requestThread.start();
        }
        //socketChannel.close();
        //serverSocket.close();
    }
    
}

class RequestHandlerThread extends Thread{
    SocketChannel socketChannel = null;
    ByteBuffer buffer = null;
    String path = "";
    public RequestHandlerThread(SocketChannel socketChannel,ByteBuffer buffer,String path){
        this.socketChannel = socketChannel;
        this.buffer = buffer;
        this.path = path;
    }
    public void run(){
        try{
        //send size to client
        socketChannel.read(buffer);
        buffer.flip();
        long size = buffer.getLong();
        buffer.clear();
        System.out.println("Size of file is : "+size);
        //long size = Long.parseLong();
        //------------------------------------
        
        
        System.out.println("Server ready for receive file!");
        FileChannel fileC = new FileOutputStream(path).getChannel();
        long total = 0;
        //long tranferFromCount  =fileC.transferFrom(socketChannel, total,size-total );
        //System.out.println(tranferFromCount);
        while(total < size){
            long tranferFromCount=0;
            if(total==(size/100)*99)tranferFromCount  = fileC.transferFrom(socketChannel, total,(size/100)+size%100 );
            else tranferFromCount  = fileC.transferFrom(socketChannel, total,size/100 );
            if(tranferFromCount<=0)break;
            total+=tranferFromCount;
            progressBar(total, size);
            
        }
        System.out.println("File has already finish!");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
        public void progressBar(long _now, long max) {
        //System.out.println("Now loading progress...");
        long now = _now;
        long progress = (now * 100) / max;
        String str = progress+"% ";
        //System.out.print(progress + "% :");
        for (int i = 0; i < progress; i++) {
            str+="|";
        }
        System.out.print(str+ "\r");
       // System.out.print(" \r now loading : "+now+"/"+max+" Byte| \r");
    }
    
    

}