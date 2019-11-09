import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;


public class zClient{

    static String path = "f:/code/OSClass/Server/1.mkv";
    static long size =0;

    public static void main(String[] args)throws IOException{
        
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", 9889);
        FileChannel fileChannel  = new FileInputStream(path).getChannel();
        size = fileChannel.size();

        //connect to server
        SocketChannel socketChannel = SocketChannel.open(serverAddress);
        System.out.println("----------------------------------------------");
        System.out.println("");
        System.out.println("=========  =======     ==  ===   ==");
        System.out.println("      ==   ==    ==    =====   =======");
        System.out.println("    ==     =======     ===    ===   ===");
        System.out.println("   ==      ==          ===    ===   ===");
        System.out.println(" ==        ===         ==     ===  ===");
        System.out.println("========   ========    ==       ====");
        System.out.println("----------------------------------------------");
        System.out.println();
        




        //prepare for msg
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.asLongBuffer().put(size);
        //buffer.flip();
        socketChannel.write(buffer);
        System.out.println("Send size to server :"+size+" byteBuffer");
        buffer.clear();
        

        /*File temp = File.createTempFile("TempFileName", ".tmp");
        temp.deleteOnExit();
        FileChannel fileChannel = new FileOutputStream(temp).getChannel();
        fileChannel.transferFrom(src,0,src.size());*/

        //sendfile
        Long start = System.currentTimeMillis();
        System.out.println("_____________________________________________");
        System.out.println("Start time mill = "+start);
        System.out.println("---------------------------------------------");
        long total = 0;
        long time =0;
        while(total < size){
            long tranferToCount  = fileChannel.transferTo(total, size-total,socketChannel);
            if(tranferToCount<=0)break;
            total+=tranferToCount;
            time = progressBar(total, size,start);
        }
        System.out.println("finish!-------");
        System.out.println("_____________________________________________");
        Long minute = time/60;
        Long secound = time-minute*60;
        System.out.println("Time for this work is:"+ minute+" minute "+secound+" secound");

       // fileChannel.transferTo(0,fileChannel.size(), socketChannel);
        socketChannel.close();
        fileChannel.close();
    }



    public static long progressBar(long _now, long max,long start) {
        //System.out.println("Now loading progress...");
        long now = _now;
        long progress = (now * 100) / max;
        long time = (System.currentTimeMillis()/1000)-start/1000;
        String str = progress+"% :"+Long.toString(time)+"sec";
        //System.out.print(progress + "% :");
        for (int i = 0; i < progress; i++) {
            if(i%3==0)
            str+="|";
        }
        System.out.print(str+ "\r");
       // System.out.print(" \r now loading : "+now+"/"+max+" Byte| \r");
       return time;
    }
}