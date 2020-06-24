package vlad.fedash;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class FileOperations {
	private static final String filePath = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\MyList\\datas.xml";

	public static Document doc() {
		Document document = null;
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = documentBuilder.parse(filePath);

		} catch (ParserConfigurationException ex) {
			ex.printStackTrace(System.out);
		} catch (SAXException ex) {
			ex.printStackTrace(System.out);
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		}
		return document;

	}

	public static Map<KeyById, Reader> readXmlFile() {
		Document document = doc();
		document.getDocumentElement().normalize();

		NodeList nodeList = document.getElementsByTagName("entry");

		Map<KeyById, Reader> bookMap = new HashMap<KeyById, Reader>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			KeyById keyId = getKeyId(node);
			Reader reader = getReaderId(node);
			bookMap.put(keyId, reader);
		}
		return bookMap;
	}

	public static KeyById getKeyId(Node node) {
		String keyId = getTagValue("id", (Element) node);
		KeyById keyById = new KeyById(Integer.parseInt(keyId));
		return keyById;

	}

	public static Reader getReaderId(Node node) {
		String authorOfBook = getTagValue("authorOfBook", (Element) node);
		String titleOfBook = getTagValue("titleOfBook", (Element) node);
		String yearOfEdition = getTagValue("yearOfEdition", (Element) node);
		String fullName = getTagValue("fullName", (Element) node);
		String cardNumber = getTagValue("cardNumber", (Element) node);
		String phoneNumber = getTagValue("phoneNumber", (Element) node);

		int yearOfEditNum = Integer.parseInt(yearOfEdition);
		int cardNum = Integer.parseInt(cardNumber);

		Reader reader = new Reader(authorOfBook, titleOfBook, yearOfEditNum, fullName, cardNum, phoneNumber);
		return reader;

	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodeList.item(0);
		return node.getNodeValue();
	}

	public static void convertObjectToXml(Library library) {
		try {
			JAXBContext context = JAXBContext.newInstance(Library.class);
			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			marshaller.marshal(library, new File(filePath));
			writeDocument();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void writeDocument() throws TransformerFactoryConfigurationError {
		try {
			Document document = doc();
			Source domSource = new DOMSource(document);
			StreamResult fileResult = new StreamResult(new File(filePath));
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.transform(domSource, fileResult);
		} catch (TransformerException e) {
			e.printStackTrace(System.out);
		}
	}
}
