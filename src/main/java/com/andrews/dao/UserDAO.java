package com.andrews.dao;

import java.util.List;

import com.andrews.model.User;

public interface UserDAO {
	List<User> findAll();
	void insertUser(User user);
	List<User> filterAll(String reg);
}
