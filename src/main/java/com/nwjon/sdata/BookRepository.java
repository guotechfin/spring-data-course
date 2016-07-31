package com.nwjon.sdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jondann on 7/29/16.
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public Book findByTitle(String title);

    public List<Book> findByTitleLike(String title);

    public List<Book> findByTitleContaining(String title);

    public List<Book> findByTitleStartingWith(String title);

    public List<Book> findByTitleEndingWith(String title);

    public List<Book> findByTitleIgnoreCase(String title);


}

