package poi;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.converter.WordToHtmlUtils;
import org.w3c.dom.Document;

public class W2HTML {
	public void convent() throws Exception{
		HWPFDocumentCore wordDocument = WordToHtmlUtils.loadDoc(new FileInputStream("C:/Temp/press BUG/VT/20131106c Free SIM.doc"));

	    WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
	            DocumentBuilderFactory.newInstance().newDocumentBuilder()
	                    .newDocument());
	    wordToHtmlConverter.processDocument(wordDocument);
	    Document htmlDocument = wordToHtmlConverter.getDocument();
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    DOMSource domSource = new DOMSource(htmlDocument);
	    StreamResult streamResult = new StreamResult(out);

	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer serializer = tf.newTransformer();
	    serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    serializer.setOutputProperty(OutputKeys.INDENT, "yes");
	    serializer.setOutputProperty(OutputKeys.METHOD, "html");
	    serializer.transform(domSource, streamResult);
	    out.close();

	    String result = new String(out.toByteArray());
	    System.out.println(result);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new W2HTML().convent();
	}

}
