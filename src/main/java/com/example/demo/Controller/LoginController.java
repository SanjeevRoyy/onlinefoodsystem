package com.example.demo.Controller;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.model.table_admin;
import com.example.demo.repository.adminRepository;

@Controller
public class LoginController {


	
	@Autowired
	private adminRepository adminRepo;
	
	@GetMapping("/admin/login")
	public String showLoginForm() {
		
		
		return "admin/login";
	}
	
	@PostMapping("/admin/login")
	public String userLogin(table_admin admin ,Model model,HttpSession session) {
		admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
		table_admin u=adminRepo.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());
		if(u!=null)
		{
			session.setAttribute("activeuser",u.getUsername());
			session.setMaxInactiveInterval(220);
			return "redirect:/adminpanel";
		}
		   
		model.addAttribute("message","Incorrect Username Or Password");
		return "redirect:/admin/login";
		
	}
	
	
	@GetMapping("/admin/logout")
	public String LogOutFunction(HttpSession session)
	{
		session.invalidate();
	 return "redirect:/admin/login";	
	}
}
