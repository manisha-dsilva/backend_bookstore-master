package com.ngov.test.service;

import java.util.List;

import com.ngov.test.model.BDocument;
import com.ngov.test.model.Book;

public interface DocumentService {
	
	 BDocument save(BDocument document);
	 
	 List<BDocument> listAll();
	 
	 List<BDocument> getDocumentByCategory(String category);
	 
	 void delete(String documentName);
	 
	 List<BDocument> getDocumentByDocumentName(String documentName);

}
