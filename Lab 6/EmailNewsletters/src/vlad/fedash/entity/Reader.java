package vlad.fedash.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import vlad.fedash.entity.BookDatas;

@Entity
@Table(name = "reader")
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "cardNumber")
	private int cardNumber;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@OneToMany(mappedBy = "reader", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookDatas> bookDatas;

	public Reader() {
	}

	public Reader(int id, String fullName, int cardNumber, String phoneNumber) {
		this.id = id;
		this.fullName = fullName;
		this.cardNumber = cardNumber;
		this.phoneNumber = phoneNumber;
		bookDatas = new ArrayList<BookDatas>();
		}
	
	public Reader(String fullName, int cardNumber, String phoneNumber) {
		this.fullName = fullName;
		this.cardNumber = cardNumber;
		this.phoneNumber = phoneNumber;
		bookDatas = new ArrayList<BookDatas>();
	}

	public void setAutos(List<BookDatas> bookDatas) {
		this.bookDatas = bookDatas;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "vlad.fedash.Reader{" + "id=" + id + ", fullName='" + fullName + '\'' + ", cardNumber=" + cardNumber
				+ ", phoneNumber=" + phoneNumber + '}';
	}

}
