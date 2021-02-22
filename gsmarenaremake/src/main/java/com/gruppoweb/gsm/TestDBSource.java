package com.gruppoweb.gsm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gruppoweb.gsm.persistence.DBManager;

public class TestDBSource {

	public static void main(String[] args) {
		try {
			Connection c = DBManager.getDataSource().getConnection();
			String query = "select * from app_user;";
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery(query);
			
			StringBuffer sb = new StringBuffer();
			
			while (result.next()) {
				String name = result.getString(2);
				String cognome = result.getString(3);
				String email = result.getString(4);
				String tipo = result.getString(5);
				sb.append(name + cognome + email + tipo + "\n");
			}
			System.out.println(sb.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
