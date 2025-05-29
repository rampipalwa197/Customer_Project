package com.cust.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	@NotNull(message = "First name cannot be empty")
	@Size(min = 3,max = 20,message = "First name should be min 3 and max 20 letters")
	private String firstName;
	
	@NotNull(message = "Last name cannot be empty")
	@Size(min = 3,max = 20,message = "Last name should be min 3 and max 20 letters")
	private String lastName;
	
	@NotNull(message = "Age cannot be empty")
	@Min(value = 10,message = "Minimum age should be 10 years")
	@Max(value = 100,message = "Maximum age should be 100 years")
	private int age;
	
	@NotNull(message = "Email cannot be empty")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotNull(message = "Contact cannot be empty")
	@Pattern(regexp = "^[7-9][0-9]{9}$",message = "Contact no must start with 7-9 and 10 digits")
	private String contact;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Orders> orders=new HashSet<Orders>();

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
}
