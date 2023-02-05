package com.nagarjun.authorizationblog.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.nagarjun.authorizationblog.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nagarjun.authorizationblog.entity.Book;
import com.nagarjun.authorizationblog.security.manager.CustomPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createUser(@RequestBody Book book, @AuthenticationPrincipal CustomPrincipal principal) {

        return new ResponseEntity<>(bookService.createBook(book, principal.getUsername()), HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);     
    }
    
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable Long bookId) {
        
        return new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK);     
    }  
    
}
