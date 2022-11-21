package az.developia.bookshoppinggunelm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {	
	@GetMapping(path="/customer")
	public String showCustomerPage() {		
		return "customer";
	}
	
}
