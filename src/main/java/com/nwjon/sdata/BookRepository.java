package com.nwjon.sdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jondann on 7/29/16.
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //string comparison
    public Book findByTitle(String title);
    public List<Book> findByTitleLike(String title);
    public List<Book> findByTitleContaining(String title);
    public List<Book> findByTitleStartingWith(String title);
    public List<Book> findByTitleEndingWith(String title);
    public List<Book> findByTitleIgnoreCase(String title);

    //relational comparison
    public List<Book> findByPageCountEquals(int pageCount);
    public List<Book> findByPageCountGreaterThan(int pageCount);
    public List<Book> findByPageCountLessThan(int pageCount);
    public List<Book> findByPageCountGreaterThanEqual(int pageCount);
    public List<Book> findByPageCountLessThanEqual(int pageCount);
    public List<Book> findByPageCountBetween(int min, int max);




}

