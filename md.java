import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md {
    public static void main(String[] args) {
        try {
            String fileName = "demo.txt";
            byte[] digest = computeMessageDigest(fileName, "SHA-256");

            // Convert the digest bytes to hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            String messageDigest = sb.toString();

            System.out.println("Message Digest (SHA-256) of " + fileName + ": " + messageDigest);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static byte[] computeMessageDigest(String fileName, String algorithm)
            throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        InputStream inputStream = new FileInputStream(fileName);

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            md.update(buffer, 0, bytesRead);
        }
        inputStream.close();

        return md.digest();
    }
}
