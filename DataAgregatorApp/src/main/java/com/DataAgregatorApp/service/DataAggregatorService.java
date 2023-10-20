package com.DataAgregatorApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.DataAgregatorApp.entity.ComuneDose;
import com.DataAgregatorApp.exceptions.BadRequestException;
import com.DataAgregatorApp.repository.DataAggregatorRepository;
import com.mongodb.BasicDBObject;

@Service
public class DataAggregatorService {

    @Autowired
    private DataAggregatorRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void aggiungiComuneDose(ComuneDose comune) {
        boolean esistePerId = repository.existsById(comune.getCodice());
        if (esistePerId) {
            throw new BadRequestException("Comune con ID " + comune.getCodice() + " già esistente.");
        }
        repository.insert(comune);
    }

    public long getTotalePrimaDose() {
        Aggregation aggregazione = Aggregation.newAggregation(Aggregation.group().sum("dose1").as("totaleDose1"));
        AggregationResults<BasicDBObject> risultati = mongoTemplate.aggregate(aggregazione, "comuneDose", BasicDBObject.class);
        BasicDBObject output = risultati.getUniqueMappedResult();
        if (output == null) {
            throw new BadRequestException("Richiesta non valida");
        }
        return output.getLong("totaleDose1");
    }

    public long getTotaleSecondaDose() {
        Aggregation aggregazione = Aggregation.newAggregation(Aggregation.group().sum("dose2").as("totaleDose2"));
        AggregationResults<BasicDBObject> risultati = mongoTemplate.aggregate(aggregazione, "comuneDose", BasicDBObject.class);
        BasicDBObject output = risultati.getUniqueMappedResult();
        if (output == null) {
            throw new BadRequestException("Richiesta non valida");
        }
        return output.getLong("totaleDose2");
    }

    public long getTotalePrimaDoseDaProvincia(String provincia) {
        Aggregation aggregazione = Aggregation.newAggregation(Aggregation.match(Criteria.where("sigla").is(provincia)),
                Aggregation.group().sum("dose1").as("totaleDose1"));
        AggregationResults<BasicDBObject> risultati = mongoTemplate.aggregate(aggregazione, "comuneDose", BasicDBObject.class);
        BasicDBObject output = risultati.getUniqueMappedResult();
        if (output == null) {
            throw new BadRequestException("Richiesta non valida");
        }
        return output.getLong("totaleDose1");
    }

    public long getTotaleSecondaDoseDaProvincia(String provincia) {
        Aggregation aggregazione = Aggregation.newAggregation(Aggregation.match(Criteria.where("sigla").is(provincia)),
                Aggregation.group().sum("dose2").as("totaleDose2"));
        AggregationResults<BasicDBObject> risultati = mongoTemplate.aggregate(aggregazione, "comuneDose", BasicDBObject.class);
        BasicDBObject output = risultati.getUniqueMappedResult();
        if (output == null) {
            throw new BadRequestException("Richiesta non valida");
        }
        return output.getLong("totaleDose2");
    }

    public List<ComuneDose> getComuniOrdinatiPerSecondaDose() {
        Query query = new Query();
        query.with(Sort.by("dose2").descending());
        return mongoTemplate.find(query, ComuneDose.class);
    }

    public List<ComuneDose> getComuniOrdinatiPerSecondaDoseDaProvincia(String provincia) {
        Query query = new Query(Criteria.where("sigla").is(provincia));
        query.with(Sort.by("dose2").descending());
        return mongoTemplate.find(query, ComuneDose.class);
    }

    public ComuneDose getComuneConPiuPrimaDose() {
        Query query = new Query();
        query.limit(1);
        query.with(Sort.by("dose1").descending());
        return mongoTemplate.findOne(query, ComuneDose.class);
    }

    public ComuneDose getComuneConPiuSecondaDose() {
        Query query = new Query();
        query.limit(1);
        query.with(Sort.by("dose2").descending());
        return mongoTemplate.findOne(query, ComuneDose.class);
    }

    public ComuneDose getComuneConMenoPrimaDose() {
        Query query = new Query();
        query.limit(1);
        query.with(Sort.by("dose1").ascending());
        return mongoTemplate.findOne(query, ComuneDose.class);
    }

    public ComuneDose getComuneConMenoSecondaDose() {
        Query query = new Query();
        query.limit(1);
        query.with(Sort.by("dose2").ascending());
        return mongoTemplate.findOne(query, ComuneDose.class);
    }

    public ComuneDose getComuneConPiuPrimaDoseDaProvincia(String provincia) {
        Query query = new Query(Criteria.where("sigla").is(provincia));
        query.limit(1);
        query.with(Sort.by("dose1").descending());
        return mongoTemplate.findOne(query, ComuneDose.class);
    }

    public ComuneDose getComuneConPiuSecondaDoseDaProvincia(String provincia) {
        Query query = new Query(Criteria.where("sigla").is(provincia));
        query.limit(1);
        query.with(Sort.by("dose2").descending());
        return mongoTemplate.findOne(query, ComuneDose.class);
    }
}
