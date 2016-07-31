package com.nwjon.sdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    //logical comparison
    public List<Book> findByTitleContainingOrContaining(String title, String title2);
    public List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);
    public List<Book> findByTitleNot(String title);

    //date comparison
    public List<Book> findByPublishDateAfter(Date date);
    public List<Book> findByPublishDateBefore(Date date);
    public List<Book> findByPublishDateBetween(Date date1, Date date2);

    //ordering
    public List<Book> findByTitleContainingOrderByTitleAsc(String title);
    public List<Book> findByTitleContainingOrderByTitleDesc(String title);


}

