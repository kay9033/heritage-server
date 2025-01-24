package com.example.demo.service;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {

  private final CountryRepository countryRepository;

  public CountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  public List<Country> getAllCountries() {
    return countryRepository.findAll();
  }

  public List<Country> getCountriesByRegion(Long regionId) {
    return countryRepository.findByRegionId(regionId);
  }

  public Country createCountry(Country country) {
    if (countryRepository.existsByName(country.getName())) {
      throw new IllegalArgumentException("Country already exists");
    }
    return countryRepository.save(country);
  }

  public void deleteCountry(Long id) {
    countryRepository.deleteById(id);
  }
}
