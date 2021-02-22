package com.gruppoweb.gsm.persistence.daoJdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gruppoweb.gsm.model.User;
import com.gruppoweb.gsm.persistence.DBSource;
import com.gruppoweb.gsm.persistence.dao.UserDAO;

public class UserDAOJdbc implements UserDAO{

	DBSource source;
	
	public UserDAOJdbc(DBSource source) {
		super();
		this.source = source;
	}

	@Override
	public void save(User user) {
		try {
			Connection conn = source.getConnection();
			String query = "INSERT INTO user (_name, _surname, _email, _type, _password)\n"
					+ "    VALUES (?, ?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setString(2, user.getSurname());
			statement.setString(3, user.getEmail());
			statement.setInt(4, user.getType());
			statement.setString(5, user.getPassword());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findByPrimaryKey(Integer idToFind) {
		User toReturn;
		try {
			Connection conn = source.getConnection();
			String query = "select * from app_user where _id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idToFind);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				String email = rs.getString(4);
				Integer type = rs.getInt(5);
				String password = rs.getString(6);
				toReturn = new User(id, name, surname, email, type, password);
				return toReturn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		ArrayList<User> toReturn = new ArrayList<User>();
		try {
			Connection conn = source.getConnection();
			String query = "select * from app_user";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				String email = rs.getString(4);
				Integer type = rs.getInt(5);
				String password = rs.getString(6);
				toReturn.add(new User(id, name, surname, email, type, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	@Override
	public void update(User user) {
		try {
			Connection connection = source.getConnection();
			String update = "UPDATE app_user SET _name = ?, _surname = ?, _email = ?, _type = ?, _password = ? WHERE _id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, user.getName());
			statement.setString(2, user.getSurname());
			statement.setString(3, user.getEmail());
			statement.setInt(4, user.getType());
			statement.setString(5, user.getPassword());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	

	@Override
	public void delete(User user) {
		try {
			Connection connection = source.getConnection();
			String update = "DELETE FROM app_user WHERE _id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, user.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<User> findAllByType(Integer type) {
		ArrayList<User> toReturn = new ArrayList<User>();
		try {
			Connection conn = source.getConnection();
			String query = "select * from app_user where _type = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, type);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(6);
				toReturn.add(new User(id, name, surname, email, type, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	@Override
	public User getByCredentials(String email, String password) {
		User toReturn;
		try {
			Connection conn = source.getConnection();
			String query = "select * from app_user where _email = ? AND _password = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				Integer type = rs.getInt(5);
				toReturn = new User(id, name, surname, email, type, password);
				return toReturn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
