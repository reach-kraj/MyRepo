package predefinedjavaclass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class AddTextAtLast {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("G:\\Code\\BooleanCheck.java");
			fos = new FileOutputStream("G:\\temp\\New Text Document.java");
			int c;
			while ((c=fis.read())!= -1) {
				fos.write(c);
			}
			File log = new File("G:\\temp\\New Text Document.java");
			FileWriter finalFile = new FileWriter(log, true);
			BufferedWriter addAtLast = new BufferedWriter(finalFile);
			addAtLast.write( "\n"+"Success");
			addAtLast.close();
		}
		finally {
			System.out.println("copied the file successfully");
			fis.close();
			fos.close();
		}
	}

}
