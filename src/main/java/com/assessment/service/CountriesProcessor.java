package com.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.assessment.external.api.ExternalApis;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CountriesProcessor {
	@Autowired
	private ExternalApis externalApis;

	private static final String MSG_ERROR_INVOKING = "external api is empty";

	public Object getSingleCityAndItsPopulationData(String number_of_city, String order, String orderBy, String country)
			throws Exception {
		Object getSingleCityAndItsPopulationData = null;
		try {
			getSingleCityAndItsPopulationData = externalApis.getSingleCityAndItsPopulationData(number_of_city, order,
					orderBy, country);
			if (ObjectUtils.isEmpty(getSingleCityAndItsPopulationData)) {
				log.error(MSG_ERROR_INVOKING);
				throw new Exception(MSG_ERROR_INVOKING);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return getSingleCityAndItsPopulationData;

	}

	public Object getSinglCountryAndPopulationData(String country) throws Exception {
		Object getSinglCountryAndPopulationData = externalApis.getSinglCountryAndPopulationData(country);
		if (ObjectUtils.isEmpty(getSinglCountryAndPopulationData)) {
			log.error(MSG_ERROR_INVOKING);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return getSinglCountryAndPopulationData;
	}

	public Object getSingleCountryAndCapital(String country) throws Exception {
		Object getSingleCountryAndCapital = externalApis.getSingleCountryAndCapital(country);
		if (ObjectUtils.isEmpty(getSingleCountryAndCapital)) {
			log.error(MSG_ERROR_INVOKING);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return getSingleCountryAndCapital;
	}

	public Object getSingleCountryAndItsPositions(String country) throws Exception {
		Object getSingleCountryAndItsPositions = externalApis.getSingleCountryAndItsPositions(country);
		if (ObjectUtils.isEmpty(getSingleCountryAndItsPositions)) {
			log.error(MSG_ERROR_INVOKING);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return getSingleCountryAndItsPositions;
	}

	public Object getSingleCountryAndItsCurrency(String country) throws Exception {
		Object getSingleCountryAndItsCurrency = externalApis.getSingleCountryAndItsCurrency(country);
		if (ObjectUtils.isEmpty(getSingleCountryAndItsCurrency)) {
			log.error(MSG_ERROR_INVOKING);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return getSingleCountryAndItsCurrency;
	}

	public Object getSingleCountryAndISO2And3Codes(String country) throws Exception {
		Object getSingleCountryAndISO2And3Codes = externalApis.getSingleCountryAndISO2And3Codes(country);
		if (ObjectUtils.isEmpty(getSingleCountryAndISO2And3Codes)) {
			log.error(MSG_ERROR_INVOKING);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return getSingleCountryAndISO2And3Codes;
	}

	public Object getSingleCountryAndItsStates(String country) throws Exception {
		Object getSingleCountryAndItsStates = externalApis.getSingleCountryAndItsStates(country);
		if (ObjectUtils.isEmpty(getSingleCountryAndItsStates)) {
			log.error(MSG_ERROR_INVOKING);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return getSingleCountryAndItsStates;
	}

	public Object getSingleCountryAndItsCities(String country) throws Exception {
		Object getSingleCountryAndItsCities = externalApis.getSingleCountryAndItsCities(country);
		if (ObjectUtils.isEmpty(getSingleCountryAndItsCities)) {
			log.error(MSG_ERROR_INVOKING);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return getSingleCountryAndItsCities;
	}

	public Object getSingleCountryAndAllCityInState(String country, String city) throws Exception {
		Object getSingleCountryAndAllCityInState = externalApis.getSingleCountryAndAllCityInState(country, city);
		if (ObjectUtils.isEmpty(getSingleCountryAndAllCityInState)) {
			log.error(MSG_ERROR_INVOKING);
			throw new Exception(MSG_ERROR_INVOKING);
		}
		return getSingleCountryAndAllCityInState;
	}
}
