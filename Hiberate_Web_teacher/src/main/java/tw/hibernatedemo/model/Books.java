package tw.hibernatedemo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String booktitle;
	
	private String publicYear;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_user_id")
	private BookUsers bookUsers;

	public Books() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getPublicYear() {
		return publicYear;
	}

	public void setPublicYear(String publicYear) {
		this.publicYear = publicYear;
	}

	public BookUsers getBookUsers() {
		return bookUsers;
	}

	public void setBookUsers(BookUsers bookUsers) {
		this.bookUsers = bookUsers;
	}
	
	

}
