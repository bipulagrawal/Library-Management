package com.library.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Books {
	@Id
	@Column
	private long bookid; //book ID

	@Column
	private String bookName; //book name

	@Column
	private String bookAuthor; //book Author

	@Column
	private int noOfBooksAvailable; //currently Available number of books
	
	@Column
	private int noOfRegisteredBooks; //total number of particular books registered

	//Getter and Setters
	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getNoOfBooksAvailable() {
		return noOfBooksAvailable;
	}

	public void setNoOfBooksAvailable(int noOfBooksAvailable) {
		this.noOfBooksAvailable = noOfBooksAvailable;
	}

	public int getNoOfRegisteredBooks() {
		return noOfRegisteredBooks;
	}

	public void setNoOfRegisteredBooks(int noOfRegisteredBooks) {
		this.noOfRegisteredBooks = noOfRegisteredBooks;
	}
}
