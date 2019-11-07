import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;


public class zClient{

    static String path = "f:/code/OSClass/Server/1.mkv";
    static long size =0;

    public static void main(String[] args)throws IOException{
        
        InetSocketAddress serverAddress = new InetSocketAddress("178.128.54.43", 9889);
        FileChannel fileChannel  = new FileInputStream(path).getChannel();
        size = fileChannel.size();

        //connect to server
        SocketChannel socketChannel = SocketChannel.open(serverAddress);




        //prepare for msg
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.asLongBuffer().put(size);
        //buffer.flip();
        socketChannel.write(buffer);
        System.out.println("Send size to server :"+size);
        buffer.clear();
        

        /*File temp = File.createTempFile("TempFileName", ".tmp");
        temp.deleteOnExit();
        FileChannel fileChannel = new FileOutputStream(temp).getChannel();
        fileChannel.transferFrom(src,0,src.size());*/

        //sendfile
        long total = 0;
        while(total < size){
            long tranferToCount  = fileChannel.transferTo(total, size-total,socketChannel);
            if(tranferToCount<=0)break;
            total+=tranferToCount;
            progressBar(total, size);
        }
        System.out.println("finish!");

       // fileChannel.transferTo(0,fileChannel.size(), socketChannel);
        socketChannel.close();
        fileChannel.close();
    }



    public static void progressBar(long _now, long max) {
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