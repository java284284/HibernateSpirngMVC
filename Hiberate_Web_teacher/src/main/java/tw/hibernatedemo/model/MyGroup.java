package tw.hibernatedemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="groups")
public class MyGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="groups_id")
	private Integer groupId;
	
	@Column(name="groupName")
	private String groupName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="friend_group",
	joinColumns = {@JoinColumn(name="fk_group_id",referencedColumnName = "groups_id")},
	inverseJoinColumns = {@JoinColumn(name="fk_friend_id", referencedColumnName = "friends_id")}
	)
	private Set<Friends> friends = new HashSet<Friends>();
	
	public MyGroup() {
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<Friends> getFriends() {
		return friends;
	}

	public void setFriends(Set<Friends> friends) {
		this.friends = friends;
	}

}
