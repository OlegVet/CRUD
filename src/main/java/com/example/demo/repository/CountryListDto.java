package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

public class CountryListDto implements Serializable {
    private static final long serialVersionUID = 5138606398554025928L;

    List<CountryDto> countryList;

    public CountryListDto() {
    }

    public List<CountryDto> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryDto> countryList) {
        this.countryList = countryList;
    }
}
