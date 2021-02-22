package com.gruppoweb.gsm.persistence;

import com.gruppoweb.gsm.persistence.dao.DeviceDAO;
import com.gruppoweb.gsm.persistence.dao.UserDAO;
import com.gruppoweb.gsm.persistence.daoJdbc.DeviceDAOJdbc;
import com.gruppoweb.gsm.persistence.daoJdbc.UserDAOJdbc;

public class DBManager {

	private static DBManager instance;
	static DBSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			dataSource = new DBSource("jdbc:postgresql://localhost:5432/gsm", "postgres", "postgres");
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
		
	}
	
	private DBManager() {
	}
	
	public static DBSource getDataSource() {
		return dataSource;
	}
	
	public static DBManager getInstance() {
		if ( instance == null )
			instance = new DBManager();
		return instance;
	}
	
	public DeviceDAO deviceDAO() {
		return new DeviceDAOJdbc(dataSource);
	}
	
	public UserDAO userDAO() {
		return new UserDAOJdbc(dataSource);
	}
}
