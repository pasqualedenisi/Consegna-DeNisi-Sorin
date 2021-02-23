package com.gruppoweb.gsm.persistence.dao;

import java.util.List;

import com.gruppoweb.gsm.model.Device;



public interface DeviceDAO {

	public void save(Device device); //insert
	public Device findByPrimaryKey(Integer idToFind);
	public List<Device> findAll();
	public List<Device> findAllByType(Integer type);
	public List<Device> findAllByKeyword(String keyword);
	public void update(Device device);
	public void delete(Device device);
}
