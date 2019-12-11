package com.libtest.spring.service;

import com.libtest.spring.model.BookRequest;
import com.libtest.spring.model.BookResponse;

import java.util.List;

public interface IBookService {
    BookResponse save(BookRequest BookResponse);
    BookResponse get(long id);
    List<BookResponse> list();
    BookResponse update(long id, BookRequest bookRequest);
    void delete(long id);
}
