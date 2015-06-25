package poi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * Poi解析word文档
 * 
 * @author yt
 * 
 */
public class WordReader {
	/**
	 * 解析word2003
	 * 
	 * @param path
	 *            文件路径
	 * @param file
	 *            文件名
	 * @return
	 * @throws IOException
	 */
	public static String readDoc2003(String path, String fn) throws IOException {
		FileInputStream in = new FileInputStream(new File(path + fn));
		HWPFDocument document = new HWPFDocument(in);
		Range r = document.getRange();
		int pNums = r.numParagraphs();

		int picSize = 0;
		StringBuffer sb = new StringBuffer();
		System.out.println("pNums:" + pNums);
		for (int i = 0; i < pNums; i++) {

			Paragraph p = r.getParagraph(i);
			int lenChar = p.numCharacterRuns(); // 当前段落中的字对象数
			PicturesTable pTable = document.getPicturesTable();
			StringBuffer numSb = new StringBuffer();
			for (int y = 0; y < lenChar; y++) { // 对当前段落中的字对象循环
				CharacterRun run = p.getCharacterRun(y);
				StringBuffer ptext = new StringBuffer();
				if (!pTable.hasPicture(run)) {
					String charact = run.text();
					while (charact.indexOf(" ") > -1) {
						charact = charact.replace(" ", "&nbsp;");// 空格转换
					}
					if (charact.length() > 0) {
						if (charact.charAt(0) == 11) {
							charact = "<br>";
						}
					}

					if (y == lenChar - 1) {
						if (charact.charAt(0) == 13) {
							charact = "&nbsp;";
						} else {
							charact = charact
									.substring(0, charact.length() - 1);
						}
					}

					String style = "";
					if (run.isBold())
						style += "font-weight:bold;";
					if (run.isItalic())
						style += "font-style:italic;";
					if (run.isStrikeThrough())
						style += "text-decoration:line-through;;";
					int fontSize = run.getFontSize();
					style += "font-size:" + fontSize / 2 + "pt;";
					picSize = fontSize;
					String fontName = run.getFontName();
					style += "font-family:" + fontName + ";";
					if (y != lenChar - 1) {
						short sssi = run.getSubSuperScriptIndex();
						if (sssi != 0 && sssi == 2)
							style += "vertical-align: sub;";
						if (sssi != 0 && sssi == 1)
							style += "vertical-align: super;";
					}
					int fontcolor = run.getIco24();
					int[] rgb = new int[3];
					if (fontcolor != -1) {
						rgb[0] = (fontcolor >> 0) & 0xff; // red;
						rgb[1] = (fontcolor >> 8) & 0xff; // green
						rgb[2] = (fontcolor >> 16) & 0xff; // blue
					}
					style += "color: rgb(" + rgb[0] + "," + rgb[1] + ","
							+ rgb[2] + ")";
					charact = "<span  style='" + style + "'>" + charact
							+ "</span>";
					ptext.append(charact);
				} else {

					Picture pic = pTable.extractPicture(run, false);
					int width = pic.getWidth();
					int height = pic.getHeight();

					int ratiox = pic.getWidth() * pic.getAspectRatioX() / 100;
					int ratioy = pic.getHeight() * pic.getAspectRatioY() / 100;
					String fileName = pic.suggestFullFileName();
					String imgUrl = path + fileName;
					System.out.println("imgUrl:" + imgUrl);

//					if (fileName.contains(".wmf")) {
//						byte[] b = pic.getContent();
//						RandomAccessFile rf = new RandomAccessFile(imgUrl, "rw");
//						rf.write(b);
//						rf.close();
//
//						int myHeight = 0;
//						try {
//							String imgPath = wmfToJpg(imgUrl);
//							System.out.println("imgurl:" + imgUrl);
//							System.out.println(StringUtils.replace(fileName,
//									"wmf", "png"));
//							File file = new File(imgPath);
//							BufferedImage image = null;
//							image = ImageIO.read(file);
//							int pheight = image.getHeight();
//							int pwidth = image.getWidth();
//
//							myHeight = (int) (pheight
//									/ (pwidth / picSize * 1.0) * 1.5);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//						ptext.append("<img src=temp/"
//								+ StringUtils.replace(fileName, "wmf", "png")
//								+ " style='vertical-align:middle;width:"
//								+ picSize * 1.5 + "px;height:" + myHeight
//								+ "px' />");
//
//					} else {
//						OutputStream out = new FileOutputStream(
//								new File(imgUrl));
//						pic.writeImageContent(out);
//						ptext.append("<img src=temp/" + fileName
//								+ " style=width:" + ratiox + "px;height:"
//								+ ratioy + "px />");
//					}
				}

				numSb.append(ptext);

			}

			sb.append("<br/>").append(numSb);
		}
		String s = sb.toString();
		String ss = s.replaceAll("EMBED&nbsp;Equation.3", "");
		return ss;
	}

