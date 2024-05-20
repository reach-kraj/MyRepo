package filehandlingconcept;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FolderTransfer  {

	public static void copyContent(File sourceLocation , File targetLocation)
			throws IOException {

		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				targetLocation.mkdir();
			}

			String[] contentInside = sourceLocation.list();
			System.out.println(contentInside.length);
			for (int i=0; i<contentInside.length; i++) {
				copyContent(new File(sourceLocation, contentInside[i]),
						new File(targetLocation, contentInside[i]));
			}
		} 
		else {

			FileInputStream in = new FileInputStream(sourceLocation);
			FileOutputStream out = new FileOutputStream(targetLocation);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}
	}
	public static void main(String args[]) throws IOException{

		File src=new File("/Users/Kraj-mac/Work/JavaTestFolder/InputJavaFolder");
		File dst=new File("/Users/Kraj-mac/Work/JavaTestFolder/OutputJavaFolder");
		FolderTransfer.copyContent(src,dst);
	}
}