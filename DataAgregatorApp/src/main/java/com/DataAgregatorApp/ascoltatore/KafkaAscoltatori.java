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

	// Definizione di un ascoltatore Kafka che riceve messaggi dal topic "covidDoses" utilizzando la factory "comuneDoseListener".
	@KafkaListener(topics = "covidDoses", containerFactory = "comuneDoseListener")
	public void listen(ComuneDose comuneDose) {
		System.out.println("Ricevuto '" + comuneDose + "' dal covidDoseTopic.");
		
		// Chiamata al servizio per aggiungere il comuneDose ricevuto.
		service.aggiungiComuneDose(comuneDose);
	}
}
