package org.world.rs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.world.rs.entity.CountryLanguage;
import org.world.rs.repository.CountryLanguageRepository;

@RestController
public class CountryLanguageController {
	@Autowired
	private CountryLanguageRepository countryLanguageRepository;
	
	@RequestMapping(value="/language", method = RequestMethod.GET,  produces="application/json")
	public List<CountryLanguage> getAll() {
		return countryLanguageRepository.getAll();
	}
	
	@RequestMapping(value="/language/country/{countryCode}", method = RequestMethod.GET,  produces="application/json")
	public List<CountryLanguage> getByCountryCode(@PathVariable String countryCode) {
		return  countryLanguageRepository.getByCountryCode(countryCode);
	}
	
	@RequestMapping(value="/language/{language}", method = RequestMethod.GET,  produces="application/json")
	public List<CountryLanguage> getByLanguage(@PathVariable String language) {
		return   countryLanguageRepository.getByLanguage(language);
	}
}
