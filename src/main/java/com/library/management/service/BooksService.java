package com.library.management.service;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entity.Books;
import com.library.management.exception.BookCannotBeBorrowedException;
import com.library.management.exception.BookCannotBeReturnedException;
import com.library.management.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BooksService {

	private static Logger logger = LoggerFactory.getLogger(BooksService.class);

	@Autowired
	private BookRepository bookRepository;

	//List all the books available
	public List<Books> getAllBooks() {
		logger.info("Getting the list of Books");
		List<Books> books = new ArrayList<>();
		bookRepository.findAll().forEach(f -> books.add(f));
		return books;
	}

	//check if library is empty
	public List<Books> checkEmptyLibrary() {
		logger.info("Checking if library is empty");
		List<Books> books = new ArrayList<>();
		bookRepository.findBynoOfBooksAvailableGreaterThan(0).forEach(f -> books.add(f));
		return books;
	}

	//add a book to the library
	public void createBooks(Books book) {
		logger.info("Adding book");
		bookRepository.save(book);
		logger.info("Added book with ID: " + book.getBookid());
	}

	//search the library with a book ID
	public Books findBookById(long id) {
		logger.info("Check if Library has registered the book with ID: " + id);
		return bookRepository.findById(id).get();
	}

	//check if a book is available in the library using book id
	public Boolean checkAvailability(long id) {
		logger.info("Check if book with ID: " + id + " is available");
		Books bookInLibrary = findBookById(id);
		if (bookInLibrary.getNoOfBooksAvailable() > 0)
			return true;
		else
			return false;
	}

	//borrow a book from the library using book id
	public void borrowBookById(long id) throws BookCannotBeBorrowedException {
		Books bookInLibrary = findBookById(id);
		Boolean countAvailability = checkAvailability(id);
		//borrow book only id the number of book is greater than 0
		if (countAvailability && bookInLibrary.getNoOfBooksAvailable() > 0) {
			logger.info("Book with ID: " + id + " is available to be borrowed");
			bookInLibrary.setNoOfBooksAvailable(bookInLibrary.getNoOfBooksAvailable() - 1);
		} else {
			logger.info("Book with ID: " + id + " is not available for borrowing");
			throw new BookCannotBeBorrowedException("Book cannot be borrowed",601);
		}
		bookRepository.save(bookInLibrary);
	}

	//return a book to the library using book id
	public void returnBookById(long id) throws BookCannotBeReturnedException {
		Books bookInLibrary = findBookById(id);
		//Return only when the book count is less than total registered book
		if (bookInLibrary.getNoOfBooksAvailable() < bookInLibrary.getNoOfRegisteredBooks()) {
			logger.info("Book with ID: " + id + " is returned");
			bookInLibrary.setNoOfBooksAvailable(bookInLibrary.getNoOfBooksAvailable() + 1);
		} else {
			logger.info("Book with ID: " + id + " cannot be returned");
			throw new BookCannotBeReturnedException("Book cannot be returned",602);
		}
		bookRepository.save(bookInLibrary);
	}
}