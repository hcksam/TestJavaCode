package xml;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Node;

public class TestXMLHandler {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLHandler xmlh = new XMLHandler(new File(
				"C:/Temp/20130601/shop_location.xml"));
		System.out.println(xmlh.getRootElementName());
		ArrayList<Node> shops = XMLHandler.getNodes(xmlh.getRootNodeList());
		for (int i = 0; i < shops.size(); i++) {
			Node shop = shops.get(i);
			System.out.println(shop.getNodeName());
			ArrayList<Node> shopInfos = XMLHandler.getNodes(shop
					.getChildNodes());
			for (int j = 0; j < shopInfos.size(); j++) {
				Node shopInfo = shopInfos.get(j);
				String name = shopInfo.getNodeName();
				String value = "";

				if (shopInfo.getChildNodes().getLength() == 1) {
					name += ": ";
					value = XMLHandler.getSingleNodeValue(shopInfo);
					System.out.println(name + value);
				} else {
					System.out.println(name
							+ ": "
							+ XMLHandler.getSingleAttributeValue(shopInfo));
					ArrayList<Node> shopDetails = XMLHandler.getNodes(shopInfo
							.getChildNodes());
					for (int k = 0; k < shopDetails.size(); k++) {
						Node shopDetail = shopDetails.get(k);
						name = shopDetail.getNodeName() + ": ";
						value = XMLHandler.getSingleNodeValue(shopDetail);
						System.out.println(name + value);
					}
				}
			}
			System.out.println();
		}
	}
}
