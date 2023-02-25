package com.acn.bookstore.service;

import com.acn.bookstore.model.Book;
import com.acn.bookstore.repository.BooksRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class BookServiceT {

    @Mock
    private BooksRepository booksRepository;
    @InjectMocks
    private BooksService booksService;

    private static Book book;

    @BeforeAll
    public void prepareData() {
        book = new Book(1234, "Advanced Java", "James gosling", 800);
    }

    @Test
    public void whenBookExist_thenFindItById() {
        given(booksRepository.findById(1234)).willReturn(Optional.of(book));
        var result = booksService.getBookById(1234);
        assertThat(result.getAuthor().equals("James gosling"));
    }

    @Test
    public void whenSaveBook_thenBookSavedSuccessfully() {
        given(booksRepository.save(book)).willReturn(book);
        booksService.saveOrUpdate(book);
        verify(booksRepository).save(book);
    }

    @Test
    public void whenBooksExist_thenGetAllBooks() {
        given(booksRepository.findAll()).willReturn(List.of(book));
        var result = booksService.getAllBooks();
        assertThat(result.contains(book));
    }

    @Test
    public void whenDeleteBook_thenBookDeletedSuccessfully() {
        doNothing().when(booksRepository).deleteById(1234);
        booksService.delete(1234);
        verify(booksRepository).deleteById(1234);
    }

}
