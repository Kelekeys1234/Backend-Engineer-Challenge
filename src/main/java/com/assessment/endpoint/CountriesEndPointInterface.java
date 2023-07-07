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

	@GetMapping("country/population")
	ResponseEntity<Object> getSinglCountryAndPopulationData(@RequestParam(value = "country") String country)
			throws Exception;

	@GetMapping("country/capital")
	ResponseEntity<Object> getSingleCountryAndCapital(@RequestParam(value = "country") String country) throws Exception;

	@GetMapping("country/position")
	ResponseEntity<Object> getSingleCountryAndItsPositions(@RequestParam(value = "country") String country)
			throws Exception;

	@GetMapping("country/currency")
	ResponseEntity<Object> getSingleCountryAndItsCurrency(@RequestParam(value = "country") String country)
			throws Exception;

	@GetMapping("country/iso2/iso3")
	ResponseEntity<Object> getSingleCountryAndISO2And3Codes(@RequestParam(value = "country") String country)
			throws Exception;

	@GetMapping("country/states")
	ResponseEntity<Object> getSingleCountryAndItsStates(@RequestParam(value = "country") String country)
			throws Exception;

	@GetMapping("country/city/state")
	ResponseEntity<Object> getSingleCountryAndAllCityInState(@RequestParam(value = "country") String country,
			@RequestParam(value = "state") String state) throws Exception;

	@GetMapping("country/cities")
	ResponseEntity<Object> getSingleCountryAndItsCities(@RequestParam(value = "country") String country)
			throws Exception;
}
