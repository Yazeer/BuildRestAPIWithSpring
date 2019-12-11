package com.yazeer.developer.springproject.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yazeer.developer.springproject.ui.model.request.UpdateUserDetailsRequestModel;
import com.yazeer.developer.springproject.ui.model.request.UserDetailsRequestModel;
import com.yazeer.developer.springproject.ui.model.response.UserRest;
import com.yazeer.developer.springproject.userservice.UserService;
import com.yazeer.developer.springproject.userservice.implementation.UserServiceImplementation;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

	Map<String ,UserRest> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", required = false) String sort) {
		return "get user was called with page = " + page + "and Limit =" + limit + "sort =" + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

		if(users.containsKey(userId)) {
			return new ResponseEntity<UserRest>(users.get(userId),HttpStatus.OK);
		}
		return new ResponseEntity<UserRest>( HttpStatus.NO_CONTENT);
	}

	@PostMapping(
			consumes =  { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			}, 
			produces =  { 
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					}  )
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
	{
		UserRest returnvalue = userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(returnvalue,HttpStatus.OK);
	}

	@PutMapping(path="/{userId}", consumes =  { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			}, 
			produces =  { 
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					}  )
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails)
	{
		 UserRest storedUserDetails = users.get(userId);
		 storedUserDetails.setFirstname(userDetails.getFirstname());
		 storedUserDetails.setLastname(userDetails.getLastname());

		 users.put(userId, storedUserDetails);
		 
		 return storedUserDetails;
	}

	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id)
	{
		users.remove(id);
		
		return ResponseEntity.noContent().build();
	}


}
