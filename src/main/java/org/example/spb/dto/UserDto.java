package org.example.spb.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDto {
	@Size(min = 2, max = 40)
	@NotEmpty
	private String firstName;
	
	@Size(min = 2, max = 40)
	@NotEmpty
	private String lastName;
	
	@Email
	private String email;
	
	@Size(min = 8, max = 50)
	@NotEmpty
	private String password;
	
	private String confirmedPassword;
	
	public UserDto() {}
	
	public UserDto(String firstName, String lastName, String email, String password, String confirmedPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmedPassword = confirmedPassword;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
}