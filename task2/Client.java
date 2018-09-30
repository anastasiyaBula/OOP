package home.work11.task2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {

    private String ans;
    private Thread t;
    private Socket socket;

    public Client(String ans, Socket socket) {
        this.ans = ans;
        this.socket = socket;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try (InputStream is = socket.getInputStream(); OutputStream os = socket.getOutputStream();
             PrintWriter pw = new PrintWriter(os)) {
            byte[] rec = new byte[is.available()];
            is.read(rec);
            for (byte b : rec) {
                System.out.println((char) b);
            }
            String response = "HTTP/1.1 200 OK\r\n" + "Client: My_Server\r\n" + "Content-Type:text/html\r\n"
                    + "Content-Length: " + "\r\n" + "Connection: close\r\n\r\n";
            pw.print(response + "<html><head><title>Lecture11 Task2</title> <meta charset='utf-8'></head><body><br> " + ans
                    + " </body></html>");
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
