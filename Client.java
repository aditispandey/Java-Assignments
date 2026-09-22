import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));
            for (int i = 1; i <= 5; i++) {
                System.out.print("Client: ");
                String message = keyboard.readLine();
                output.println(message);
                String reply = input.readLine();
                System.out.println("Server says: " + reply);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
