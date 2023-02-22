package com.acn.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.acn.bookstore.model.Book;

public interface  BooksRepository extends CrudRepository<Book, Integer>   {

}
