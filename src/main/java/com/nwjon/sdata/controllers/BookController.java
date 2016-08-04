package com.nwjon.sdata.controllers;

import com.nwjon.sdata.repositories.Book;
import com.nwjon.sdata.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@Autowired
	BookRepository repository;

	@RequestMapping(value={"/books", "/"})
	public String showBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "books";
	}

	@RequestMapping("/books/{bookId}")
	public String showBook(@PathVariable("bookId") Book book, Model model) {
		model.addAttribute("book", book);
		return "book";
	}
}
