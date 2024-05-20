package filehandlingconcept;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileContentTransfer {

	public static void main(String[] args)
			throws IOException
	{
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("/Users/Kraj-mac/Work/JavaTestFolder/InputExampleJava.txt");
			fos = new FileOutputStream("/Users/Kraj-mac/Work/JavaTestFolder/OutputExampleJava.txt");
			int c;
			while ((c=fis.read())!= -1) {
				fos.write(c);
			}
		}
		finally {
			System.out.println("copied the file successfully");
			fis.close();
			fos.close();
		}
	}
}
