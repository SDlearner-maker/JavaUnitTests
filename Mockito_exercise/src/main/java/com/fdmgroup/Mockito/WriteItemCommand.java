package com.fdmgroup.Mockito;

public interface WriteItemCommand {
	
	public void insertItem(Book b);

	public void deleteItem(Book book);
}
