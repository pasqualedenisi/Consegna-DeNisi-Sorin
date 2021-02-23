package com.gruppoweb.gsm.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gruppoweb.gsm.model.Device;
import com.gruppoweb.gsm.persistence.Constants;
import com.gruppoweb.gsm.persistence.DBManager;
import com.gruppoweb.gsm.persistence.dao.DeviceDAO;

public class SearchController {

	@GetMapping("/search")
	public String showSmartphones(Model model) {
		DeviceDAO dao = DBManager.getInstance().deviceDAO();
		List<Device> smartphoneList = dao.findAllByType(Constants.smartphoneTypeID);
		model.addAttribute("smartphoneListPassed", smartphoneList);
		return "smartphones";
	}
}
