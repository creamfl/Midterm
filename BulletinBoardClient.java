import java.net.*;
import java.io.*;


public class BulletinBoardClient {
    public static void main(String args[]) throws IOException {
        String server = "localhost";
        int port = 8080;
        Socket client = new Socket(server, port);

        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
