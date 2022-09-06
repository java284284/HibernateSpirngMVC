package tw.hibernatedemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="friends")
public class Friends {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="friends_id")
	private int friendId;
	
	@Column(name="friendName")
	private String friendName;
	
	@ManyToMany(mappedBy = "friends")
	private Set<MyGroup> groups = new HashSet<MyGroup>();

	public Friends() {
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public Set<MyGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<MyGroup> groups) {
		this.groups = groups;
	}
	
	

}