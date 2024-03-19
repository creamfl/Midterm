import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class BulletinBoardClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in)
        ) {
            String userInput;
            while (true) {
                System.out.println("Enter '1' to read messages, '2' to post a message, or 'QUIT' to exit:");
                userInput = scanner.nextLine();
                if ("1".equals(userInput)) {
                    out.println("READ_MESSAGES");
                    String response;
                    while (!(response = in.readLine()).equals("EOF")) {
                        System.out.println(response);
                    }
                } else if ("2".equals(userInput)) {
                    System.out.println("Enter your message:");
                    String message = scanner.nextLine();
                    out.println("POST_MESSAGE:" + message);
                    String response = in.readLine();
                    System.out.println(response);
                } else if ("QUIT".equals(userInput)) {
                    out.println("QUIT");
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
