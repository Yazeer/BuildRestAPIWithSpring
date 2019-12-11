package com.yazeer.developer.springproject.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	@NotNull(message="First name cannot be null")
	@Size(min=2, message = "First name must not be less than 2 characters")
	private String firstname;
	
	@NotNull(message="Last name cannot be null")
	@Size(min=2, message = "Last name must not be less than 2 characters")
	private String lastname;

	

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFirstname() {
		
		return firstname;
	}


	public String getLastname() {
		
		return lastname;
	}

	

}
