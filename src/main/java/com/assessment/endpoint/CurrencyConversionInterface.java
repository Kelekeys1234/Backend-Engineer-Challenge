package com.assessment.endpoint;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assessment.dto.ExchangeDto;

@RequestMapping(value = "api/v1")
public interface CurrencyConversionInterface {

	@GetMapping("currency/conversion")
	ResponseEntity<ExchangeDto> currencyConversion(@RequestParam("country") String country,
			@RequestParam("sourceCurrency") String sourceCurrency,
			@RequestParam("targetCurrency") String targetCurrency, @RequestParam("amount") double amount)
			throws IOException;
}
