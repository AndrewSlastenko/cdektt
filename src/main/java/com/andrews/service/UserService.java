package com.andrews.service;

import java.util.List;

import com.andrews.model.User;

public interface UserService {
	List<User> findAll();
	void insertUser(User user);
	List<User> filterAll(String reg) ;
}
