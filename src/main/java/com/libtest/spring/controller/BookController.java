package com.libtest.spring.controller;

import com.libtest.spring.model.BookRequest;
import com.libtest.spring.model.BookResponse;
import com.libtest.spring.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/book/{id}")
    public BookResponse getBookDetails(@PathVariable long id){
       return  bookService.get(id);
    }

    @PostMapping("/book/save")
    public BookResponse saveNewBookDetails(@RequestBody BookRequest book){
        return bookService.save(book);
    }

    @GetMapping("/book")
    public List<BookResponse> getAllBookDetails(){
        return bookService.list();
    }

    @PutMapping("/book/{id}")
    public BookResponse updateBook(@RequestBody BookRequest bookRequest, @PathVariable long id){
        return bookService.update(id, bookRequest);
    }

    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity deleteABook(@PathVariable long id){
        if(id != 0){
            bookService.delete(id);
            return ResponseEntity.noContent().build();
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
