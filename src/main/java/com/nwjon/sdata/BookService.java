package com.nwjon.sdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
