package com.assessment.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.dto.ExchangeDto;
import com.assessment.endpoint.CurrencyConversionInterface;
import com.assessment.service.ExchangeProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CurrencyConversionController implements CurrencyConversionInterface {
	@Autowired
	private ExchangeProcessor exchangeProcessor;

	@Override
	public ResponseEntity<ExchangeDto> currencyConversion(String country, String sourceCurrency, String targetCurrency,
			double amount) throws IOException {
		log.info("inside currencyConversion controller");
		ExchangeDto exchangeProcessorResponse = exchangeProcessor.currencyRateConversion(country, sourceCurrency,
				targetCurrency, amount);
		return ResponseEntity.ok(exchangeProcessorResponse);
	}

}
