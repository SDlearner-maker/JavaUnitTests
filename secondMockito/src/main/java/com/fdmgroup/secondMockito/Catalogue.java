package com.fdmgroup.secondMockito;

import java.util.List;

public class Catalogue {

	private ReadItemCommand ric;
	private WriteItemCommand wic;

	public Catalogue(ReadItemCommand ric, WriteItemCommand wic) {
		this.ric = ric;
		this.wic = wic;
	}

	public List<Book> getAllBooks() {
		return ric.readAll();
	}

	public void addBook(Book book) {
		wic.insertItem(book);
	}

	public void addBooks(List<Book> books) {
		for (Book book : books) {
			wic.insertItem(book);
		}
	}

	public Book getBook(String isbn) {
		return new Book(isbn);
	}

	public void deleteBook(Book book) {
		wic.deleteItem(book);
	}

	public void deleteAllBooks() {
		List<Book> listOfBooks = ric.readAll();
		for (Book book : listOfBooks) {
			wic.deleteItem(book);
		}
	}

}
