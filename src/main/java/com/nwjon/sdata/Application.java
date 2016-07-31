package com.nwjon.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        //System.out.println(repository.findByTitle("Design Patterns"));
        //for (Book b: repository.findByTitleContaining("of")){
        //    System.out.println(b);
        //}


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
}
