package az.developia.bookshoppinggunelm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import az.developia.bookshoppinggunelm.dao.BookDAO;
import az.developia.bookshoppinggunelm.model.Book;

@Controller
public class BookController {

	
	@Autowired
	private BookDAO bookDAO;
	
	@GetMapping(path="/books")
	public String showBooks(Model model) {
		List<Book> books = bookDAO.findAll();
		model.addAttribute("books", books);
		return "books";
	}
}
