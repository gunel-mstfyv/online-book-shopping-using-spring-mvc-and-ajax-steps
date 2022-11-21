package az.developia.bookshoppinggunelm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	@GetMapping(path="/books/new")
	public String openNewBookPage(Model model) {
		Book book=new Book();
		model.addAttribute("book", book);
			return "new-book";
	}
	
	@PostMapping(path="/books/new-book-process")
	public String saveBook(@ModelAttribute(name="book") Book book,Model model) {
		bookDAO.save(book);
		List<Book> books = bookDAO.findAll();
		model.addAttribute("books", books);
	    return "books";
	}
}
