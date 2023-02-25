package com.acn.bookstore.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BooksControllerIT {

    private static final String POST_BOOK = """
            {
                "bookId": 5434,
                "bookName": "Core and Advance Java 2",
                "author": "R. Nageswara Rao",
                "price": 850
            }
            """;

    @Autowired
    private MockMvc mvc;

    @Test
    void saveAndGetBooks() throws Exception {
        mvc.perform(
            post("/book")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(POST_BOOK)
                    .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());

        mvc.perform(
                get("/book/5434")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(POST_BOOK, true));
    }

}
