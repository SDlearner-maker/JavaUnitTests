package com.fdmgroup.Mockito;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	
	ArrayList<Book> bookList= new ArrayList<>();
	ReadItemCommand mockrc;
	WriteItemCommand mockwc;
	
	public Catalogue(ReadItemCommand mockrc) {
		// TODO Auto-generated constructor stub
		this.mockrc=mockrc;
	}

	public Catalogue(WriteItemCommand mockwc) {
		// TODO Auto-generated constructor stub
		this.mockwc=mockwc;
	}
	
	public Catalogue(ReadItemCommand mockrc, WriteItemCommand mockwc) {
		// TODO Auto-generated constructor stub
		this.mockrc=mockrc;
		this.mockwc=mockwc;
	}
	
	public ArrayList<Book> getAllBooks() {
		// TODO Auto-generated method stub
		bookList= mockrc.readAll();
		return bookList;
	}
	
	public void addBooks(List<Book> books) {
		bookList=(ArrayList<Book>) books;
	}
	
	public void addBook(Book b) {
		mockwc.insertItem(b);
	}

	public void getBook(Book newBook) {
		// TODO Auto-generated method stub
		String isbn= newBook.isbnBook();
		mockrc.getItem(isbn);
	}
	
	public void deleteBook(Book book) {
		mockwc.deleteItem(book);
	}
	
	public void deleteAllBooks() {
		ArrayList<Book> bList=mockrc.readAll();
		
		for(Book book: bList) {
			mockwc.deleteItem(book);
		}
	}
}
