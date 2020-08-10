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

import com.ngov.test.model.Video;
import com.ngov.test.service.VideoService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RestController
public class VideoRestServiceImpl {
	
	private Logger logger = LoggerFactory.getLogger(VideoRestServiceImpl.class);

	@Autowired
	private VideoService videoService;

	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/videos", method=RequestMethod.GET)
	public ResponseEntity<List<Video>> videos() {
		List<Video> videos = videoService.listAll();
		return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="videos/{category}", method=RequestMethod.GET)
	public ResponseEntity<List<Video>> documentByCategory(@PathVariable String category) {
		List<Video> videos = videoService.getVideoByCategory(category);
		return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/videos", method=RequestMethod.POST)
	public ResponseEntity<Video> addDocument(@RequestBody Video video) {
		Video savedVideo = videoService.save(video);
		return new ResponseEntity<Video>(savedVideo, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://135.254.163.50:4200")
	@RequestMapping(value="/videos/{videoName}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteVideo(@PathVariable String videoName) {
		videoService.delete(videoName);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
}
