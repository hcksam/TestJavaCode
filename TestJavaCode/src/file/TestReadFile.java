package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.LinkedList;

import org.apache.commons.io.FileUtils;
import org.mozilla.universalchardet.UniversalDetector;

public class TestReadFile {
	public static boolean isValidUTF8(final byte[] bytes) {

		try {
			Charset.availableCharsets().get("UTF-8").newDecoder().decode(ByteBuffer.wrap(bytes));

		} catch (CharacterCodingException e) {

			return false;
		}

		return true;
	}

	public static boolean isValidEncode(final byte[] bytes, String encoding) {
		try {
			Charset.availableCharsets().get(encoding).newDecoder().decode(ByteBuffer.wrap(bytes));
		} catch (CharacterCodingException e) {

			return false;
		}

		return true;
	}

	public static void TestDetector(File file) throws java.io.IOException {
		byte[] buf = new byte[4096];
		FileInputStream fis = new FileInputStream(file);

		// (1)
		UniversalDetector detector = new UniversalDetector(null);

		// (2)
		int nread;
		while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
			detector.handleData(buf, 0, nread);
		}
		// (3)
		detector.dataEnd();

		// (4)
		String encoding = detector.getDetectedCharset();
		if (encoding != null) {
			System.out.println("Detected encoding = " + encoding);
		} else {
			System.out.println("No encoding detected.");
		}

		// (5)
		detector.reset();
	}
	
	public static String getEncoding(File file){
		try{
			byte[] buf = new byte[4096];
			FileInputStream fis = new FileInputStream(file);
			UniversalDetector detector = new UniversalDetector(null);
			int nread;
			while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
				detector.handleData(buf, 0, nread);
			}
			detector.dataEnd();
			String encoding = detector.getDetectedCharset();
			detector.reset();
			fis.close();
			return encoding;
		}catch (Exception e){
			return null;
		}
	}
	
	public static String getEncoding(FileInputStream fis){
		try{
			byte[] buf = new byte[4096];
			UniversalDetector detector = new UniversalDetector(null);
			int nread;
			while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
				detector.handleData(buf, 0, nread);
			}
			detector.dataEnd();
			String encoding = detector.getDetectedCharset();
			detector.reset();
			return encoding;
		}catch (Exception e){
			return null;
		}
	}

	public static LinkedList<String> readFile(File file) {
		LinkedList<String> data = new LinkedList<>();
		try {
			FileInputStream fis = new FileInputStream(file);
			String encoding = getEncoding(file);
			if (encoding == null){
				encoding = "UTF-8";
			}
			InputStreamReader isr = new InputStreamReader(fis, encoding);
			BufferedReader br = new BufferedReader(isr);
			String readLine;
			while ((readLine = br.readLine()) != null) {
				readLine = readLine.replaceAll("\\r\\n", "\n");
				data.add(readLine);
			}
			br.close();
			isr.close();
			fis.close();

		} catch (IOException e) {
			return null;
		}
		return data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 File file = new File("C:/Users/hck/Desktop/型號.txt");
//		File file = new File("C:/Users/hck/Desktop/utf8.txt");
//		 File file = new File("C:/Users/hck/Desktop/unicode.txt");
		 File file = new File("C:/Users/hck/Desktop/unicodebig.txt");
//		TestDetector(file);
		LinkedList<String> data = readFile(file);
		for (String line : data) {
			System.out.println(line);
		}
	}

}
