package com.fdmgroup.secondMockito;

import java.util.List;

public interface ReadItemCommand {

	List<Book> readAll(); //returns the list of all books in the catalogue

	Book getItem(String id);

}
