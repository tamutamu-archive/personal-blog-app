package org.example.spb.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public abstract class ManagementService<DTO, K extends Serializable, mainDAO, auxDAO> implements CommonService<DTO, K> {
	@Autowired
	protected mainDAO mainDao;
	
	@Autowired
	protected auxDAO auxDao;
}