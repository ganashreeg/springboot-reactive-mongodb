package com.ganashree.springbootreactivemongodb.repository;

import com.ganashree.springbootreactivemongodb.model.UserProfile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends ReactiveMongoRepository<UserProfile, String> {
}
