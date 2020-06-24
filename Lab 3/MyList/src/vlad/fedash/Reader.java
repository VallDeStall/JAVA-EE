package vlad.fedash;

public class Reader {

	private String fullName;
	private int cardNumber;
	private String phoneNumber;
	private String authorOfBook;
	private String titleOfBook;
	private int yearOfEdition;

	public Reader(String authorOfBook, String titleOfBook, int yearOfEdition, String fullName, int cardNumber,
			String phoneNumber) {
		super();
		this.authorOfBook = authorOfBook;
		this.titleOfBook = titleOfBook;
		this.yearOfEdition = yearOfEdition;
		this.fullName = fullName;
		this.cardNumber = cardNumber;
		this.phoneNumber = phoneNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

}
