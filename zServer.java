import java.io.*;
import java.net.*;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.ByteBuffer;

public class zServer{
    
    static String path  = "f:/code/OSClass/Receive/test.txt";
    static int port  = 9889;
    public static void main(String[] args)throws IOException{
        //ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        ByteBuffer buffer = ByteBuffer.wrap(new byte[8]);
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        //Server has opened
        serverSocket.bind(new InetSocketAddress(port));
        System.out.println("Server has opened!! on :"+port);
        
        
        //Server connection has establish
        SocketChannel socketChannel  = serverSocket.accept();
        
        
        
        //test msg
        socketChannel.read(buffer);
        buffer.flip();
        long size = buffer.getLong();
        buffer.clear();
        System.out.println("Size of file is : "+size);
        //long size = Long.parseLong();
        //------------------------------------
        
        
        System.out.println("Server has conntected!");
        FileChannel fileC = new FileOutputStream(path).getChannel();
        long total = 0;
        while(total < size){
            long tranferFromCount  = fileC.transferFrom(socketChannel, total,size-total );
            if(tranferFromCount<=0)break;
            total+=tranferFromCount;
        }
        
        socketChannel.close();
        serverSocket.close();
    }
}