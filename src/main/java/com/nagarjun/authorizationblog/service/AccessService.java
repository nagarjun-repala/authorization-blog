package com.nagarjun.authorizationblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarjun.authorizationblog.entity.Book;

@Service("accessService")
public class AccessService {

    @Autowired
    private BookService bookService;

    public boolean hasAccessToBook(Long bookId, Long userId) {

        try {
            Book book = bookService.getBook(bookId);
            return book.getUser().getId() == userId;
        } catch (Exception e) {
            return false;
        }
    }    

    
}
