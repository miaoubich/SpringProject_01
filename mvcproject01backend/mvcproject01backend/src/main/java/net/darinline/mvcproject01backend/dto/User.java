package net.darinline.mvcproject01backend.dto;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "user_detail")
public class User implements Serializable{
	
	/*We implement Serializable because we are storing data 
	*from the flow scope provided by spring flow and to 
	*prevent a serializable exception
	**/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	@NotBlank(message = "Mandatory field")
	private String firstName;
	@Column(name = "last_name")
	@NotBlank(message = "Mandatory field")
	private String lastName;
	@Email
	private String email;
	@Column(name = "contact_number")
	@NotBlank(message = "Mandatory field")
	private String contactNumber;
	private String role;
	@NotBlank(message = "Mandatory field")
	//@Transient // states to the spring framework that the Object Mapper you are using should not include this password value when converting from Java Object to JSON.
	@Transient
	private String confirmPassword;

	private String password;
	private boolean enabled = true;
	// user_detailed is the parent table and the cart table is child
	// the mappedBy "user" is defined on cart class
	 // cascadeType.All is to add all the children table of the parent table User
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled="
				+ enabled + "]";
	}

}
