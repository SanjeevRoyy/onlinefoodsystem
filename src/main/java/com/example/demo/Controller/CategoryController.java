package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.table_category;
import com.example.demo.repository.categoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private categoryRepository catRepo;

	
	
	
	
	@GetMapping("/admin/category/view")
	public String viewCategory(Model model,HttpSession session)
	{
		if(session.getAttribute("activeuser")!=null)
		{
		model.addAttribute("categories", catRepo.findAll());
		
		return "admin/category/view";
		}
		return "redirect:/admin/login";
	}
	
	@GetMapping("/admin/category/add")
	  public String addCategoryform()
	  {
	  return "admin/category/add";	
	  }
	
	
   @PostMapping("/admin/category/add")	
   public String addCategory(@RequestParam("title") String title,@RequestParam("image_name") MultipartFile file,
		   @RequestParam("featured")String featured, @RequestParam("active")String active) throws IllegalStateException, IOException
   {
	   Random rand=new Random();
	   String Filename=file.getOriginalFilename();
	   Filename=rand.nextInt(99999)+Filename.replaceAll("\\s", "");
	   
	   
	   file.transferTo( new File("C://Users//Abiral//Documents//workspace-spring-tool-suite-4-4.12.0.RELEASE//onlinefoodsystem//src//main//resources//static//images//"+Filename));
	   
	   table_category cat=new table_category();
	   cat.setActive(active);
	   cat.setFeatured(featured);
	   cat.setImage_name(Filename);
	   cat.setTitle(title);
    catRepo.save(cat);	   
	   
    return "redirect:/admin/category/view";
   }
	
	@GetMapping("/admin/category/edit")
	  public String editCategoryform(@RequestParam Long id,Model model )
	  {
		model.addAttribute("category",catRepo.findById(id));
	  return "admin/category/edit";	
	  }
	
	
	@GetMapping("/admin/category/delete")
	public String deleteCategory(Long id)
	{
		catRepo.deleteById(id);
	 return "redirect:/admin/category/view";	
	}
	

	
	@PostMapping("/admin/category/update")
	  public String updateCategory(@RequestParam("title") String title,@RequestParam("image_name") MultipartFile file,
			   @RequestParam("featured")String featured, @RequestParam("active")String active,@RequestParam("id") long id) throws IllegalStateException, IOException
	   {
		   table_category cat=new table_category();
		   
		   table_category temp=new table_category();
		   temp=catRepo.getById(id);
                		   
		   
		   if(!file.isEmpty())
		   {
			   Random rand=new Random();
			   String Filename=file.getOriginalFilename();
			   Filename=rand.nextInt(99999)+Filename.replaceAll("\\s", "");
		   file.transferTo( new File("C://Users//Abiral//Documents//workspace-spring-tool-suite-4-4.12.0.RELEASE//onlinefoodsystem//src//main//resources//static//images//"+Filename));
		   cat.setImage_name(Filename);
		   }
		   else
		   {
		   cat.setImage_name(temp.getImage_name());
		   }
		   cat.setActive(active);
		   cat.setFeatured(featured);
		   
		   cat.setTitle(title);
		   cat.setId(id);
	    catRepo.save(cat);	   
		   
		   return "redirect:/admin/category/view";
	   
	
	
}
}



