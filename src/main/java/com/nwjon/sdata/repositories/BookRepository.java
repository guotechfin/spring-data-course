package com.nwjon.sdata.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by jondann on 7/29/16.
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {

    //return type can be
    //Collection<Book>
    //Iterable<Book>
    //Page<Book>

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
    public List<Book> findByTitleContainingOrTitleContaining(String title, String title2);
    public List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);
    public List<Book> findByTitleNot(String title);

    //date comparison
    public List<Book> findByPublishDateAfter(Date date);
    public List<Book> findByPublishDateBefore(Date date);
    public List<Book> findByPublishDateBetween(Date date1, Date date2);

    //ordering
    public List<Book> findByTitleContainingOrderByTitleAsc(String title);
    public List<Book> findByTitleContainingOrderByTitleDesc(String title);

    //limiting results
    //find all books and order by page count and then return top result
    //get the max
    //top and first are the same
    public List<Book> findTopByOrderByPageCountDesc();
    public List<Book> findFirstByOrderByPageCountAsc();
    public List<Book> findTop5ByOrderByPriceDesc();
    public List<Book> findTop5ByTitleOrderByPriceAsc(String title);

    //jpql querys
    @Query("select b from Book b")
    public List<Book> queryOne();

    //param with ordinal
    @Query("select b from Book b where b.pageCount > ?1")
    public List<Book> queryTwo(int pageCount);

    //preferred - named parameter
    @Query("select b from Book b where b.title = :title")
    public List<Book> queryThree(@Param("title") String title);

    //named query - @Query is preferrable over this
    public List<Book> queryFour();

    //paging
    //adding paging to a dervied method

    public List<Book> findByPageCountGreaterThanEqualOrderByTitle(int pageCount, Pageable pageable);
    public Page<Book> findByPageCountOrderByPageCount(int pageCount, Pageable pageable);
    public Slice<Book> findByPublishDateOrderByPageCount(Date date, Pageable pageable);

    //sorting
    public List<Book> findByPageCountGreaterThanEqualOrderByPageCount(int pageCount, Sort sort);

    @Transactional
    @Modifying
    @Query("update Book b set b.pageCount = ?2 where b.title like ?1")
    public int setPageCount(String title, int pageCount);
}

