package com.ss.t8.controller;

import com.ss.t8.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangsheng
 * @date 2021/1/26 11:31 上午
 */
@RestController
public class BookController {
    @GetMapping(value = "/book", produces = {"application/toString"})
    public Book getBook(String booKId) {
        return new Book(booKId, "book" + booKId);
    }
}
