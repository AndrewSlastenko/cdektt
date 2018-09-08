package com.andrews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrews.dao.UserDAO;
import com.andrews.model.User;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	public UserDAO userDAO;

	public List<User> findAll() {
		return userDAO.findAll();
	}

	public void insertUser(User user) {
		userDAO.insertUser(user);
	}

	public List<User> filterAll(String reg){
		return userDAO.filterAll(reg);
	}
	
	
}
