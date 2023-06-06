import java.net.DatagramPacket;
import java.net.DatagramSocket;

class simpudpserver2 {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(1616);

            byte[] receiveData = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);

            String message = new String(receivePacket.getData());
            System.out.println("Received from client 2: " + message.trim());

            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
