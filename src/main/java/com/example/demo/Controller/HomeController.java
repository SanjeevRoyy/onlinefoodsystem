package com.example.demo.Controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.table_admin;
import com.example.demo.model.table_contact;
import com.example.demo.model.table_food;
import com.example.demo.model.table_order;
import com.example.demo.repository.categoryRepository;
import com.example.demo.repository.contactRepository;
import com.example.demo.repository.foodRepository;
import com.example.demo.repository.orderRepository;

@Controller
public class HomeController {

	@Autowired
	contactRepository contRepo;
	@Autowired
	categoryRepository catRepo;
	@Autowired
	foodRepository foodRepo;
	@Autowired
	orderRepository orderRepo;
	@GetMapping("/index")
	public String Dashboard(Model model )
	{
		model.addAttribute("categories",catRepo.findAll());
		model.addAttribute("food",foodRepo.findAll());
		return"index";
	}
	@GetMapping("/low")
	public String Low(@RequestParam long price,Model model) {
		Array arr[];
		List<table_food> foods=foodRepo.findByprice(price);
		model.addAttribute("foodie",foods);
		 System.out.println(price);
		return "food";
		
	}
	
	@GetMapping("/userlogin")
	public String Login()
	{
		return "users/userlogin";
	}
	
	
	@GetMapping("/home")
	public String home() 
	{
		return "index";
	}
	
	
	@GetMapping("/categories")
	public String categories(Model model) 
	{
		model.addAttribute("categories",catRepo.findAll());
		return "categories";
	}
	
	
	@GetMapping("/categories-foods")
	public String foodcategory(@RequestParam String id,Model model) 
	{
		List<table_food> foods=foodRepo.findByCategory(id);
		model.addAttribute("foodie",foods);
		return "category-foods";
	}
	
	
	@GetMapping("/foods")
	public String foods(Model model) 
	{
		model.addAttribute("food",foodRepo.findAll());
		return "foods";
	}
	
	
	
	@GetMapping("/foods-search")
	public String foodsearch() 
	{
		return "foods-search";
	}
	
	@GetMapping("/order")
	public String order(Long id ,Model model) 
	{
		model.addAttribute("orders",foodRepo.findById(id).get());
		
		return "order";
	}
/*	@GetMapping("/low")
	public String low(Long price ,Model model) 
	{
		foodRepo.findByPrice(price);
		
		



	
	  public  void bubbleSort(int[] price) {  
	        int n = Array.getLength(null);  
	        int temp = 0;  
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(price[j-1] > price[j]){  
	                                 //swap elements  
	                                 temp = price[j-1];  
	                                 price[j-1] = price[j];  
	                                 price[j] = temp;  
	                         }  
	                          
	                 }  
	         }  
	  
	    }  
	    public  Main(String[] args) {  
	                int Array[]; 
	                 
	                System.out.println("Array Before Bubble Sort");  
	                for(int i=0; i < Array.length; i++){  
	                        System.out.print(Array[i] + " ");  
	                }  
	                System.out.println();  
	                  
	             //   bubbleSort(Array);//sorting array elements using bubble sort  
	                 
	                System.out.println("Array After Bubble Sort");  
	                for(int i=0; i < Array.length; i++){  
	                        System.out.print(Array[i] + " ");  
	                }  
	   
	          

	
	
}


		
		return "order";
	}
	
	
	
*/
	@GetMapping("/contact")
	public String contact()
	{
		
		return "contact";
	}
	

	@PostMapping("/contact/send")
	public String sendMessage(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("phone")
	String phone,@RequestParam("message")String message) throws IllegalStateException, IOException
	 {
		  table_contact ad=new table_contact();
		
		  ad.setName(name);
		  ad.setEmail(email);
		  ad.setPhone(phone);
		  ad.setMessage(message);
		 
	       contRepo.save(ad);	   
		return "redirect:/contact";
	}
	
	@PostMapping("/confirm/order")
	public String confirmrorder(@RequestParam("food") String food,@RequestParam("price") String price,@RequestParam("qty")
	String qty,@RequestParam("total")String total,@RequestParam("order_date")String order_date,@RequestParam("customer_name") String customer_name,@RequestParam("customer_contact")
	String customer_contact,@RequestParam("customer_email")String customer_email,@RequestParam("customer_address")String customer_address) throws IllegalStateException, IOException
	 {
		  table_order ador=new table_order();
		 ador.setFood(food);
		 ador.setPrice(price);
		 ador.setQty(qty);
		 ador.setTotal(total);
		 ador.setOrder_date(order_date);
		 ador.setStatus("pending");
		 ador.setCustomer_name(customer_name);
		 ador.setCustomer_contact(customer_contact);
		 ador.setCustomer_email(customer_email);
		 ador.setCustomer_address(customer_address);
		 
		
	       orderRepo.save(ador);   
		return "redirect:/foods";
	}


}



