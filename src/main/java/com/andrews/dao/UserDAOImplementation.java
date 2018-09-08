package com.andrews.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.andrews.mapper.UserMapper;
import com.andrews.model.User;

public class UserDAOImplementation implements UserDAO {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public List<User> findAll() throws DataAccessException {
		String sql = "SELECT * FROM theone";
		return jdbcTemplate.query(sql, new UserMapper());
		
	}

	public void insertUser(User user) throws DataAccessException {
		String sql = "INSERT INTO theone(name) VALUES (?)";
		jdbcTemplate.update(sql, user.getName());

	}

	public List<User> filterAll(String reg) throws DataAccessException {
		reg = "%" + reg + "%";
		String sql = "SELECT * FROM theone WHERE cast(id as char(45)) like ? or name like ?";
		return jdbcTemplate.query(sql, new UserMapper(), reg, reg);
	}


}
