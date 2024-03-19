
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class BulletinBoardServer {
    private static final int PORT = 5000;
    private static final String file = "bulletin_board.txt";
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection from: " + clientSocket.getInetAddress().getHostAddress());
                Socket clientHandler = new Socket();
                clientHandler.start("127.0.0.1", 5000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Weather Data Server started. Listening on port " + port + "...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                new Socket().start("127.0.0.1", 5000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized List<String> readMessages() {
        List<String> messages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                messages.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messages;
    }

    public static synchronized boolean addMessage(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(message);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
