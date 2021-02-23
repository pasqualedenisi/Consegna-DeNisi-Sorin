package com.gruppoweb.gsm.controller;

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
public class SearchController {

	@PostMapping("/search")
	public String showResults(Model model, @RequestParam String keyword) {
		DeviceDAO dao = DBManager.getInstance().deviceDAO();
		List<Device> resultsList = dao.findAllByKeyword(keyword);
		model.addAttribute("resultsListPassed", resultsList);
		return "searchResults";
	}
}
