package org.example.spb.dao;

import org.example.spb.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateRoleDAO extends HibernateDAO<Role, Integer>implements RoleDAO {
}