package org.example.spb.service;

import java.util.List;

public interface CommonService<DTO, K> {
	public K create(DTO dto);
	public DTO getOne(K key);
	public List<DTO> getAll();
	public K update(DTO dto);
	public void delete(K key);
}