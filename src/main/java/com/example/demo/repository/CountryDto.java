package com.example.demo.repository;

import com.example.demo.model.Country;

public class CountryDto {

    private int id;

    private String name;

    private String codeName;

    public CountryDto(int id, String name, String codeName) {
        this.id = id;
        this.name = name;
        this.codeName = codeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public static CountryDto toDto(Country country) {
        return new CountryDto(country.getId(), country.getName(), country.getCodeName());
    }

    public static Country fromDto(CountryDto countryDto) {
        return new Country(countryDto.getId(), countryDto.getName(), countryDto.getCodeName());
    }
}
