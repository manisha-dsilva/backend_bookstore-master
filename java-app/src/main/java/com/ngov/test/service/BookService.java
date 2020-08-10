package com.ngov.test.service;

import java.util.List;

import com.ngov.test.model.Book;

public interface BookService {
	
	 Book save(Book book);
	 
	 List<Book> listAll();
	 
	 List<Book> getBookByCategory(String categoryName);
	 
	 void delete(String bookName);
	 
	 List<Book> getBookByBookName(String bookName);
	 
	 List<Book> getBookByBookNameAndCategoryName(String bookName, String categoryName);

}
