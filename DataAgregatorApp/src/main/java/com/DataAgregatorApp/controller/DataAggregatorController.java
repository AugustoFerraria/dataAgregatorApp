package com.DataAgregatorApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@RequestMapping(value = "/getTotalePrimaDose")
	public long getTotalePrimaDose() {
		return service.getTotalePrimaDose();
	}

	@RequestMapping(value = "/getTotaleSecondaDose")
	public long getTotaleSecondaDose() {
		return service.getTotaleSecondaDose();
	}

	@RequestMapping(value = "/getTotalePrimaDoseDaProvincia/{siglaProvince}")
	public long getTotalePrimaDoseDaProvincia(@PathVariable("siglaProvince") String siglaProvince) {
		return service.getTotalePrimaDoseDaProvincia(siglaProvince);
	}

	@RequestMapping(value = "/getTotaleSecondaDoseDaProvincia/{siglaProvince}")
	public long getTotaleSecondaDoseDaProvincia(@PathVariable("siglaProvince") String siglaProvince) {
		return service.getTotaleSecondaDoseDaProvincia(siglaProvince);
	}

	@RequestMapping(value = "/getComuniOrdinatiPerSecondaDose")
	public List<ComuneDose> getComuniOrdinatiPerSecondaDose() {
		return service.getComuniOrdinatiPerSecondaDose();
	}

	@RequestMapping(value = "/getComuniOrdinatiPerSecondaDoseDaProvincia/{siglaProvince}")
	public List<ComuneDose> getComuniOrdinatiPerSecondaDoseDaProvincia(
			@PathVariable("siglaProvince") String siglaProvince) {
		return service.getComuniOrdinatiPerSecondaDoseDaProvincia(siglaProvince);
	}

	@RequestMapping(value = "/getComuneConPiuPrimaDose")
	public ComuneDose getComuneConPiuPrimaDose() {
		return service.getComuneConPiuPrimaDose();
	}

	@RequestMapping(value = "/getComuneConPiuSecondaDose")
	public ComuneDose getComuneConPiuSecondaDose() {
		return service.getComuneConPiuSecondaDose();
	}

	@RequestMapping(value = "/getComuneConMenoPrimaDose")
	public ComuneDose getComuneConMenoPrimaDose() {
		return service.getComuneConMenoPrimaDose();
	}

	@RequestMapping(value = "/getComuneConMenoSecondaDose")
	public ComuneDose getComuneConMenoSecondaDose() {
		return service.getComuneConMenoSecondaDose();
	}

	@RequestMapping(value = "/getComuneConPiuPrimaDoseDaProvincia/{siglaProvince}")
	public ComuneDose getComuneConPiuPrimaDoseDaProvincia(@PathVariable("siglaProvince") String siglaProvince) {
		return service.getComuneConPiuPrimaDoseDaProvincia(siglaProvince);
	}

	@RequestMapping(value = "/getComuneConPiuSecondaDoseDaProvincia/{siglaProvince}")
	public ComuneDose getComuneConPiuSecondaDoseDaProvincia(@PathVariable("siglaProvince") String siglaProvince) {
		return service.getComuneConPiuSecondaDoseDaProvincia(siglaProvince);
	}
	@GetMapping("/test")
	public String test () {
		System.out.println("TEST --------------------------------------------");
		String value = "succesful test";
		return value;
	}
}