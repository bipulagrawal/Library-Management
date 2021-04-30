package com.library.management.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.entity.Books;
import com.library.management.exception.BookCannotBeBorrowedException;
import com.library.management.exception.BookCannotBeReturnedException;
import com.library.management.service.BooksService;

@RestController
@RequestMapping("/library")
public class BooksController {
	@Autowired
	private BooksService booksService;
	
	@GetMapping("/getallbooks")
	public List<Books> retriveAllBooks() {
		return booksService.getAllBooks();
	}
	
	@GetMapping("/checkemptylibrary")
	public List<Books> retriveAllBooks1() {
		return booksService.checkEmptyLibrary();
	}
	
	@PostMapping("/books")
	public void addBooks(@RequestBody Books book) {
		booksService.createBooks(book);
	}
	
	@GetMapping("/books/{id}")
	public Books findBookById(@PathVariable("id") int id) {
		return booksService.findBookById(id);
	}
	
	@GetMapping("/bookavailability/{id}")
	public Boolean checkAvailability(@PathVariable("id") int id) {
		return booksService.checkAvailability(id);
	}
	
	@PostMapping("/borrowbook/{id}")
	public void borrowBookById(@PathVariable("id") int id) throws BookCannotBeBorrowedException {
		booksService.borrowBookById(id);
	}
	
	@PostMapping("/returnbook/{id}")
	public void returnBookById(@PathVariable("id") int id) throws BookCannotBeReturnedException {
		booksService.returnBookById(id);
	}
}