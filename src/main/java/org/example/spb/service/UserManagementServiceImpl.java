package org.example.spb.service;

import java.util.List;

import org.example.spb.domain.User;
import org.example.spb.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl extends ManagementService<UserDto, Integer, User>
		implements UserManagementService, UserDetailsService {

	@Override
	public Integer create(UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getOne(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer key) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}