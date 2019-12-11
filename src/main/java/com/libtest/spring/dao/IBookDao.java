package com.libtest.spring.dao;

import com.libtest.spring.model.Book;

import java.util.List;

public interface IBookDao {
    Book save(Book b);
    Book get(Long id);
    List<Book> getList();
    void update(long id, Book book);
    void delete(long id);
}
