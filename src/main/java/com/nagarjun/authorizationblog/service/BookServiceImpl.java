package com.nagarjun.authorizationblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarjun.authorizationblog.entity.User;
import com.nagarjun.authorizationblog.repository.BookRepository;
import com.nagarjun.authorizationblog.entity.Book;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private UserService userService;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book, String username){
        User user = userService.getUser(username);
        book.setUser(user);
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(Long bookId){
        Book book = bookRepository.findById(bookId).get();
        return book;
    }

    @Override
    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }
    
}
