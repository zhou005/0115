package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) {
        try {
            Socket socket = null;
            ServerSocket ss = new ServerSocket(8889);
            while (true) {
                System.out.println("有新用户进入系统");
                socket = ss.accept();
                System.out.println("服务端说");
                OutputStream os = socket.getOutputStream();//??????????м??????????????????????δ????????
                OutputStreamWriter osw = new OutputStreamWriter(os);
                PrintWriter out = new PrintWriter(osw);
                out.println("你好XXX");
                out.flush();

                //????????????
                GetMessageThread getMessageThread = new GetMessageThread(socket);
                getMessageThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
