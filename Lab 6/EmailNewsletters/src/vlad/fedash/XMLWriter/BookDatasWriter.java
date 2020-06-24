package vlad.fedash.XMLWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import vlad.fedash.entity.BookDatas;

@XmlRootElement
public class BookDatasWriter {
	private List<BookDatas> list;

	public BookDatasWriter() {
		this.list = new ArrayList<>();
	}

	public BookDatas[] getList() {
		return list.toArray(new BookDatas[0]);
	}

	@XmlElement(name = "AllBookDatasList")
	public void setList(BookDatas[] book) {
		list = new ArrayList<>(Arrays.asList(book));
	}

	public boolean addBookDatas(BookDatas book) {
		return list.add(book);
	}

	public void WriteToXML(String book) {
		File file = new File(book);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ReaderWriter.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(this, file);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
