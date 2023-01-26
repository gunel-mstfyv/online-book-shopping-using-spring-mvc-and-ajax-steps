package az.developia.bookshoppinggunelm.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import az.developia.bookshoppinggunelm.config.MySession;
import az.developia.bookshoppinggunelm.dao.BookDAO;
import az.developia.bookshoppinggunelm.file.StorageService;
import az.developia.bookshoppinggunelm.model.Book;

@Controller
public class BookController {

	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private MySession mySession;
	
	
	@Autowired
	private StorageService storageService;

	@GetMapping(path = "/books")
	public String showBooks(Model model) {
		// List<Book> books = bookDAO.findAll();
		List<Book> books = bookDAO.findAllByUsername(mySession.getUsername());
		model.addAttribute("books", books);
		model.addAttribute("username", "Username:  " + mySession.getUsername());
		return "books";
	}

	@GetMapping(path = "/books/new")
	public String openNewBookPage(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		model.addAttribute("header", "New Book");
		return "new-book";
	}

	@PostMapping(path = "/books/new-book-process")
	public String saveBook(@Valid @ModelAttribute(name = "book") Book book,
			@RequestParam(value = "imageFile", required=false) MultipartFile imageFile,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "new-book";
		}
		book.setImage("book.jpg");
		book.setUsername(mySession.getUsername());
		book.setImage(storageService.store(imageFile));
		bookDAO.save(book);
		List<Book> books = bookDAO.findAll();
		model.addAttribute("books", books);
		return "redirect:/books";
	}

	@GetMapping(path = "/books/delete/{id}")
	public String deleteBook(@PathVariable(name = "id") Integer id, Model model) {
		boolean bookExists = bookDAO.findById(id).isPresent();
		if (bookExists) {
			bookDAO.deleteById(id);
		} else {
		}
		List<Book> books = bookDAO.findAll();
		model.addAttribute("books", books);
		return "redirect:/books";
	}

	@GetMapping(path = "/books/edit/{id}")
	public String editBook(@PathVariable(name = "id") Integer id, Model model) {
		Optional<Book> bookOptional = bookDAO.findById(id);
		boolean bookExists = bookOptional.isPresent();
		Book book = new Book();
		if (bookExists) {
			book = bookOptional.get();
		} else {
		}
		model.addAttribute("book", book);
		model.addAttribute("header", "Edit The Book");
		return "new-book";
	}

}
