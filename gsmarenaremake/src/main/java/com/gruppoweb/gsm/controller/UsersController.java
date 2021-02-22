package com.gruppoweb.gsm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gruppoweb.gsm.model.User;
import com.gruppoweb.gsm.persistence.Constants;
import com.gruppoweb.gsm.persistence.DBManager;
import com.gruppoweb.gsm.persistence.dao.UserDAO;

@Controller
public class UsersController {

	@GetMapping("/subscribedUsers")
	public String showUsers(Model model, HttpSession session) {
		UserDAO dao = DBManager.getInstance().userDAO();
		List<User> subscribedUsers = dao.findAll();
		model.addAttribute("usersListPassed", subscribedUsers);
		Integer authorization = (Integer) session.getAttribute("permissions");
		if ( authorization == Constants.adminPermissionsID)
			return "users";
		else return "/";
	}
}
