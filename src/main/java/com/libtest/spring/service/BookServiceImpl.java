package com.libtest.spring.service;

//import com.libtest.com.libtest.spring.dao.BookDaoImpl;
//import com.libtest.com.libtest.spring.model.Book;

import com.libtest.spring.dao.BookDaoImpl;
import com.libtest.spring.model.Book;
import com.libtest.spring.model.BookRequest;
import com.libtest.spring.model.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements  IBookService {
    @Autowired
    BookDaoImpl bookDao;

    @Override
    public BookResponse save(BookRequest book) {
        if(book == null)
            return new BookResponse();
        return createResponseObject(bookDao.save(convertToDbEntity(book)));
    }

    @Override
    public BookResponse get(long id) {
        Book b = bookDao.get(id);
        return  createResponseObject(b);
    }

    @Override
    public List<BookResponse> list() {
       List<Book> bookList = bookDao.getList();
        return createResponseList(bookList);
    }

    @Override
    public BookResponse update(long id, BookRequest bookRequest) {
        return null;
    }

    @Override
    public void delete(long id) {
        bookDao.delete(id);

    }
    private List<BookResponse>  createResponseList(List<Book> bookList){
        List<BookResponse> bookResponseList = new ArrayList<>();
        for(Book book : bookList){
            bookResponseList.add(createResponseObject(book));
        }
        return bookResponseList;
    }
    private BookResponse createResponseObject(Book b) {
        BookResponse response = new BookResponse();
        response.setId(b.getBookId());
        response.setAuthor(b.getAuthorName());
        response.setTitle(b.getBookName());
        return response;
    }
    private Book convertToDbEntity(BookRequest book) {
        Book bookEntity = new Book();
        bookEntity.setBookId(book.getBookId());
        bookEntity.setAuthorName(book.getAuthorName());
        bookEntity.setBookName(book.getBookName());
        return bookEntity;
    }
}
