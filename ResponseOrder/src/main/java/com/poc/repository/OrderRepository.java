package com.poc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.poc.bean.Part;
/**
 * 
 * @author amitjaiswal
 *
 *This is repository interface for performing the crud operations for mongdb.
 */
@Repository
public interface OrderRepository extends MongoRepository<Part, String>{

}
