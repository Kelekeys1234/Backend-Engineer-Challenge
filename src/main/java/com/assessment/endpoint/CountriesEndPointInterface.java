package com.assessment.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("api/v1")
public interface CountriesEndPointInterface {

	@GetMapping("filter/cities")
	ResponseEntity<Object> getSingleCityAndItsPopulationData(
			@RequestParam(value = "number_of_city", required = false) String number_of_city,
			@RequestParam(value = "order") String order, @RequestParam(value = "orderBy") String orderBy,
			@RequestParam(value = "country") String country) throws Exception;

	@GetMapping("country/entityType")
	ResponseEntity<Object> getSinglCountryAndEntityTpe(@RequestParam(value = "country") String country,
			@RequestParam(value = "entityType") String entityType) throws Exception;

	@GetMapping("country/states")
	ResponseEntity<Object> getSingleCountryAndItsStates(@RequestParam(value = "country") String country,
			@RequestParam(value = "state", required = false) String state) throws Exception;

}
