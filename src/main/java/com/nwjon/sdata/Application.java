package com.nwjon.sdata;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jondann on 7/29/16.
 */
public class Application {

    public static void main(String[] args) {

        try(
                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class);
        ){

            BookService service = context.getBean(BookService.class);

            Book book = new Book();
            book.setTitle("First New Book");
            book.setPageCount(300);
            book.setPrice(new BigDecimal("26.50"));
            book.setPublishDate(new Date());

            service.save(book);

            System.out.println("book id: " + book.getBookId());
        }
    }
}
