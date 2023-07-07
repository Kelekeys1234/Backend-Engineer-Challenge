package com.assessment.service;

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

	public Object getSinglCountryAndPopulationData(String country, String entityType) throws Exception {
		Object getSinglCountryAndEntityType = null;
		if (entity.type.EntityType.POPULATION.toString().equalsIgnoreCase(entityType)) {
			getSinglCountryAndEntityType = externalApis.getSinglCountryAndPopulationData(country);
			if (ObjectUtils.isEmpty(getSinglCountryAndEntityType)) {
				log.error(MSG_ERROR_INVOKING);
				throw new Exception(MSG_ERROR_INVOKING);
			}
		}
		if (entity.type.EntityType.CAPITAL.toString().equalsIgnoreCase(entityType)) {
			getSinglCountryAndEntityType = externalApis.getSingleCountryAndCapital(country);
			if (ObjectUtils.isEmpty(getSinglCountryAndEntityType)) {
				log.error(MSG_ERROR_INVOKING);
				throw new Exception(MSG_ERROR_INVOKING);
			}
			if (entity.type.EntityType.LOCATION.toString().equalsIgnoreCase(entityType)) {
				getSinglCountryAndEntityType = externalApis.getSingleCountryAndItsPositions(country);
				if (ObjectUtils.isEmpty(getSinglCountryAndEntityType)) {
					log.error(MSG_ERROR_INVOKING);
					throw new Exception(MSG_ERROR_INVOKING);
				}
			}
			if (entity.type.EntityType.CURRENCY.toString().equalsIgnoreCase(entityType)) {
				getSinglCountryAndEntityType = externalApis.getSingleCountryAndItsCurrency(country);
				if (ObjectUtils.isEmpty(getSinglCountryAndEntityType)) {
					log.error(MSG_ERROR_INVOKING);
					throw new Exception(MSG_ERROR_INVOKING);
				}
			}
			if (entity.type.EntityType.ISO2AND3.toString().equalsIgnoreCase(entityType)) {
				getSinglCountryAndEntityType = externalApis.getSingleCountryAndISO2And3Codes(country);
				if (ObjectUtils.isEmpty(getSinglCountryAndEntityType)) {
					log.error(MSG_ERROR_INVOKING);
					throw new Exception(MSG_ERROR_INVOKING);
				}
			}

		}
		return getSinglCountryAndEntityType;
	}

	public Object getSingleCountryAndItsStates(String country, String state) throws Exception {
		Object getSingleCountryAndItsStates = null;
		if (!StringUtils.isEmpty(state)) {
			getSingleCountryAndItsStates = externalApis.getSingleCountryAndAllCityInState(country, state);
			if (ObjectUtils.isEmpty(getSingleCountryAndItsStates)) {
				log.error(MSG_ERROR_INVOKING);
				throw new Exception(MSG_ERROR_INVOKING);
			}
		} else if (StringUtils.isEmpty(state)) {
			getSingleCountryAndItsStates = externalApis.getSingleCountryAndItsStates(country);
			if (ObjectUtils.isEmpty(getSingleCountryAndItsStates)) {
				log.error(MSG_ERROR_INVOKING);
				throw new Exception(MSG_ERROR_INVOKING);

			}
		}
		return getSingleCountryAndItsStates;
	}

}
