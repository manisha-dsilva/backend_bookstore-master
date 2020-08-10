package com.ngov.test.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ngov.test.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
	
	List<Book> findByCategoryName(String categoryName);
	
	void deleteByBookName(String bookName);
	
	List<Book> findByBookNameAndCategoryName(String bookName, String categoryName);
	
	List<Book> findByBookName(String bookName);

}
