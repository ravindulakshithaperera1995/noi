package com.example.noitimeline.persistence;

import com.example.noitimeline.model.NOITimeLineEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NOITimeLineEventRepository extends MongoRepository<NOITimeLineEvent, String> {
}
