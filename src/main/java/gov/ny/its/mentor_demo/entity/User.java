package gov.ny.its.mentor_demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "passwd")
	private String passwd;

	@Column(name = "is_active")
	private int isActive = 0;  // by establishing the value here will set NULL input values to 0

	/*
	 * mappedBy points to the joined field name in the related class,
	 * and not the table name of this class
	 */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserAddress> addresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public List<UserAddress> getAddresses() {
		return this.addresses;
	}
}
