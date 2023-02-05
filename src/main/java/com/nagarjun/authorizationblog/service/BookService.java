package com.nagarjun.authorizationblog.service;

import com.nagarjun.authorizationblog.entity.Book;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostAuthorize;

public interface BookService {


    Book createBook(Book book, String username);

    @PostAuthorize("(hasRole('USER')) AND (returnObject.user.username == principal.username)")
    Book getBook(Long bookId);


    @PreAuthorize("hasRole('USER') AND @accessService.hasAccessToBook(#bookId, principal.userId)")
    void deleteBook(Long bookId);
    
}
