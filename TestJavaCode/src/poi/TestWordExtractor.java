package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import poi.function.WordExtractor2;

import common.CommonData;

public class TestWordExtractor {
	public static void main(String[] args) throws IOException {
		File file = new File(CommonData.DefaultParent, CommonData.DefaultName);
		InputStream in = new FileInputStream(file);
		System.out.println(new WordExtractor2().extractText(in));
	}
}
