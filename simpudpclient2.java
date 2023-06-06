import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class simpudpclient2 {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 1616;

            String message = "Hello World from client 2";
            byte[] sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            clientSocket.send(sendPacket);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
