package com.yazeer.developer.springproject.userservice;

import com.yazeer.developer.springproject.ui.model.request.UserDetailsRequestModel;
import com.yazeer.developer.springproject.ui.model.response.UserRest;

public interface UserService {

	UserRest createUser(UserDetailsRequestModel userDetails);
}
