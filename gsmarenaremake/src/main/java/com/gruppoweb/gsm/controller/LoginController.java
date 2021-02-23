package com.gruppoweb.gsm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gruppoweb.gsm.model.User;
import com.gruppoweb.gsm.persistence.DBManager;
import com.gruppoweb.gsm.persistence.dao.UserDAO;

@Controller
public class LoginController {

//	@PostMapping("signin")
//	public String signIn(HttpSession session, @RequestParam String email, @RequestParam String password) {
//		//User logged = access(email, password);
//		//if ( logged != null ) {
//			//session.setAttribute("username", email);
//			//session.setAttribute("permissions", logged.getType());
//		//}
//		//return "welcome";
//	}
	
	@GetMapping("signin")
	public String doThis(HttpSession session) {
		session.setAttribute("permissions", 1);
		return "";
	}
	
	@GetMapping("logout")
	public String disconnect(HttpSession session) {
		session.invalidate();
		return "/";
	}

	//contiene la logica per accedere
	private User access(String email, String password) {
		UserDAO dao = DBManager.getInstance().userDAO();
		User result = dao.getByCredentials(email, password);
		return result;
	}
}
