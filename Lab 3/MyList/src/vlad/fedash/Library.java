package vlad.fedash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Library {
	@XmlElement(name = "myOwnHelper")
	private Map<KeyById, Reader> bookMap;
	
	@XmlElement(name = "LastId")
	private int lastInsertedID = -1;

	public Library() {
		this.bookMap = new HashMap<>();
	}

	public Library(Map<KeyById, Reader> bookMap) {
		super();
		this.bookMap = bookMap;
	}

	public void addBook(KeyById keyById, Reader reader) {
		if (keyById.getId() <= lastInsertedID) {
			keyById.setId(++lastInsertedID);
		} else {
			keyById.setId(++lastInsertedID);
		}
		bookMap.put(keyById, reader);

	}

	public void deleteBook(KeyById keyById) {
		bookMap.remove(keyById);
		if (keyById.getId() >= lastInsertedID) {
			keyById.setId(--lastInsertedID);
		} else {
			keyById.setId(--lastInsertedID);
		}

	}

	public void editBook(KeyById keyById, Reader reader) {
		bookMap.put(keyById, reader);

	}

	public int maxId() {
		int max = 0;
		for (Map.Entry<KeyById, Reader> o : getBooks()) {
			if (max <= o.getKey().getId()) {
				max = o.getKey().getId();
			}
		}
		return max;

	}

	public Set<Map.Entry<KeyById, Reader>> getBooks() {
		return bookMap.entrySet();
	}

	public Set<KeyById> getBooksForKey() {
		return bookMap.keySet();
	}

}
