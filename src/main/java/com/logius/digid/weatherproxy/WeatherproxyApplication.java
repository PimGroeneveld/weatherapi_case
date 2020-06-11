package com.logius.digid.weatherproxy;

import com.logius.digid.weatherproxy.entities.CityEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherproxyApplication {

	private static final Logger log = LoggerFactory.getLogger(WeatherproxyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WeatherproxyApplication.class, args);
	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//
//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//			String key = "e617cfacae8e5b0dfc77a7b8044c3d1d";
//			CityEntity city = restTemplate.getForObject(
//					"https://api.openweathermap.org/data/2.5/weather?q=Utrecht&appid=" + key, CityEntity.class);
//			log.info(city.toString());
//		};
//	}

}
