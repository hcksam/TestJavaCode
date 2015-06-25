package poi.function;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.converter.PublicWordToHtmlUtils;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * 读写doc
 * 
 * @author wangzonghao
 * 
 */
public class POIWordUtil {
	/**
	 * 读入doc
	 * 
	 * @param doc
	 * @return
	 * @throws Exception
	 */
	public static String readDoc(String doc) throws Exception {
		// 创建输入流读取DOC文件
		FileInputStream in = new FileInputStream(new File(doc));
		HWPFDocumentCore d = PublicWordToHtmlUtils.loadDoc(new File(doc));
		WordExtractor extractor = null;
		String text = null;
		// 创建WordExtractor
		extractor = new WordExtractor(in);
		// 对DOC文件进行提取
		text = extractor.getText();
		int n = 0;
		System.out.println(d.getDocumentText().substring(d.getParagraphTable().getParagraphs().get(n).getStart(), d.getParagraphTable().getParagraphs().get(n).getEnd()));
//				d.getParagraphTable().getParagraphs().get(0).getIstd()));
		return d.getCharacterTable().getTextRuns().get(n).getCharacterProperties(d.getStyleSheet(), d.getParagraphTable().getParagraphs().get(n).getIstd()).toString();
//		return d.getParagraphTable().getParagraphs().get(n).getParagraphProperties(d.getStyleSheet()).toString();
	}

	public static String[] readDoc(File docFile) throws Exception {
		FileInputStream in = new FileInputStream(docFile);
		HWPFDocumentCore d = PublicWordToHtmlUtils.loadDoc(docFile);
		WordExtractor extractor = new WordExtractor(in);
		return extractor.getParagraphText();
	}

	/**
	 * 写出doc
	 * 
	 * @param path
	 * @param content
	 * @return
	 */
	public static boolean writeDoc(String path, String content) {
		boolean w = false;
		try {

			// byte b[] = content.getBytes("ISO-8859-1");
			byte b[] = content.getBytes();

			ByteArrayInputStream bais = new ByteArrayInputStream(b);

			POIFSFileSystem fs = new POIFSFileSystem();
			DirectoryEntry directory = fs.getRoot();

			DocumentEntry de = directory.createDocument("WordDocument", bais);

			FileOutputStream ostream = new FileOutputStream(path);

			fs.writeFilesystem(ostream);

			bais.close();
			ostream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return w;
	}
	
	public static boolean getStyle(File file) throws IOException{
		HWPFDocumentCore d = PublicWordToHtmlUtils.loadDoc(file);
		return d.getStyleSheet().getCharacterStyle(0).getFDblBdr();
	}
}
