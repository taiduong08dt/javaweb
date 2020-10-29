package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel user = new UserModel();
			user.setId(rs.getLong("id"));
			user.setUserName(rs.getString("userName"));
			user.setFullName(rs.getString("fullName"));
			user.setPassword(rs.getString("password"));
			user.setStatus(rs.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
