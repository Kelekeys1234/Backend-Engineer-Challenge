package com.assessment.external.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Service
public class ExternalApis {
	@Autowired
	private RestTemplate restTemplate;
	private static final String BASE_URL = "https://countriesnow.space/api/v0.1/countries/";
	private static final String POPULATION_URL = "https://countriesnow.space/api/v0.1/countries/population";
	private static final String CITY_URL = "cities";
	private static final String FILTER_URL = "filter";
	private static final String CAPITAL_URL = "capital";
	private static final String POSITION_URL = "positions";
	private static final String CURRENCY_URL = "currency";
	private static final String PATH_SEPARATOR = "/";
	private static final String PARAM_QUERY = "q";
	private static final String MSG_ERROR_INVOKING = "Invalid url";

	public Object getSingleCityAndItsPopulationData(String number_of_city, String order, String orderBy, String country)
			throws Exception {
		ResponseEntity<Object> responseEntity = null;
		try {

			StringBuilder path = new StringBuilder();
			path.append(POPULATION_URL).append(PATH_SEPARATOR).append(CITY_URL).append(PATH_SEPARATOR)
					.append(FILTER_URL).append(PATH_SEPARATOR).append(PARAM_QUERY);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("limit", number_of_city);
			uriBuilder.queryParam("order", order);
			uriBuilder.queryParam("orderBy", orderBy);
			uriBuilder.queryParam("country", country);
			responseEntity = restTemplate.getForEntity(uriBuilder.toUriString(), Object.class);
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody();
	}

	public Object getSinglCountryAndPopulationData(String country) throws Exception {
		ResponseEntity<Object> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(POPULATION_URL).append(PATH_SEPARATOR).append(PARAM_QUERY);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("country", country.toString());
			responseEntity = restTemplate.getForEntity(uriBuilder.toUriString(), Object.class);

		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody();
	}

	public Object getSingleCountryAndCapital(String country) throws Exception {
		ResponseEntity<Object> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(BASE_URL).append(CAPITAL_URL).append(PATH_SEPARATOR).append(PARAM_QUERY);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("country", country.toString());
			responseEntity = restTemplate.getForEntity(uriBuilder.toUriString(), Object.class);
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody();
	}


	public Object getSingleCountryAndItsPositions(String country) throws Exception {
		ResponseEntity<Object> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(BASE_URL).append(POSITION_URL).append(PATH_SEPARATOR).append(PARAM_QUERY);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("country", country.toString());
			responseEntity = restTemplate.getForEntity(uriBuilder.toUriString(), Object.class);
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody();
	}

	public Object getSingleCountryAndItsCurrency(String country) throws Exception {
		ResponseEntity<Object> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(BASE_URL).append(CURRENCY_URL).append(PATH_SEPARATOR).append(PARAM_QUERY);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("country", country.toString());
			responseEntity = restTemplate.getForEntity(uriBuilder.toUriString(), Object.class);
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody();
	}

	public Object getSingleCountryAndISO2And3Codes(String country) throws Exception {
		ResponseEntity<Object> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(BASE_URL).append("iso").append(PATH_SEPARATOR).append(PARAM_QUERY);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("country", country.toString());
			responseEntity = restTemplate.getForEntity(uriBuilder.toUriString(), Object.class);
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody();
	}

	public Object getSingleCountryAndItsStates(String country) {
		ResponseEntity<Object> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(BASE_URL).append("states").append(PATH_SEPARATOR).append(PARAM_QUERY);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("country", country.toString());
			responseEntity = restTemplate.getForEntity(uriBuilder.toUriString(), Object.class);
		} catch (Exception e) {

		}
		return responseEntity.getBody();
	}

	public Object getSingleCountryAndItsCities(String country) {
		ResponseEntity<Object> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(BASE_URL).append("cities").append(PATH_SEPARATOR).append(PARAM_QUERY);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("country", country.toString());
			responseEntity = restTemplate.getForEntity(uriBuilder.toUriString(), Object.class);
		} catch (Exception e) {

		}
		return responseEntity.getBody();
	}

	public Object getSingleCountryAndAllCityInState(String country, String state) {
		ResponseEntity<Object> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(BASE_URL).append("state").append(PATH_SEPARATOR).append(CITY_URL).append(PATH_SEPARATOR)
					.append(PARAM_QUERY);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("country", country.toString());
			uriBuilder.queryParam("state", state.toString());
			responseEntity = restTemplate.getForEntity(uriBuilder.toUriString(), Object.class);
		} catch (Exception e) {

		}
		return responseEntity.getBody();
	}
}
