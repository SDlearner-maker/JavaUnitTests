package com.fdmgroup.secondMockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class Catalogue_Test {
	
	Catalogue catalogue;
	
	@Mock
	Book mockBook;
	
	@Mock
	ReadItemCommand mockRIC;
	
	@Mock
	WriteItemCommand mockWIC;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
		catalogue = new Catalogue(mockRIC, mockWIC);
	}

	// If we ask the catalogue to give us a list of all items 
	// when there are none, it should return an empty list.
	@Test
	void test_1() {
		//Arrange
		
		//Act
		List<Book> listOfBooks = catalogue.getAllBooks();
		
		//Assert
		assertEquals(0, listOfBooks.size());
	}
	
	// When we make a call to the getAllBooks method,
	// it should make a call to the readAll method of the ReadItemCommand.
	@Test
	void test_2() {
		//Arrange
		
		//Act
		catalogue.getAllBooks();
		
		//Assert
		verify(mockRIC, times(1)).readAll();
	}
	
	// If we make a call to getAllBooks command and it receives a 
	// List of books from the readAll method of the ReadItemCommand, 
	// it should return that same List
	@Test
	void test_3() {
		//Arrange
		List<Book> expected = new ArrayList<>();
		expected.add(new Book());
		when(mockRIC.readAll()).thenReturn(expected); //why a test mehtod in arrange?
		
		//Act
		List<Book> actual = catalogue.getAllBooks();
		
		//Assert
		assertEquals(expected, actual);
	}
	

	// The addBook method of Catalogue should pass the book it
	// is given to the insertItem method of WriteItemCommand
	@Test
	void test_4() {
		//Arrange
		
		//Act
		catalogue.addBook(mockBook);
		
		//Assert
		verify(mockWIC, times(1)).insertItem(mockBook);
	}
	
	// The User wants to be able to pass in multiple books to be 
	// added in. A new method, addBooks(List<Book> books), has been 
	// requested. When this method is called, the insertItem of 
	// the WriteItemCommand should be called n times, where n is 
	// the number of books.
	@Test
	void test_5() {
		//Arrange
		List<Book> books = new ArrayList<>();
		int n = 5;
		for (int i = 0; i < n; i++) {
			books.add(mockBook);
		}
		
		//Act
		catalogue.addBooks(books);
		
		//Assert
		verify(mockWIC, times(n)).insertItem(mockBook);
	}
	
	// The User wants the Catalogue to get a specific book based 
	// on the ISBN of the book. A new method, getBook(String ISBN)
	// has been requested for the Catalogue. Test that when this
	// method is called, it returns a book with the value requested
	// from the ReadItemCommand, from a method called 
	// getItem(String id).It should return a book with the same ISBN 
	// as the one requested
	// check that getBook calls getItem
	@Test
	void test_6() {
		//Arrange
		String ISBN = "123";
		String id = "456";
		when(mockRIC.getItem(id)).thenReturn(new Book(ISBN));
		
		//Act
		Book book = catalogue.getBook(ISBN);
		
		//Assert
		assertEquals(book.getISBN(), mockRIC.getItem(id).getISBN());	
	}
	
	// The catalogue�s deleteBook method should take a book as 
	// an argument and pass that book to the WriteItemCommand�s 
	// deleteItem method
	@Test
	void test_7() {
		//Arrange
		
		//Act
		catalogue.deleteBook(mockBook);
		
		//Assert
		verify(mockWIC, times(1)).deleteItem(mockBook);
	}
	
	// The catalogue�s deleteAllBooks method takes no arguments. 
	// It should call the ReadItemCommand�s readAll method. It 
	// should then call the WriteItemCommand�s deleteItem method 
	// once for each of the books returned by the readAll method
	@Test
	void test_8() {
		//Arrange
		List<Book> books = new ArrayList<>();
		books.add(mockBook);
		books.add(mockBook);
		books.add(mockBook);
		when(mockRIC.readAll()).thenReturn(books);
		
		//Act
		catalogue.deleteAllBooks();
		
		//Assert
		verify(mockRIC, times(1)).readAll();
		verify(mockWIC, times(3)).deleteItem(mockBook);
	}
}
