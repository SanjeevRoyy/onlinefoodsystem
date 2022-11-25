package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.table_category;
import com.example.demo.model.table_food;
import com.example.demo.repository.categoryRepository;
import com.example.demo.repository.foodRepository;
@Controller
public class FoodController {
	
	@Autowired
	private foodRepository foodRepo;
 
	@Autowired
	private categoryRepository catRepo;
	@GetMapping("/admin/food/view")
	public String viewFood(Model model1)
	{
		model1.addAttribute("food",foodRepo.findAll() );
		return "admin/food/view";
	}
	
	
	@GetMapping("/admin/food/add")
	public String addFoodform(Model model)
	{
		model.addAttribute("categories",catRepo.findAll());
		return "admin/food/add";
	}
	
	
	@GetMapping("/admin/food/delete")
	public String deleteCategory(Long id)
	{
		foodRepo.deleteById(id);
	 return "redirect:/admin/food/view";	
	}
	
	@GetMapping("/admin/food/edit")
	  public String editfoodform(Model model, @RequestParam Long id)
	  {
		model.addAttribute("categories",catRepo.findAll());
		model.addAttribute("food",foodRepo.findById(id));
		
	  return "admin/food/edit";	
	  }
	
	
	
	@PostMapping("/admin/food/add")	
	   public String addFood(@RequestParam("title") String title,@RequestParam("description") String description,@RequestParam("price") Long price,@RequestParam("image") MultipartFile file,
			   @RequestParam("category") String category,@RequestParam("featured")String featured, @RequestParam("active")String active) throws IllegalStateException, IOException
	   {
		   Random rand=new Random();
		   String Filename=file.getOriginalFilename();
		   Filename=rand.nextInt(99999)+Filename.replaceAll("\\s", "");
		   
		   
		   file.transferTo( new File("C://Users//Abiral//Documents//workspace-spring-tool-suite-4-4.12.0.RELEASE//onlinefoodsystem//src//main//resources//static//images//"+Filename));
		   
		   table_food fat=new table_food();
		   fat.setActive(active);
		   fat.setFeatured(featured);
		   fat.setSelect_image(Filename);
		   fat.setTitle(title);
		   fat.setDescription(description);
		   fat.setPrice(price);
		   fat.setCategory(category);
	       foodRepo.save(fat);
	       
	       return "redirect:/admin/food/view";
	   }
	
	
	
	@PostMapping("/admin/food/update")	
	   public String updateFood(@RequestParam("title") String title,@RequestParam("description") String description,@RequestParam("price") Long price,@RequestParam("image") MultipartFile file,
			   @RequestParam("category") String category,@RequestParam("featured")String featured, @RequestParam("active")String active,@RequestParam("id") long id) throws IllegalStateException, IOException
	   {
		  table_food fat=new table_food();
		   
		   table_food temp=new table_food();
		   temp=foodRepo.getById(id);
		
		   if(!file.isEmpty())
		   {
		   Random rand=new Random();
		   String Filename=file.getOriginalFilename();
		   Filename=rand.nextInt(99999)+Filename.replaceAll("\\s", "");
		   
		   fat.setSelect_image(Filename);
		   file.transferTo( new File("C://Users//Abiral//Documents//workspace-spring-tool-suite-4-4.12.0.RELEASE//onlinefoodsystem//src//main//resources//static//images//"+Filename));
		   
		   }
		   else
		   {
		   fat.setSelect_image(temp.getSelect_image());
		   
		   }
		   fat.setTitle(title);
		   fat.setActive(active);
		   fat.setFeatured(featured);
		   
		   
		   fat.setDescription(description);
		   fat.setPrice(price);
		   fat.setCategory(category);
	       foodRepo.save(fat);
	       
	       return "redirect:/admin/food/view";
	   }
	
	
	
	

	
}
