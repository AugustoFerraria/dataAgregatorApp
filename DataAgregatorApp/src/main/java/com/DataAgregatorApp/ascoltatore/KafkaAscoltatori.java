package com.DataAgregatorApp.ascoltatore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.DataAgregatorApp.entity.ComuneDose;
import com.DataAgregatorApp.service.DataAggregatorService;

@Component
public class KafkaAscoltatori {

	@Autowired
	private DataAggregatorService service;

	@KafkaListener(topics = "covidDoses", containerFactory = "comuneDoseListener")
	public void listen(ComuneDose comuneDose) {
		System.out.println("ricevuto '" + comuneDose + "' dal covidDoseTopic.");
		service.aggiungiComuneDose(comuneDose);
	}

}