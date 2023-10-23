package com.DataAgregatorApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataAgregatorApp.entity.ComuneDose;
import com.DataAgregatorApp.service.DataAggregatorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class DataAggregatorController {

	@Autowired
	DataAggregatorService service;

	// Restituisce il totale delle prime dosi somministrate.
	@RequestMapping(value = "/getTotalePrimaDose")
	public long getTotalePrimaDose() {
		return service.getTotalePrimaDose();
	}

	// Restituisce il totale delle seconde dosi somministrate.
	@RequestMapping(value = "/getTotaleSecondaDose")
	public long getTotaleSecondaDose() {
		return service.getTotaleSecondaDose();
	}

	// Restituisce il totale delle prime dosi somministrate in una provincia specifica.
	@RequestMapping(value = "/getTotalePrimaDoseDaProvincia/{siglaProvince}")
	public long getTotalePrimaDoseDaProvincia(@PathVariable("siglaProvince") String siglaProvince) {
		return service.getTotalePrimaDoseDaProvincia(siglaProvince);
	}

	// Restituisce il totale delle seconde dosi somministrate in una provincia specifica.
	@RequestMapping(value = "/getTotaleSecondaDoseDaProvincia/{siglaProvince}")
	public long getTotaleSecondaDoseDaProvincia(@PathVariable("siglaProvince") String siglaProvince) {
		return service.getTotaleSecondaDoseDaProvincia(siglaProvince);
	}

	// Restituisce una lista di comuni ordinati in base alle seconde dosi somministrate.
	@RequestMapping(value = "/getComuniOrdinatiPerPrimaDose")
	public List<ComuneDose> getComuniOrdinatiPerPrimaDose() {
		return service.getComuniOrdinatiPerPrimaDose();
	}
	
	// Restituisce una lista di comuni ordinati in base alle seconde dosi somministrate.
	@RequestMapping(value = "/getComuniOrdinatiPerSecondaDose")
	public List<ComuneDose> getComuniOrdinatiPerSecondaDose() {
		return service.getComuniOrdinatiPerSecondaDose();
	}

	// Restituisce una lista di comuni ordinati in base alle seconde dosi somministrate in una provincia specifica.
	@RequestMapping(value = "/getComuniOrdinatiPerPrimaDoseDaProvincia/{siglaProvince}")
	public List<ComuneDose> getComuniOrdinatiPerPrimaDoseDaProvincia(
			@PathVariable("siglaProvince") String siglaProvince) {
		return service.getComuniOrdinatiPerPrimaDoseDaProvincia(siglaProvince);
	}
	
	// Restituisce una lista di comuni ordinati in base alle seconde dosi somministrate in una provincia specifica.
	@RequestMapping(value = "/getComuniOrdinatiPerSecondaDoseDaProvincia/{siglaProvince}")
	public List<ComuneDose> getComuniOrdinatiPerSecondaDoseDaProvincia(
			@PathVariable("siglaProvince") String siglaProvince) {
		return service.getComuniOrdinatiPerSecondaDoseDaProvincia(siglaProvince);
	}

	// Restituisce il comune con il maggior numero di prime dosi somministrate.
	@RequestMapping(value = "/getComuneConPiuPrimaDose")
	public ComuneDose getComuneConPiuPrimaDose() {
		return service.getComuneConPiuPrimaDose();
	}

	// Restituisce il comune con il maggior numero di seconde dosi somministrate.
	@RequestMapping(value = "/getComuneConPiuSecondaDose")
	public ComuneDose getComuneConPiuSecondaDose() {
		return service.getComuneConPiuSecondaDose();
	}

	// Restituisce il comune con il minor numero di prime dosi somministrate.
	@RequestMapping(value = "/getComuneConMenoPrimaDose")
	public ComuneDose getComuneConMenoPrimaDose() {
		return service.getComuneConMenoPrimaDose();
	}

	// Restituisce il comune con il minor numero di seconde dosi somministrate.
	@RequestMapping(value = "/getComuneConMenoSecondaDose")
	public ComuneDose getComuneConMenoSecondaDose() {
		return service.getComuneConMenoSecondaDose();
	}

	// Restituisce il comune con il maggior numero di prime dosi somministrate in una provincia specifica.
	@RequestMapping(value = "/getComuneConPiuPrimaDoseDaProvincia/{siglaProvince}")
	public ComuneDose getComuneConPiuPrimaDoseDaProvincia(@PathVariable("siglaProvince") String siglaProvince) {
		return service.getComuneConPiuPrimaDoseDaProvincia(siglaProvince);
	}

	// Restituisce il comune con il maggior numero di seconde dosi somministrate in una provincia specifica.
	@RequestMapping(value = "/getComuneConPiuSecondaDoseDaProvincia/{siglaProvince}")
	public ComuneDose getComuneConPiuSecondaDoseDaProvincia(@PathVariable("siglaProvince") String siglaProvince) {
		return service.getComuneConPiuSecondaDoseDaProvincia(siglaProvince);
	}
}
