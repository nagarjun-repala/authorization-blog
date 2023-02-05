package com.nagarjun.authorizationblog.repository;

import org.springframework.data.repository.CrudRepository;
import com.nagarjun.authorizationblog.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
