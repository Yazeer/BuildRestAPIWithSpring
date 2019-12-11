package com.yazeer.developer.springproject.userservice.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yazeer.developer.springproject.shared.Utils;
import com.yazeer.developer.springproject.ui.model.request.UserDetailsRequestModel;
import com.yazeer.developer.springproject.ui.model.response.UserRest;
import com.yazeer.developer.springproject.userservice.UserService;


@Service
public class UserServiceImplementation implements UserService {
	Map<String ,UserRest> users;
	Utils utils;
	
	
	
	public UserServiceImplementation() {
		
	}
 

     @Autowired
	public UserServiceImplementation(Utils utils) {
		this.utils = utils;
	}



	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnvalue = new UserRest();
		returnvalue.setEmail(userDetails.getEmail());
		returnvalue.setFirstname(userDetails.getFirstname());
		returnvalue.setLastname(userDetails.getLastname());

		String userId=utils.generateUserId();
		returnvalue.setUserId(userId);
		
		if(users==null) users=new HashMap<>();
		users.put(userId, returnvalue);
		
		return returnvalue;
	}

}
