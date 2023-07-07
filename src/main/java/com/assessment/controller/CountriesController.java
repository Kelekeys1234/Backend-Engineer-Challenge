package com.assessment.controller;

import java.util.Arrays;


import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.assessment.endpoint.CountriesEndPointInterface;
import com.assessment.service.CountriesProcessor;
import entity.type.EntityType;
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
	public ResponseEntity<Object> getSinglCountryAndEntityTpe(String country, String entityType) throws Exception {
		log.info("inside getSinglCountryAndPopulationData controller");
		if (!EnumUtils.isValidEnum(EntityType.class, entityType)) {
			log.info("enitity Type must be ", EntityType.class);
			throw new Exception("enitity Type must be: " + getEnumNamesAsString(EntityType.class));
		}
		Object getSinglCountryAndPopulationData = countriesProcessor.getSinglCountryAndPopulationData(country,
				entityType);
		return ResponseEntity.ok(getSinglCountryAndPopulationData);
	}

	@Override
	public ResponseEntity<Object> getSingleCountryAndItsStates(String country, String state) throws Exception {
		log.info("inside getSingleCountryAndItsStates controller");
		Object getSingleCountryAndItsStates = countriesProcessor.getSingleCountryAndItsStates(country, state);
		return ResponseEntity.ok(getSingleCountryAndItsStates);
	}

	public static String getEnumNamesAsString(Class<? extends Enum<?>> e) {
		return Arrays.toString(Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new));
	}

}
