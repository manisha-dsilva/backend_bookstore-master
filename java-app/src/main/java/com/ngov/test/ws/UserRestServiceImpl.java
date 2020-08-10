package com.ngov.test.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ngov.test.model.User;
import com.ngov.test.service.UserServiceImpl;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RestController("/store")
public class UserRestServiceImpl {
	
	private Logger logger = LoggerFactory.getLogger(UserRestServiceImpl.class);

	@Autowired
	private UserServiceImpl userService;

	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/user/signin", method=RequestMethod.POST)
	public ResponseEntity<Boolean> signin(@RequestBody User user) {
		boolean flag = userService.signin(user);
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/user/signup", method=RequestMethod.POST)
	public ResponseEntity<String> signup(@RequestBody User user) {
		userService.signup(user);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}


}
