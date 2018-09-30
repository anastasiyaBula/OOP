package home.work11.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        File file = new File("file.txt");
        checkAccess(file);
    }

    public static void checkAccess(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String urlAddress = "";
            for (; (urlAddress = br.readLine()) != null; ) {
                try {
                    URL url = new URL(urlAddress);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    int tect = httpURLConnection.getResponseCode();
                    System.out.println(urlAddress+" is available.");
                }catch (Exception e){
                    System.out.println(urlAddress+" is not available.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}