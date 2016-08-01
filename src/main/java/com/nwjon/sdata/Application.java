package com.nwjon.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jondann on 7/29/16.
 */
public class Application {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        BookRepository repository = context.getBean(BookRepository.class);

//        System.out.println(repository.findByTitle("Design Patterns"));
//        for (Book b: repository.findByPageCountGreaterThan(45)){
//            System.out.println(b);
//        }

        //paging(repository);
        sorting(repository);

        //oneBook(repository);
        //allBooks(repository);
        //allCertainBooks(repository);
        //saveMultiple(repository);
        //saveSingle(repository);
        //modify(repository);

        //repository.delete(1L);
        //repository.delete(oneBook(repository));
        //repository.delete(allCertainBooks(repository));
        //repository.deleteInBatch(allCertainBooks(repository));
        //repository.deleteAll();
        //repository.deleteAllInBatch();

    }

    private static Book oneBook(BookRepository repository){
        Book book = repository.findOne(1L);
        System.out.println(book.toString());
        return book;
    }

    private static List<Book> allBooks(BookRepository repository){
        List<Book> books = repository.findAll();
        for (Book book: books){
            System.out.println(book.toString());
        }
        return books;
    }

    private static List<Book> allCertainBooks(BookRepository repository){

        List<Book> books = repository.findAll(new ArrayList<Long>(){{
            add(1L);
            add(3L);
            add(7L);
        }});
        for (Book book: books){
            System.out.println(book.toString());
        }
        return books;
    }

    private static void saveMultiple(BookRepository repository){
        List<Book> books = BookUtil.create(5);
        repository.save(books);
    }

    private static void saveSingle(BookRepository repository){

        Book book = new Book();
        book.setTitle("Such a good book");
        book.setPrice(new BigDecimal("15.85"));
        book.setPublishDate(new Date());
        book.setPageCount(235);

        repository.save(book);
    }

    private static void modify(BookRepository repository){
        Book book = repository.findOne(1L);
        System.out.println(book);
        book.setTitle("Jar not War");
        repository.save(book);

        System.out.println(book);
    }

    private static void paging(BookRepository repository){

        for (Book b: repository.findAll(new PageRequest(0,3))){
            System.out.println(b);
        }

        for (Book b: repository.findByPageCountGreaterThanEqualOrderByTitle(90, new PageRequest(0,3))){
            System.out.println(b);
        }

        Page page = repository.findByPageCountOrderByPageCount(90, new PageRequest(0,3));
        page.getTotalElements();
        page.getTotalPages();

        //when not considered about total number of pages in result set
        //use more efficient slice
        /*
        Slice slice = repository.findByPublishDateThanOrderByPageCount(new Date(), new PageRequest(0,3));
        slice.getNumberOfElements();
        slice.getNumber();
        slice.hasNext();
        */
    }

    private static void sorting(BookRepository repository){

        //direction is optional
        //sort by multiple fields
        //new Sort(Sort.Direction.DESC, "author.lastName", "pageCount")
        for (Book b: repository.findAll(new Sort(Sort.Direction.DESC, "author.lastName").and(new Sort(Sort.Direction.ASC, "pageCount")))){
            System.out.println(b.getAuthor().getLastName() + ": " + b.getPageCount());
        }

        for (Book b: repository.findByPageCountGreaterThanEqualOrderByPageCount(90, new Sort("author.firstName"))){
            System.out.println(b.getAuthor().getFirstName());
        }
    }
}
