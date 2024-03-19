import java.net.*;
import java.io.*;

public class BulletinBoardServer {

    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started. Listening on port 8080...");
            serverSocket.start(8080);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                out.println("Hello, client! Welcome to the bulletin board server.");

                clientSocket.close();

                PrintWriter x = new PrintWriter(
                        new OutputStreamWriter( p.getOutputStream() ), true );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        public void start(int port) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Weather Data Server started. Listening on port " + port + "...");
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                    new BulletinBoardServer(clientSocket).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
