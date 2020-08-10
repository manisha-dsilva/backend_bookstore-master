package com.ngov.test.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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

import com.ngov.test.model.BDocument;
import com.ngov.test.model.Book;
import com.ngov.test.service.DocumentService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RestController
public class DocumentRestServiceImpl {
	
	private Logger logger = LoggerFactory.getLogger(DocumentRestServiceImpl.class);

	@Autowired
	private DocumentService documentService;

	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/documents", method=RequestMethod.GET)
	public ResponseEntity<List<BDocument>> documents() {
		List<BDocument> documents = documentService.listAll();
		return new ResponseEntity<List<BDocument>>(documents, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="documents/{category}", method=RequestMethod.GET)
	public ResponseEntity<List<BDocument>> documentByCategory(@PathVariable String category) {
		List<BDocument> documents = documentService.getDocumentByCategory(category);
		return new ResponseEntity<List<BDocument>>(documents, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/documents", method=RequestMethod.POST)
	public ResponseEntity<BDocument> addDocument(@RequestBody BDocument document) {
		BDocument savedDocument = documentService.save(document);
		return new ResponseEntity<BDocument>(savedDocument, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/documents/{documentName}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteDocument(@PathVariable String documentName) {
		documentService.delete(documentName);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/documents/search/{documentName}", method=RequestMethod.GET)
	public ResponseEntity<List<BDocument>> documentByDocumentName(@PathVariable String documentName) {
		List<BDocument> documents = documentService.getDocumentByDocumentName(documentName);
		return new ResponseEntity<List<BDocument>>(documents, HttpStatus.OK);
	}



}
