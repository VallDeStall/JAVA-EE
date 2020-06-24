package vlad.fedash.XMLWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import vlad.fedash.entity.Reader;

@XmlRootElement
public class ReaderWriter {
	private List<Reader> list;

	public ReaderWriter() {
		this.list = new ArrayList<>();
	}

	public Reader[] getList() {
		return list.toArray(new Reader[0]);
	}

	@XmlElement(name = "AllReadersList")
	public void setList(Reader[] r) {
		list = new ArrayList<>(Arrays.asList(r));
	}

	public boolean addReader(Reader r) {
		return list.add(r);
	}

	public void WriteToXML(String r) {
		File file = new File(r);
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
