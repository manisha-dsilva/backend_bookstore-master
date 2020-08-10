package com.ngov.test.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ngov.test.model.Book;
import com.ngov.test.service.BookService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RestController
public class BookRestServiceImpl {
	
	private Logger logger = LoggerFactory.getLogger(BookRestServiceImpl.class);

	@Autowired
	private BookService bookService;

	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public ResponseEntity<List<Book>> books() {
		List<Book> books = bookService.listAll();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/books/{category}", method=RequestMethod.GET)
	public ResponseEntity<List<Book>> booksByCategory(@PathVariable String category) {
		List<Book> books = bookService.getBookByCategory(category);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book savedbook = bookService.save(book);
		return new ResponseEntity<Book>(savedbook, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/books/{bookName}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteBook(@PathVariable String bookName) {
		bookService.delete(bookName);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/books/search/{bookName}", method=RequestMethod.GET)
	public ResponseEntity<List<Book>> booksByBookName(@PathVariable String bookName) {
		List<Book> books = bookService.getBookByBookName(bookName);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}


}
