import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6000);
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.print("Enter message: ");
            String message = keyboard.readLine();
            output.println(message);
            String reply = input.readLine();
            System.out.println("Server echoed: " + reply);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}