package com.assessment.service;

import java.io.FileReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.assessment.dto.ExchangeDto;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExchangeProcessor {
	public ExchangeDto currencyRateConversion(String country, String sourceCurrency, String targetCurrency,
			double amount) throws IOException {
		log.info("reading csv file");
		CSVReader reader = new CSVReader(new FileReader("exchange_rate.csv"), ',');
		HeaderColumnNameMappingStrategy<ExchangeDto> beanStrategy = new HeaderColumnNameMappingStrategy<ExchangeDto>();
		beanStrategy.setType(ExchangeDto.class);
		CsvToBean<ExchangeDto> csvToBean = new CsvToBean<ExchangeDto>();
		List<ExchangeDto> exchange = csvToBean.parse(beanStrategy, reader);
		log.info("getting rate for source and target currency");
		String rate = exchange.stream()
				.filter(a -> a.getSourceCurrency().equalsIgnoreCase(sourceCurrency)
						&& a.getTargetCurrency().equalsIgnoreCase(targetCurrency))
				.map(e -> e.getRate()).collect(Collectors.joining(","));
		double rateCalculation = Double.valueOf(rate) * Double.valueOf(amount);
		ExchangeDto exchangeDto = new ExchangeDto();
		exchangeDto.setRate(rate);
		exchangeDto.setSourceCurrency(sourceCurrency);
		exchangeDto.setTargetCurrency(targetCurrency);
		exchangeDto.setTargetCurrencyTotalAmount(rateCalculation);
		exchangeDto.setCountry(country);
		reader.close();
		return exchangeDto;

	}

}
