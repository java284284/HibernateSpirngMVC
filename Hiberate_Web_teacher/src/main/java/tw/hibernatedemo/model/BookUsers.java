package tw.hibernatedemo.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bookUsers")
public class BookUsers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")  // 可省略，因為跟 table 欄位名稱相同
	private int id;

//	@Column(name="username")  // 可省略，因為跟 table 欄位名稱相同
	private String username;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookUsers", cascade = CascadeType.ALL)
	private Set<Books> books = new LinkedHashSet<Books>();

	public BookUsers() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
	}

}
