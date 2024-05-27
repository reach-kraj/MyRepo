package filehandlingconcept;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferStream {
	public void copyContent(File src,File dst) throws IOException {
		FileInputStream in = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(dst);

		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		File src=new File("/Users/Kraj-mac/Work/JavaTestFolder/InputExampleJava.txt");
		File dst=new File("/Users/Kraj-mac/Work/JavaTestFolder/OutputExampleJava.txt");
		BufferStream streamStart = new BufferStream();
		streamStart.copyContent(src,dst);
	}
}
