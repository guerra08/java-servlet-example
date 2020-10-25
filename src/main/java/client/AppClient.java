package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class AppClient {

    public static void main(String[] args) {

        try {
            URL servletUrl = new URL("http://localhost:8080/users");
            BufferedReader br = new BufferedReader(new InputStreamReader(servletUrl.openStream()));
            String data = br.lines().collect(Collectors.joining());
            System.out.println("All users from the servlet: ");
            System.out.println(data);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
