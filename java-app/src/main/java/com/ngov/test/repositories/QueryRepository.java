package com.ngov.test.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ngov.test.model.Query;

@Repository
public interface QueryRepository extends CrudRepository<Query, String> {
	
	List<Query> findByCategoryName(String categoryName);
	
	void deleteByQueryName(String documentName);
	
	List<Query> findByQueryName(String documentName);

}
