package com.example.demo;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.map.repository.config.EnableMapRepositories;

import javax.annotation.PostConstruct;

@EnableMapRepositories
@SpringBootApplication
public class DemoApplication {

	private final CountryRepository countryRepository;

	@Autowired
	public DemoApplication(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PostConstruct
	void init() {
		countryRepository.save(new Country(1, "Russia", "RU"));
		countryRepository.save(new Country(2, "Germany", "GE"));

		countryRepository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
