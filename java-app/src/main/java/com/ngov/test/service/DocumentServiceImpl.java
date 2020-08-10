package com.ngov.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ngov.test.model.BDocument;
import com.ngov.test.repositories.DocumentRepository;

@Component
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public BDocument save(BDocument document) {
		BDocument savedDocument = documentRepository.save(document);
		return savedDocument;
	}
	
	@Override
    public List<BDocument> listAll() {
        List<BDocument> books = new ArrayList<BDocument>();
        documentRepository.findAll().forEach(books::add); //fun with Java 8
        return books;
    }

	@Override
	public void delete(String documentName) {
		documentRepository.deleteByDocumentName(documentName);
	}

	@Override
	public List<BDocument> getDocumentByCategory(String category) {
		return documentRepository.findByCategoryName(category);
	}

	@Override
	public List<BDocument> getDocumentByDocumentName(String documentName) {
		return documentRepository.findByDocumentName(documentName);
	}
	
}
