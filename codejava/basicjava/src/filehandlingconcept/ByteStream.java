package filehandlingconcept;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) {
        String inputFile = "C:\\temp\\BufferStream.txt";
        String outputFile = "c:\\temp\\CopyOfBufferStream.txt";

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}
