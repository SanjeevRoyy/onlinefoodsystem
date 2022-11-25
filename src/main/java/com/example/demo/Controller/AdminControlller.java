package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.table_admin;
import com.example.demo.repository.adminRepository;
import com.example.demo.repository.categoryRepository;
import com.example.demo.repository.foodRepository;
import com.example.demo.repository.orderRepository;
@Controller
public class AdminControlller {

	
	
			
	

	@Autowired
	private adminRepository manageadminRepo;
	@Autowired
 private categoryRepository catRepo;	
	
	@Autowired
	private foodRepository foodRepo;
	
	@Autowired
	private orderRepository orderRepo;
	

	@GetMapping("/admin/view")
	public String loginPage()
	{
		return "admin/view";
	}
	
	
	@PostMapping("/admin/view")
	public String manageAdmin(Model model3,HttpSession session)
	{	if(session.getAttribute("admin")!=null)
	{
		model3.addAttribute("admin",manageadminRepo.findAll() );
		return "admin/view";
	}
	return "redirect:/admin/login";
}
	
	@GetMapping("/adminpanel")
	public String Indexpage(Model model,HttpSession session) 
	{	
		
			if(session.getAttribute("activeuser")!=null)
			{
			model.addAttribute("admin", manageadminRepo.findAll());
			model.addAttribute("Count",catRepo.count());
			model.addAttribute("foodCount",foodRepo.count());
			return "admin/dashboard";
			}
			return "redirect:/admin/login";
			
			
		
		
		
		
	}
	
	
	
	@GetMapping("/admin/update-admin")
	  public String editadminform()
	  {
	  return "admin/update-admin";	
	  }
	@GetMapping("/admin/update-password")
	  public String editadminpasswordform()
	  {
	  return "admin/update-password";	
	  }
	@GetMapping("/admin/add")
	public String addadminform() 
	{
		return "admin/add";
	}
	
	
	@GetMapping("/admin/delete")
	public String deleteCategory(Long id)
	{
		manageadminRepo.deleteById(id);
	 return "redirect:/admin/view";	
	}
	
	
	@PostMapping("/admin/add")	
	   public String addAdmin(@RequestParam("fullname") String fullname,@RequestParam("username") String username,@RequestParam("password") String password) throws IllegalStateException, IOException
	   {
		   
		  
		   table_admin ad=new table_admin();
		   ad.setFullname(fullname);
		   ad.setUsername(username);
		   ad.setPassword(password);
		   ad.setFeatured("Yes");
		   ad.setActive("No");
	       manageadminRepo.save(ad);	   
		   return "redirect:/admin/view";
	   }
	


}

