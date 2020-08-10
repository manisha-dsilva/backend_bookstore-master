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
import com.ngov.test.model.Query;
import com.ngov.test.service.QueryService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RestController
public class QueryRestServiceImpl {
	
	private Logger logger = LoggerFactory.getLogger(QueryRestServiceImpl.class);

	@Autowired
	private QueryService queryService;

	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/queris", method=RequestMethod.GET)
	public ResponseEntity<List<Query>> documents() {
		List<Query> documents = queryService.listAll();
		return new ResponseEntity<List<Query>>(documents, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="queris/{category}", method=RequestMethod.GET)
	public ResponseEntity<List<Query>> documentByCategory(@PathVariable String category) {
		List<Query> documents = queryService.getQueryByCategory(category);
		return new ResponseEntity<List<Query>>(documents, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/queris", method=RequestMethod.POST)
	public ResponseEntity<Query> addDocument(@RequestBody Query query) {
		Query savedquery = queryService.save(query);
		return new ResponseEntity<Query>(savedquery, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/queris/{queryName}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteDocument(@PathVariable String queryName) {
		queryService.delete(queryName);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}


}
