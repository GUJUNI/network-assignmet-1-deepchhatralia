import java.io.*;
import java.net.*;

public class simptcpserver2 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1616);
            System.out.println("Server is listening on port 1616...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("User connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String inputLine = in.readLine();
                System.out.println("Received from user: " + inputLine);

                out.println("Goodbye");

                in.close();
                out.close();
                clientSocket.close();
                System.out.println("User disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