	/**
	 * 解析word2007
	 * 
	 * @param path
	 *            文件路径
	 * @param file
	 *            文件名
	 * @return
	 * @throws IOException
	 */
	public static String readDoc2007(String path, String fn) throws IOException {

		FileInputStream in = new FileInputStream(new File(path + fn));
		XWPFDocument document = new XWPFDocument(in);
		/*
		 * List<XWPFPictureData> pics= document.getAllPictures();
		 * for(XWPFPictureData data:pics){
		 * System.out.print("图片名称:"+data.getFileName()); }
		 */

		List<XWPFParagraph> paragraphs = document.getParagraphs();

		StringBuffer sb = new StringBuffer();
		for (XWPFParagraph p : paragraphs) {
			List<XWPFRun> lRun = p.getRuns();
			StringBuffer para = new StringBuffer();
			for (XWPFRun r : lRun) {
				StringBuffer style = new StringBuffer();
				if (r.getText(r.getTextPosition()) == null) {
					System.out.println("sss我晕");

				}

				String text = r.getText(r.getTextPosition());
				if (text != null) {
					if (r.isBold()) {
						style.append("font-weight:bold; ");
					}
					if (r.isItalic()) {
						style.append("font-style:italic; ");
					}
					if (r.isStrike()) {
						style.append("text-decoration:line-through; ");
					}
					int fontSize = r.getFontSize();
					style.append("font-size:" + fontSize + "pt; ");
					String fontfamily = r.getFontFamily();
					if (fontfamily != null) {
						style.append("font-family:" + fontfamily + "; ");
					}
					int value = r.getSubscript().getValue();
					if (value == 2) {
						style.append("vertical-align:super ");
					} else if (value == 3) {
						style.append("vertical-align:sub ");
					}
					String charact = "<span  style= '" + style.toString()
							+ "'>" + text + "</span>";
					para.append(charact);
				}

				List<XWPFPicture> lXpic = r.getEmbeddedPictures();

				// System.out.println("lxpic:"+lXpic);
				for (XWPFPicture pic : lXpic) {
					XWPFPictureData pData = pic.getPictureData();
					// System.out.println(pData.getFileName());

					String fileName = pData.getFileName();
					String imgUrl = path + fileName;

					byte[] b = pData.getData();
					RandomAccessFile rf = new RandomAccessFile(imgUrl, "rw");
					rf.write(b);
					rf.close();

					File file = new File(imgUrl);
					BufferedImage image = null;
					image = ImageIO.read(file);
					int height = image.getHeight();
					int width = image.getWidth();

					para.append("<img src=temp/" + fileName + " style=width:"
							+ width + "px;height:" + height + "px />");
				}
			}
			para.append("<br/>");
			sb.append(para);
		}
		return sb.toString();

	}

	/**
	 * 将wmf图片转成jpg图片
	 * 
	 * @param filePath
	 * @throws Exception
	 */
//	public static String wmfToJpg(String wmfPath) throws Exception {
//		File wmf = new File(wmfPath);
//		FileInputStream wmfStream = new FileInputStream(wmf);
//		ByteArrayOutputStream imageOut = new ByteArrayOutputStream();
//		int noOfByteRead = 0;
//		while ((noOfByteRead = wmfStream.read()) != -1) {
//			imageOut.write(noOfByteRead);
//		}
//		imageOut.flush();
//
//		WMFTranscoder transcoder = new WMFTranscoder();
//		TranscodingHints hints = new TranscodingHints();
//		hints.put(ImageTranscoder.KEY_WIDTH, 20f);
//		hints.put(ImageTranscoder.KEY_HEIGHT, 20f);
//		transcoder.setTranscodingHints(hints);
//		TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(
//				imageOut.toByteArray()));
//		ByteArrayOutputStream svg = new ByteArrayOutputStream();
//		TranscoderOutput output = new TranscoderOutput(svg);
//		transcoder.transcode(input, output);
//		String svgFile = StringUtils.replace(wmfPath, "wmf", "svg");
//		FileOutputStream fileOut = new FileOutputStream(svgFile);
//		fileOut.write(svg.toByteArray());
//		fileOut.flush();
//
//		ImageTranscoder it = new JPEGTranscoder();
//
//		ByteArrayOutputStream jpg = new ByteArrayOutputStream();
//		it.transcode(
//				new TranscoderInput(new ByteArrayInputStream(svg.toByteArray())),
//				new TranscoderOutput(jpg));
//		String jpgFile = StringUtils.replace(wmfPath, "wmf", "png");
//		FileOutputStream jpgOut = new FileOutputStream(jpgFile);
//		jpgOut.write(jpg.toByteArray());
//		jpgOut.flush();
//		return jpgFile;
//	}

	public static void main(String[] a) throws Exception {
		 String list = readDoc2003("C:/Temp/press BUG/VT/","20131106c Free SIM.doc");
		 System.out.println(list);
		// wmfToJpg("d:/test/0.wmf");

//		String s = readDoc2007("d:/test/", "test2007.docx");
		// System.out.println(s);
	}

}