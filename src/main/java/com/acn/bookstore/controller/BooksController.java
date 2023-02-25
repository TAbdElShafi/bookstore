package com.acn.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acn.bookstore.model.Book;
import com.acn.bookstore.service.BooksService;

@RestController
public class BooksController {
	@Autowired
	BooksService booksService;

	@GetMapping("/books")
	private List<Book> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("/book/{bookId}")
	private Book getBooks(@PathVariable("bookId") int bookId) {
		return booksService.getBookById(bookId);
	}

	@DeleteMapping("/book/{bookId}")
	private void deleteBook(@PathVariable("bookId") int bookId) {
		booksService.delete(bookId);
	}

	@PostMapping("/book")
	private int saveBook(@RequestBody Book book) {
		booksService.saveOrUpdate(book);
		return book.getBookId();
	}

	@PutMapping("/book")
	private Book update(@RequestBody Book book) {
		booksService.saveOrUpdate(book);
		return book;
	}

}
