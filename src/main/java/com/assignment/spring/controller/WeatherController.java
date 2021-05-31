package com.assignment.spring.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.assignment.spring.WeatherEntity;
import com.assignment.spring.WeatherRepository;
import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.exception.InternalServerErrorException;

@RestController
public class WeatherController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WeatherRepository weatherRepository;

	/** Open weather URL from yml **/
	@Value("${spring.open-weather.url}")
	private String weatherApiUrl;

	/**
	 * Fetch weather details based on city
	 * 
	 * @param city
	 * @return response
	 */
	@GetMapping("/api/weather")
	public WeatherEntity weather(@NotNull @Valid @NotBlank @RequestParam(required = true) String city) {
		ResponseEntity<WeatherResponse> response = null;
		if (city.isEmpty() || city.isBlank()) {
			throw new InternalServerErrorException("City is invalid");
		} else {
			String url = weatherApiUrl.replace("{city}", city);

			response = restTemplate.getForEntity(url, WeatherResponse.class);
		}
		return mapper(response.getBody());
	}

	private WeatherEntity mapper(WeatherResponse response) {
		var entity = new WeatherEntity();
		if (null != response) {
			entity.setCity(response.getName());
			entity.setCountry(response.getSys().getCountry());
			entity.setTemperature(response.getMain().getTemp());
		}
		return weatherRepository.save(entity);
	}
}
