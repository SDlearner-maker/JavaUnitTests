package com.fdmgroup.secondMockito;

public class Book {
	
	private String isbn;
	
	public Book() {
		this("asdf");
	}
	
	public Book(String isbn) {
		this.isbn = isbn;
	}
	
	public String getISBN() {
		return isbn;
	}

}
