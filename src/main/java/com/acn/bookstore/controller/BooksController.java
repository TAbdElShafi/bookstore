package com.acn.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.bookstore.model.Book;
import com.acn.bookstore.service.BooksService;

@RestController
public class BooksController {
	@Autowired
	BooksService booksService;

	@GetMapping("/book")
	private List<Book> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("/book/{bookid}")
	private Book getBooks(@PathVariable("bookid") int bookid) {
		return booksService.getBooksById(bookid);
	}

	@DeleteMapping("/book/{bookid}")
	private void deleteBook(@PathVariable("bookid") int bookid) {
		booksService.delete(bookid);
	}

	@PostMapping("/books")
	private int saveBook(@RequestBody Book books) {
		booksService.saveOrUpdate(books);
		return books.getBookid();
	}

	@PutMapping("/books")
	private Book update(@RequestBody Book books) {
		booksService.saveOrUpdate(books);
		return books;
	}

}
