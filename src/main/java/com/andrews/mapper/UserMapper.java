package com.andrews.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.andrews.model.User;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User entity = new User();
		entity.setId(rs.getInt("id"));
		entity.setName(rs.getString("name"));
		return entity;
	}

}
