package az.developia.bookshoppinggunelm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
	@GetMapping(path = "/orders")
	public String showOrdersPage() {
		return "orders";
	}

}
