package com.mongo.multitenancy.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongo.multitenancy.model.User;

@Service
public class UserService {

	private final MongoTemplate mongoTemplate;

	public UserService(@Lazy MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<User> getAllUsers() {

		return mongoTemplate.findAll(User.class);
	}

	public void saveUser(User user) {
		mongoTemplate.save(user);

	}

}
