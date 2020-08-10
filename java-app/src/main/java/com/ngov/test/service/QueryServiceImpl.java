package com.ngov.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ngov.test.model.Query;
import com.ngov.test.repositories.QueryRepository;

@Component
public class QueryServiceImpl implements QueryService{
	
	@Autowired
	private QueryRepository queryRepository;

	@Override
	public Query save(Query query) {
		Query savedQuery = queryRepository.save(query);
		return savedQuery;
	}
	
	@Override
    public List<Query> listAll() {
        List<Query> videos = new ArrayList<Query>();
        queryRepository.findAll().forEach(videos::add); 
        return videos;
    }

	@Override
	public void delete(String documentName) {
		queryRepository.deleteByQueryName(documentName);
	}

	@Override
	public List<Query> getQueryByCategory(String category) {
		return queryRepository.findByCategoryName(category);
	}

}
