package org.example.spb.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.example.spb.dao.RoleDAO;
import org.example.spb.dao.UserDAO;
import org.example.spb.domain.Role;
import org.example.spb.domain.User;
import org.example.spb.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl extends ManagementService<UserDto, Integer, UserDAO, RoleDAO>
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
	public List<UserDto> getAll() {
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
		Collection<Role> roles = new HashSet<>();
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		User user = mainDao.getByEmail(username).get(0);
		
		roles = user.getRoles();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

	@Override
	public boolean createAccount(UserDto dto) {
		if (validateIfExists(dto.getEmail())) {
			return false;
		} else {
			mainDao.create(new User(dto, Role.USER));
			return true;
		}
	}
	
	private boolean validateIfExists(String email) {
		if (mainDao.getByEmail(email).size() == 0) {
			return false;
		} else {
			return true;
		}
	}
}