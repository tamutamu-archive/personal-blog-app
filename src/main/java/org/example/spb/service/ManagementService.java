package org.example.spb.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.example.spb.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public abstract class ManagementService<DTO, K extends Serializable, E> implements CommonService<DTO, K> {
	@Autowired
	protected DAO<E, K> dao;
}