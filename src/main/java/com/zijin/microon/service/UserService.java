package com.zijin.microon.service;

import java.util.List;

import com.zijin.microon.model.User;

public interface UserService {
	User getUserById(int id);
	
	List<User> getUsers();
	
	int insert(User user);
}
