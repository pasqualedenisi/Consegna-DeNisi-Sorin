package com.gruppoweb.gsm.persistence.dao;

import java.util.List;

import com.gruppoweb.gsm.model.User;

public interface UserDAO {

	public void save(User user); //insert
	public User findByPrimaryKey(Integer idToFind);
	public List<User> findAll();
	public List<User> findAllByType(Integer type);
	public void update(User user);
	public void delete(User user);
	public User  getByCredentials(String email, String password);
}
