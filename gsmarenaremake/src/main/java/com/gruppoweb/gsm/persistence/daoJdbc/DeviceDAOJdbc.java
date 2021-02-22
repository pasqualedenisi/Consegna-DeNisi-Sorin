package com.gruppoweb.gsm.persistence.daoJdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gruppoweb.gsm.model.Device;
import com.gruppoweb.gsm.persistence.DBSource;
import com.gruppoweb.gsm.persistence.dao.DeviceDAO;


public class DeviceDAOJdbc implements DeviceDAO {

	DBSource source;
	
	public DeviceDAOJdbc(DBSource source) {
		super();
		this.source = source;
	}

	@Override
	public void save(Device device) {
		try {
			Connection conn = source.getConnection();
			String query = "INSERT INTO device (_name, _serial_number, _brand, _type, _cpu, _ram, _release_date, _rom, _display)\n"
					+ "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, device.getName());
			statement.setString(2, device.getSerialNumber());
			statement.setInt(3, device.getBrand());
			statement.setInt(4, device.getType());
			statement.setString(5, device.getCpu());
			statement.setString(6, device.getRam());
			statement.setDate(7, device.getReleaseDate());
			statement.setString(8, device.getRom());
			statement.setString(9, device.getDisplay());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Device findByPrimaryKey(Integer idToFind) {
		Device toReturn;
		try {
			Connection conn = source.getConnection();
			String query = "select * from device where _id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idToFind);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("_id");
				String name = rs.getString("_name");
				String serialNumber = rs.getString("_serial_number");
				Integer brand = rs.getInt("_brand");
				Integer type = rs.getInt("_type");
				String cpu = rs.getString("_cpu");
				String ram = rs.getString("_ram");
				Date releaseDate = rs.getDate("_release_date");
				String rom = rs.getString("_rom");
				String display = rs.getString("_display");
				toReturn = new Device(name, serialNumber, brand, type, cpu, ram, releaseDate, rom, display);
				return toReturn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Device> findAll() {
		ArrayList<Device> toReturn = new ArrayList<Device>();
		try {
			Connection conn = source.getConnection();
			String query = "select * from device";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("_name");
				String serialNumber = rs.getString("_serial_number");
				Integer brand = rs.getInt("_brand");
				Integer type = rs.getInt("_type");
				String cpu = rs.getString("_cpu");
				String ram = rs.getString("_ram");
				Date releaseDate = rs.getDate("_release_date");
				String rom = rs.getString("_rom");
				String display = rs.getString("_display");
				toReturn.add(new Device(name, serialNumber, brand, type, cpu, ram, releaseDate, rom, display));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	@Override
	public void update(Device device) {
		try {
			Connection connection = source.getConnection();
			String update = "UPDATE device SET _name = ?, _serial_number = ?, _brand = ?, _type = ? WHERE _id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, device.getName());
			statement.setString(2, device.getSerialNumber());
			statement.setInt(3, device.getBrand());			
			statement.setInt(4, device.getType());
			statement.setInt(5, device.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	

	@Override
	public void delete(Device device) {
		try {
			Connection connection = source.getConnection();
			String update = "DELETE FROM device WHERE _id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, device.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Device> findAllByType(Integer type) {
		ArrayList<Device> toReturn = new ArrayList<Device>();
		try {
			Connection conn = source.getConnection();
			String query = "select * from device where _type = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, type);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("_name");
				String serialNumber = rs.getString("_serial_number");
				Integer brand = rs.getInt("_brand");
				String cpu = rs.getString("_cpu");
				String ram = rs.getString("_ram");
				Date releaseDate = rs.getDate("_release_date");
				String rom = rs.getString("_rom");
				String display = rs.getString("_display");
				toReturn.add(new Device(name, serialNumber, brand, type, cpu, ram, releaseDate, rom, display));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

}
