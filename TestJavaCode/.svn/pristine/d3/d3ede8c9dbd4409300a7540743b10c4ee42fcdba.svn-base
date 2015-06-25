package file;

import java.io.File;

public class TestListFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File(".");
		if (file.list() != null) {
			for (int i = 0; i < file.list().length; i++) {
				System.out.println(file.list()[i]);
			}
		} else {
			System.out.println(file);
		}
	}
}
