
import java.io.InputStream;

import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLTest {
	public static void main(String[] args) {
		try {
			URL url = new URL(
					"http://www.cha.go.kr/cha/SearchKindOpenapiList.do");
			InputStream stream = url.openStream();
			char ch = 0;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stream);
			doc.getDocumentElement().normalize();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("item");
			System.out.println("----------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("문화재 번호: " + getTagValue("crltsnoNm", eElement));
					System.out.println("문화재 이름: " + getTagValue("ccbaMnm1", eElement));
					System.out.println("문화재 한자명: " + getTagValue("ccbaMnm2", eElement));
					System.out.println();
				}
			} // end for

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
}
