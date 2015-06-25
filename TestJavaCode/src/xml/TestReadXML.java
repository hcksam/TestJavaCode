package xml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestReadXML {
	public Document document;

	public Document readXML(File file) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();
			return document;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestReadXML trx = new TestReadXML();
		Document document = trx.readXML(new File(
				"C:/Temp/20130601/shop_location.xml"));
		System.out.println(document.getDocumentElement().getNodeName());
		NodeList shops = document.getChildNodes().item(0).getChildNodes();
		for (int i = 0; i < shops.getLength(); i++) {
			Node shop = shops.item(i);
			if (shop.getNodeType() != Node.ELEMENT_NODE)
				continue;
			System.out.println(shop.getNodeName());
			NodeList shopInfos = shop.getChildNodes();
			int c = 1;
			for (int j = 0; j < shopInfos.getLength(); j++) {
				Node shopInfo = shopInfos.item(j);
				if (shopInfo.getNodeType() != Node.ELEMENT_NODE)
					continue;
				String name = shopInfo.getNodeName();
				String value = "";
				NodeList shopDetails = shopInfo.getChildNodes();
				if (shopDetails.getLength() == 1) {
					name += ": ";
					value = shopDetails.item(0).getNodeValue();
					System.out.println(name + value);
				} else {
					System.out.println(name + "_" + c++);
					for (int k = 0; k < shopDetails.getLength(); k++) {
						Node shopDetail = shopDetails.item(k);
						if (shopDetail.getNodeType() != Node.ELEMENT_NODE)
							continue;
						name = shopDetail.getNodeName() + ": ";
						value = (shopDetail.getChildNodes().getLength() > 0) ? shopDetail
								.getChildNodes().item(0).getNodeValue()
								: "";
						System.out.println(name + value);
					}
				}
			}
			System.out.println();
		}

	}
}
