package com.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.assessment.endpoint.CountriesEndPointInterface;
import com.assessment.service.CountriesProcessor;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CountriesController implements CountriesEndPointInterface {
	@Autowired
	private CountriesProcessor countriesProcessor;

	@Override
	public ResponseEntity<Object> getSingleCityAndItsPopulationData(String number_of_city, String order, String orderBy,
			String country) throws Exception {
		log.info("inside getSingleCityAndItsPopulationData controller");
		Object getSingleCityAndItsPopulationData = countriesProcessor.getSingleCityAndItsPopulationData(number_of_city,
				order, orderBy, country);
		return ResponseEntity.ok(getSingleCityAndItsPopulationData);
	}

	@Override
	public ResponseEntity<Object> getSinglCountryAndPopulationData(String iso3) throws Exception {
		log.info("inside getSinglCountryAndPopulationData controller");
		Object getSinglCountryAndPopulationData = countriesProcessor.getSinglCountryAndPopulationData(iso3);
		return ResponseEntity.ok(getSinglCountryAndPopulationData);
	}

	@Override
	public ResponseEntity<Object> getSingleCountryAndCapital(String iso2) throws Exception {
		log.info("inside getSingleCountryAndCapital controller");
		Object getSingleCountryAndCapital = countriesProcessor.getSingleCountryAndCapital(iso2);
		return ResponseEntity.ok(getSingleCountryAndCapital);
	}

	@Override
	public ResponseEntity<Object> getSingleCountryAndItsPositions(String iso2) throws Exception {
		log.info("inside getSingleCountryAndItsPositions controller");
		Object getSingleCountryAndItsPositions = countriesProcessor.getSingleCountryAndItsPositions(iso2);
		return ResponseEntity.ok(getSingleCountryAndItsPositions);
	}

	@Override
	public ResponseEntity<Object> getSingleCountryAndItsCurrency(String iso2) throws Exception {
		log.info("inside getSingleCountryAndItsCurrency controller");
		Object getSingleCountryAndItsCurrency = countriesProcessor.getSingleCountryAndItsCurrency(iso2);
		return ResponseEntity.ok(getSingleCountryAndItsCurrency);
	}

	@Override
	public ResponseEntity<Object> getSingleCountryAndISO2And3Codes(String iso2) throws Exception {
		log.info("inside getSingleCountryAndISO2And3Codes controller");
		Object getSingleCountryAndISO2And3Codes = countriesProcessor.getSingleCountryAndISO2And3Codes(iso2);
		return ResponseEntity.ok(getSingleCountryAndISO2And3Codes);
	}

	@Override
	public ResponseEntity<Object> getSingleCountryAndItsStates(String iso2) throws Exception {
		log.info("inside getSingleCountryAndItsStates controller");
		Object getSingleCountryAndItsStates = countriesProcessor.getSingleCountryAndItsStates(iso2);
		return ResponseEntity.ok(getSingleCountryAndItsStates);
	}

	@Override
	public ResponseEntity<Object> getSingleCountryAndItsCities(String iso2) throws Exception {
		log.info("inside getSingleCountryAndItsCities controller");
		Object getSingleCountryAndItsCities = countriesProcessor.getSingleCountryAndItsCities(iso2);
		return ResponseEntity.ok(getSingleCountryAndItsCities);
	}

	@Override
	public ResponseEntity<Object> getSingleCountryAndAllCityInState(String country, String city) throws Exception {
		log.info("inside getSingleCountryAndAllCityInState controller");
		Object getSingleCountryAndAllCityInState = countriesProcessor.getSingleCountryAndAllCityInState(country, city);
		return ResponseEntity.ok(getSingleCountryAndAllCityInState);
	}

}
