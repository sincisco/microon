package com.zijin.microon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zijin.microon.dao.UserMapper;
import com.zijin.microon.model.User;
import com.zijin.microon.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public List<User> getUsers() {
		return null;
	}

	public int insert(User userInfo) {
		
		int result = userMapper.insert(userInfo);
		
		System.out.println(result);
		return result;
	}

}
