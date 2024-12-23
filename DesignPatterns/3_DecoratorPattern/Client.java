package DecoratorPattern;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Client {

	public static void main(String[] args) {

		int c;
		
		StringBuffer stringBuffer = new StringBuffer("Muharrem KOcAbiyiK");
		byte[] bytes = stringBuffer.toString().getBytes();
		
		try {
			// use in 1 or input stream 
			InputStream in1 = new LowerCaseInputStream(new ByteArrayInputStream(bytes));
			InputStream inputStream = new LowerCaseInputStream(
					new BufferedInputStream(new FileInputStream("test.txt")));
			while ((c = in1.read()) >= 0) {
				System.out.print((char) c);
			}
			in1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
