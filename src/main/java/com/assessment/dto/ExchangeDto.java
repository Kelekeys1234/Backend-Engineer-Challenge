package com.assessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDto {
	@JsonProperty("sourceCurrency")
	private String sourceCurrency;

	@JsonProperty("targetCurrency")
	private String targetCurrency;

	@JsonProperty("rate")
	private String rate;

	@JsonProperty("target_currency_total_amount")
	private double targetCurrencyTotalAmount;

	@JsonProperty("country")
	private String country;
}
