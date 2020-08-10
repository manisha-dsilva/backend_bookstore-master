package com.ngov.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ngov.test.model.Video;
import com.ngov.test.repositories.VideoRepository;

@Component
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private VideoRepository videoRepository;

	@Override
	public Video save(Video video) {
		Video savedVideo = videoRepository.save(video);
		return savedVideo;
	}
	
	@Override
    public List<Video> listAll() {
        List<Video> videos = new ArrayList<Video>();
        videoRepository.findAll().forEach(videos::add); 
        return videos;
    }

	@Override
	public void delete(String documentName) {
		videoRepository.deleteByVideoName(documentName);
	}

	@Override
	public List<Video> getVideoByCategory(String category) {
		return videoRepository.findByCategoryName(category);
	}

}
