package com.yazeer.developer.springproject.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;
@Service
public class Utils {

	
	public String generateUserId() {
		return UUID.randomUUID().toString();
		}
}
