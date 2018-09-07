package com.andrews.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.andrews.mapper.UserMapper;
import com.andrews.model.User;

public class UserDAOImplementation implements UserDAO {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public List<User> findAll() {
		String sql = "SELECT * FROM theone";
		return jdbcTemplate.query(sql, new UserMapper());
	}

	public void insertUser(User user) {
		String sql = "INSERT INTO theone(name) VALUES (?)";
		jdbcTemplate.update(sql, user.getName());
	}

	@Override
	public List<User> filterAll(String reg) {
		reg = "%" + reg + "%";
		String sql = "SELECT * FROM theone WHERE cast(id as char(45)) like ? or name like ?";
		return jdbcTemplate.query(sql, new UserMapper(), reg, reg);
	}


}
