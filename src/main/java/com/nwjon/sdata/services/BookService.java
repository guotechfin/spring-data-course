package com.nwjon.sdata.services;

import com.nwjon.sdata.repositories.Book;
import com.nwjon.sdata.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jondann on 7/29/16.
 */

//@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public void save(Book book){
        this.repo.save(book);
    }

}
