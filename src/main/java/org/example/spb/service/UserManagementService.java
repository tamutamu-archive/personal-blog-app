package org.example.spb.service;

import org.example.spb.dto.UserDto;

public interface UserManagementService extends CommonService<UserDto, Integer> {
	public boolean createAccount(UserDto dto);
	public Integer getIdByEmail(String email);
}