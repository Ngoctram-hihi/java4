package poly.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Boolean getAdmin() {
		return Admin;
	}
	public void setAdmin(Boolean admin) {
		Admin = admin;
	}
	@Id
	@Column(name="id")
	private String id;
	@Column(name="Password")
	private String Password;
	@Column(name="Fullname")
	private String Fullname;
	@Column(name="Email")
	private String Email;
	@Column(name="Admin")
	private Boolean Admin;
	
	public User(String id, String password, String fullname, String email, Boolean admin) {
		super();
		this.id = id;
		Password = password;
		Fullname = fullname;
		Email = email;
		Admin = admin;
	}
	public User() {
		super();
	}

}
