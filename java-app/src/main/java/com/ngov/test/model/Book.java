package com.ngov.test.model;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {
	
	@Id
    private ObjectId objectId;
	
	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public void setLink(String link) {
		this.link = link;
	}

	private String categoryName;
	
	private String bookId;
	
	private String bookName;
	
	private String bookDescription;
	
	private String rating;
	
	private String link;
	
	private String bookImage;
	
	private String cost;
	
	private String author;
	
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Book() {
		
	}
	
	public Book(ObjectId objectId, String bookId, String bookName, String bookDescription, String rating, String link, String bookImage,
			String cost, String author, int count) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.rating = rating;
		this.link = link;
		this.bookImage = bookImage;
		this.cost = cost;
		this.author = author;
		this.count = count;
		this.objectId = objectId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getLink() {
		return link;
	}

	public void setLikes(String link) {
		this.link = link;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
