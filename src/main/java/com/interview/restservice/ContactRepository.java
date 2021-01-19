package com.interview.restservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {
}
