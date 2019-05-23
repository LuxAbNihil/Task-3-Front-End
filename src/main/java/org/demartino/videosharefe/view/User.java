package org.demartino.videosharefe.view;

public class User {
	
	private String username;
	private Long id;
	private String email;
	private String address;
	private String phoneNumber;
	private Short age;
	private String password;
	
	@Override
	public String toString() {
		return "User [username=" + username + ", id=" + id + ", email=" + email + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", age=" + age + ", password=" + password + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	} 
	
	
}
