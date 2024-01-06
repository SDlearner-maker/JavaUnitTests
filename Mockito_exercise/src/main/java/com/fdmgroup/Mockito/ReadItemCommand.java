package com.fdmgroup.Mockito;

import java.util.ArrayList;
import java.util.List;

public interface ReadItemCommand {

	//void readAll();
	ArrayList<Book> readAll();
	
	String getItem(String id);
}
