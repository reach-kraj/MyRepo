package filehandlingconcept;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling {
	public static void main(String[] args) throws IOException {
		// Create a BufferedReader object
		BufferedReader reader = new BufferedReader(new FileReader("/Users/Kraj-mac/Work/JavaTestFolder/InputExampleJava.txt"));

		// Read a line from the file
		String line = reader.readLine();

		// While there are still lines to read, print the line to the console
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}

		// Close the BufferedReader object
		reader.close();
	}
}

