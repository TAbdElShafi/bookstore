package com.acn.bookstore.sevice;

import com.acn.bookstore.model.Book;
import com.acn.bookstore.service.BooksService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookServiceT {

    @Mock
    public BooksService booksService;

    private static Book book;

    @BeforeAll
    public void prepareData() {
        MockitoAnnotations.openMocks(this);
        book = new Book(1234, "Advanced Java", "James gosling", 800);
    }

    @Test
    public void whenInsertBook_thenFindItsId() {
        booksService.saveOrUpdate(book);
        Mockito.when(booksService.getBooksById(1234)).thenReturn(book);
        assertEquals(book.getAuthor(), "James gosling");
    }
}
