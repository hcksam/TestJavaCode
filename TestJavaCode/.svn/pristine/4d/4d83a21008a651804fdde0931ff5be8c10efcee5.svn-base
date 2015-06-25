package poi;

import common.CommonData;

import poi.function.POIWordUtil;

public class POIUtilTest {

	public void testReadDoc() {
		try {
			String text = POIWordUtil.readDoc(CommonData.DefaultFile.getPath());
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testReadArrayDoc() throws Exception {
		String[] s = POIWordUtil.readDoc(CommonData.DefaultFile);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	public void testWriteDoc() {
		String wr;
		try {
			wr = POIWordUtil.readDoc(CommonData.DefaultFile.getPath());

			boolean b = POIWordUtil.writeDoc(
					CommonData.DefaultTestFile.getPath(), wr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] arg) throws Exception {
		new POIUtilTest().testReadDoc();
	}
}