package com.example.demo.controller;

import com.example.demo.controller.exception.NotFoundException;
import com.example.demo.model.Country;
import com.example.demo.repository.CountryDto;
import com.example.demo.repository.CountryListDto;
import com.example.demo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryRepository repository;

    // GET request get all countries
    @GetMapping("/api/country/all")
    public List<CountryDto> getAll() {
        return repository.findAll().stream()
                .map(CountryDto::toDto)
                .collect(Collectors.toList());
    }

    // GET request get country by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/api/country/readById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryDto getById(@PathVariable int id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Country with id=" + id + " not found");
        }
        return CountryDto.toDto(repository.findById(id));
    }

    // GET request get country by name
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/api/country/readByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryDto getByName(@PathVariable String name) {
        Country country= repository.findByName(name);
        if (Objects.isNull(country)) {
            throw new NotFoundException("Country with name=" + name + " not found");
        }
        return CountryDto.toDto(country);
    }

    // GET request get country by code
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/api/country/readByCodeName/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryDto getByCode(@PathVariable String code) {
        Country country= repository.findByCodeName(code);
        if (Objects.isNull(country)) {
            throw new NotFoundException("Country with code=" + code + " not found");
        }
        return CountryDto.toDto(country);
    }

    // POST request update country by id
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/api/country/updateById", produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryDto save(@RequestBody CountryDto countryDto) {
        return CountryDto.toDto(repository.save(CountryDto.fromDto(countryDto)));
    }

    // POST request create country
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/api/country/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryDto create(@RequestBody CountryDto dto) {
        Country country = CountryDto.fromDto(dto);
        if (repository.existsById(country.getId())) {
            throw new IllegalArgumentException("Country with id=" + country.getId() + " is already exist");
        }

        return CountryDto.toDto(repository.save(country));
    }

    // POST request create list of countries
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/api/country/createAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryDto> createList(@RequestBody CountryListDto dtoList) {
        dtoList.getCountryList().forEach(countryDto -> {
            Country country = CountryDto.fromDto(countryDto);
            if (repository.existsById(country.getId())) {
                throw new IllegalArgumentException("Country with id=" + country.getId() + " is already exist");
            }
            CountryDto.toDto(repository.save(country));
        });
        return dtoList.getCountryList();
    }

    // GET request delete country by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/api/country/deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deteteById(@PathVariable int id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Country with id=" + id + " not found");
        }
        repository.deleteById(id);
    }

}
