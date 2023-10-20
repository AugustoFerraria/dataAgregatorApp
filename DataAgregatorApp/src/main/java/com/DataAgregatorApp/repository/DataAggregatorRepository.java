package com.DataAgregatorApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.DataAgregatorApp.entity.ComuneDose;

public interface DataAggregatorRepository extends MongoRepository<ComuneDose, String> {

}