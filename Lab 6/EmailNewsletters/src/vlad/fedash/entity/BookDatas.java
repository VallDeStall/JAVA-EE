package vlad.fedash.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookdatas")
public class BookDatas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ide;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	
	private Reader reader;

	private String authorOfBook;

	private String titleOfBook;

	private int yearOfEdition;

	public BookDatas() {
	}

	public BookDatas(Reader reader, String authorOfBook, String titleOfBook, int yearOfEdition) {
		this.reader = reader;
		this.authorOfBook = authorOfBook;
		this.titleOfBook = titleOfBook;
		this.yearOfEdition = yearOfEdition;
	}

	public int getIde() {
		return ide;
	}

	public String getAuthorOfBook() {
		return authorOfBook;
	}

	public void setAuthorOfBook(String authorOfBook) {
		this.authorOfBook = authorOfBook;
	}

	public String getTitleOfBook() {
		return titleOfBook;
	}

	public void setTitleOfBook(String titleOfBook) {
		this.titleOfBook = titleOfBook;
	}

	public int getYearOfEdition() {
		return yearOfEdition;
	}

	public void setYearOfEdition(int yearOfEdition) {
		this.yearOfEdition = yearOfEdition;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	@Override
	public String toString() {
		return getIde() + " " + getAuthorOfBook() + " " + getTitleOfBook() + " " + getYearOfEdition() + " "	+ getReader();
	}

}
