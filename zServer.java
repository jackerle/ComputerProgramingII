import java.io.*;
import java.net.*;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import javax.swing.TransferHandler;

import java.nio.ByteBuffer;

public class zServer{
    
    static String path  = "f:/code/OSClass/Receive/";

    
    public static void main(String[] args)throws IOException{
        Thread zeroThread  = new ZeroCopyServerHandlerThread(path);
        zeroThread.start();
        Thread tranferingThread = new TranferingCopyServerHandlerThread(path);
        tranferingThread.start();
}
}
class ZeroCopyServerHandlerThread extends Thread{
    int port  = 9889;
    String path = "";
    ZeroCopyServerHandlerThread(String path){
       this.path = path;
    }
    public void run(){
       try{ 
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

        Thread requestThread = new RequestHandlerThread1(socketChannel,buffer,path+filename);
        requestThread.start();
        }
        //socketChannel.close();
        //serverSocket.close();
        }
        catch(IOException e){

        }
    }
}

class RequestHandlerThread1 extends Thread{
    
    SocketChannel socketChannel = null;
    ByteBuffer buffer = null;
    String path = "";
    
    //-----Constructure for thread class--------------------//
    public RequestHandlerThread1(SocketChannel socketChannel,ByteBuffer buffer,String path){
        this.socketChannel = socketChannel;
        this.buffer = buffer;
        this.path = path;
    }



    //---Todo-----------------//
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

        //--Progress bar method-------------------//
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

class TranferingCopyServerHandlerThread extends Thread{
    String path = "";
    int port = 9990;
    public TranferingCopyServerHandlerThread(String path){
        this.path = path;
    }
    public void run(){
        ServerSocket server_socket = null;
        Socket  socket = null;
        try{
            server_socket = new ServerSocket(port);
            while(true){
                System.out.println("Server of tranfering opened on :"+port);
                socket = server_socket.accept();
                System.out.println("Client has connected!");
                Thread thread = new RequestHandlerThread2(socket,path,System.currentTimeMillis());
                thread.start();
            }
        }
        catch(IOException e){

        }
       /* finally{
            if(server_socket!=null)server_socket.close();
        }*/
    }
}
class RequestHandlerThread2 extends Thread{
    String path = "";
    Socket socket = null;
    InputStream is = null;
    FileOutputStream fos= null;
    BufferedOutputStream bos = null;
    Long timeStart  = null;
    Long timeEnd = null;
    
    RequestHandlerThread2(Socket socket,String path,Long start){
        this.path = path;
        this.socket = socket;
        this.timeStart = start;
    }
    public void run(){
        try{
            is = socket.getInputStream();
            int byteRead = 0;
            int current =0 ;
            //get file size from client--------------------
            DataInputStream dis = new DataInputStream(is);
            Long sizeFile = dis.readLong();
            int size2 = (int)(sizeFile/2);
            System.out.println("Size of file is :"+sizeFile);
            //----------------------------------------------
            byte[] byteArr1 = new byte[size2];
            byte[] byteArr2 = new byte[size2];

            //-------init file config-------------------
            fos = new FileOutputStream(path+Long.toString(System.currentTimeMillis())+".mkv");
            bos = new BufferedOutputStream(fos);

            //--------receive byte from is---------------
            byteRead  = is.read(byteArr1,current,size2-current);
            current = byteRead;
            do{
                byteRead = is.read(byteArr1, current, size2-current);
                if(byteRead >=0)current+=byteRead;
            }
            while (current <size2);
            System.out.println("phase1 completed");
            byteRead = 0;
            current = 0;
            //-----------------------------------------------

            //-------phase2-----------------------------
            byteRead  = is.read(byteArr2,current,size2-current);
            current = byteRead;
            do{
                byteRead = is.read(byteArr2, current, size2-current);
                if(byteRead >=0)current+=byteRead;
            }
            while (current <size2);
            System.out.println("phase2 completed");
            //-----------------------------------------------
            //-------make file----------------------------
            System.out.print("make file! : 0% \r");
            bos.write(byteArr1,0,current);
            bos.flush();
            System.out.print("make file! : 50% \r");
            bos.write(byteArr2,0,size2);
            bos.flush();
            System.out.println("make file! : 100% ");
            bos.close();
            System.out.println("finish from tranfering thread");
            timeEnd = System.currentTimeMillis();
            System.out.println("total usage time is :"+(timeEnd-timeStart)/1000+" secound");

        }
        catch(IOException e){

        }
        
    }
}