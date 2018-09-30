package home.work11.task2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String ans = System.getProperty("os.name");
        int request = 0;
        try (ServerSocket soc = new ServerSocket(8080)) {
            for (; ; ) {
                Socket socket = soc.accept();
                request+=1;
                Client client = new Client(ans + " regust number - " + request,socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
