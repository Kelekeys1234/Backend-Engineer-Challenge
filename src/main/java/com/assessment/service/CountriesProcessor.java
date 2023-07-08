package com.assessment.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.assessment.external.api.ExternalApis;
import com.netflix.eureka.registry.Key.EntityType;

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

	public List<Object> getSinglCountryAndPopulationData(String country) throws Exception {
		Object getPopulation = externalApis.getSinglCountryAndPopulationData(country);
		Object getCapital = externalApis.getSingleCountryAndCapital(country);
		Object getPosition = externalApis.getSingleCountryAndItsPositions(country);
		Object getCurrency = externalApis.getSingleCountryAndItsCurrency(country);
		Object getIso2And3 = externalApis.getSingleCountryAndISO2And3Codes(country);
		List<Object> countrys = Arrays.asList(getPopulation, getCapital, getPosition, getCurrency, getIso2And3);

		return countrys;
	}

	public List<Object> getSingleCountryAndItsStates(String country, String state) throws Exception {
		Object getSingleCountryAndAllStates = externalApis.getSingleCountryAndAllCityInState(country, state);
		Object getSingleCountryAndItsStates = externalApis.getSingleCountryAndItsStates(country);
		List<Object> countrys = Arrays.asList(getSingleCountryAndItsStates, getSingleCountryAndAllStates);
		return countrys;
	}
}
