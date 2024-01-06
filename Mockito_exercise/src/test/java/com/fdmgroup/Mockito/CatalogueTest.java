package com.fdmgroup.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

public class CatalogueTest {	
	
	@Mock
	ReadItemCommand mockrc;
	
	@Mock
	WriteItemCommand mockwc;
	
	@Mock
	Book mockBook;
		
	@ExtendWith(MockitoExtension.class)
//	@Test
//	public void getAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue(){
//		//Test code
//		
//		//arrange
//		Catalogue catalogue= new Catalogue();
//		
//		//assign
//		ArrayList<Book> listBooks= catalogue.getAllBooks();
//		
//		//assert
//		assertEquals(0, listBooks.size());
//	}
//	
	
//	@Test
//	public void getAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled(){
//		//Test code
//		
//		//arrange
//		Catalogue catalogue= new Catalogue(mockrc);
//		
//		//assign
//		catalogue.getAllBooks();
//		
//		//assert
//		verify(mockrc, times(1)).readAll();
//	}

	@Test
	public void getAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled(){
		//code
		
		//arrange
		Catalogue catalogue= new Catalogue(mockrc);
		
		Book book1= new Book("ISBN1");
		Book book2= new Book("ISBN2");
		Book book3= new Book("ISBN3");
		
		ArrayList<Book> listBooks= new ArrayList<Book>();
		listBooks.add(book1);
		listBooks.add(book2);
		listBooks.add(book3);
		
		//stubbing
		when(mockrc.readAll()).thenReturn(listBooks);
				
		//act
		ArrayList<Book> bList= catalogue.getAllBooks();
		
		//assert
		assertEquals(listBooks, bList);

	}
	
	@Test
	public void Test4() {
		//arrange
		
		Catalogue catalogue= new Catalogue(mockwc);		
		Book book1= new Book("ISBN6");
		
		//act
		catalogue.addBook(book1); 
		
		//assert
		verify(mockwc, times(1)).insertItem(book1); //insertitem called or not, and if arg passed or not
	}
	
	
	public void Test5() {
		
		//arrange
		Book book1=new Book("ISBN1"), book2=new Book("ISBN2"), 
				book3=new Book("ISBN3"), book4=new Book("ISBN4"), book5=new Book("ISBN5");
		Catalogue catalogue= new Catalogue(mockwc);
		
		//act
			
		ArrayList<Book> bList= new ArrayList<Book>();
		bList.add(book1);
		bList.add(book2);
		bList.add(book3);
		bList.add(book4);
		bList.add(book5);		
		
		catalogue.addBooks(bList);
		
		//assert
		verify(mockwc, times(5)).insertItem(any(Book.class));
	}

//	public void Test5() {
//		
//		//arrange
//		Book book1, book2, book3, book4, book5;
//		Catalogue catalogue= new Catalogue(mockwc);
//		
//		//act
//			
//		ArrayList<Book> bList= new ArrayList<Book>();
//		bList.add(mockBook);
//		bList.add(mockBook);
//		bList.add(mockBook);
//		bList.add(mockBook);
//		bList.add(mockBook);		
//		
//		catalogue.addBooks(bList);
//		
//		//assert
//		verify(mockwc, times(5)).insertItem(mockBook);
//	}

	public void Test_6() {
		
		//arrange
		Catalogue catalogue= new Catalogue(mockrc);
		Book newBook= new Book("ISBN1");
		
		//act
		catalogue.getBook(newBook);
		
		//assert
		verify(mockrc, times(1)).getItem("ISBN1");
	}
	
	public void Test7() {
		
		//arrange
		Catalogue catalogue= new Catalogue(mockwc);
		Book newBook= new Book("ISBN1");
		
		//act
		catalogue.deleteBook(newBook);
		
		//assert
		verify(mockwc, times(1)).deleteItem(newBook);
	}
	
	public void Test8() {
		
		//arrange
		Catalogue catalogue= new Catalogue(mockwc);
		Book book1=new Book("ISBN1");
		Book book2=new Book("ISBN2");
		Book book3=new Book("ISBN3");
		Book book4=new Book("ISBN4");
		catalogue.addBook(book1);
		catalogue.addBook(book2);
		catalogue.addBook(book3);
		catalogue.addBook(book4);
		
		//act
		catalogue.deleteAllBooks();
		
		//assert
		verify(mockrc, times(1)).readAll();
		verify(mockwc, times(4)).deleteItem(any(Book.class));
	}
}
