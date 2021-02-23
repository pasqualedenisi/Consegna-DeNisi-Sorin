package com.gruppoweb.gsm.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gruppoweb.gsm.model.Device;
import com.gruppoweb.gsm.persistence.Constants;
import com.gruppoweb.gsm.persistence.DBManager;
import com.gruppoweb.gsm.persistence.dao.DeviceDAO;

@Controller
public class SmartphoneController {
	
	@GetMapping("/smartphones")
	public String showSmartphones(Model model) {
		DeviceDAO dao = DBManager.getInstance().deviceDAO();
		List<Device> smartphoneList = dao.findAllByType(Constants.smartphoneTypeID);
		model.addAttribute("smartphoneListPassed", smartphoneList);
		return "smartphones";
	}
	
	@PostMapping("/writeDevice")
	public String insertDevice(@RequestParam String name, @RequestParam String serialnumber, 
			@RequestParam String brand, @RequestParam String type, @RequestParam String cpu, 
			@RequestParam String ram, @RequestParam String releasedate, @RequestParam String rom, @RequestParam String display) {
//			System.out.println("Name = " + name); //deve stampare il display
//			System.out.println("Type = " + type);
//			System.out.println("Display = " + display); //deve stampare il name
		DeviceDAO dao = DBManager.getInstance().deviceDAO();
		Integer brandNumber = 0, typeNumber = 0;
		switch (brand){
		case "Samsung":
			brandNumber = Constants.samsungID;
			break;
		case "Apple":
			brandNumber  = Constants.appleID;
			break;
		case "Xiaomi":
			brandNumber = Constants.xiaomiID;
			break;
		}
		switch (type){
		case "Smartphone":
			typeNumber = Constants.smartphoneTypeID;
			break;
		case "Tablet":
			typeNumber  = Constants.TabletTypeID;
			break;
		case "Smartwatch":
			typeNumber = Constants.smartwatchTypeID;
			break;
		case "Laptop":
			typeNumber = Constants.LaptopTypeID;
			break;
		}
		String [] dateString = releasedate.split("-");
		Date date = new Date(Integer.parseInt(dateString[0]), Integer.parseInt(dateString[1]), Integer.parseInt(dateString[2]));
		Device newDevice = new Device(name, serialnumber, brandNumber, typeNumber, cpu, ram, date, rom, display);
		dao.save(newDevice);
		return "smartphones";
	}
	
	@GetMapping("newDevice")
	public String addDevice() {
		return "addDevice";		
	}
}
