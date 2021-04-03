package com.example.demo.repository;

import com.example.demo.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {

    List<Country> findAll();

    Country findById(int id);

    Country findByName(String name);

    Country findByCodeName(String codeName);

    void deleteById(int integer);
}
