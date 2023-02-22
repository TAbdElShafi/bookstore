package com.acn.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acn.bookstore.model.Book;
import com.acn.bookstore.repository.BooksRepository;

@Service
public class BooksService {
	@Autowired
	BooksRepository booksRepository;

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
	}

	public Book getBooksById(int id) {
		return booksRepository.findById(id).get();
	}

	public void saveOrUpdate(Book book) {
		booksRepository.save(book);
	}

	public void delete(int id) {
		booksRepository.deleteById(id);
	}

}
