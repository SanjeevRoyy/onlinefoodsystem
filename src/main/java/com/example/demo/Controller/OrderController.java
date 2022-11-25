package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.table_order;
//import com.example.demo.model.tbl_order;
import com.example.demo.repository.orderRepository;

@Controller
public class OrderController {

	@Autowired
	private orderRepository orderRepo;

	@GetMapping("/admin/order/view")
	public String manageFood(Model model2)
	{
		model2.addAttribute("order",orderRepo.findAll() );
		return "admin/order/view";
	}
	
	@GetMapping("/admin/order/edit")
	  public String editorderform()
	  {
	  return "admin/order/edit";	
	  }
	
	@PostMapping("/confirm_order")
	public String SaveOrder() {
		return "redirect:/order";
	}
}
