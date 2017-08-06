package org.world.rs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.world.rs.entity.City;
import org.world.rs.repository.CityRepository;

@RestController
public class CityController {
	
	@Autowired
	private CityRepository cityRepository;
	
	@RequestMapping(value="/city", method = RequestMethod.GET, produces="application/json")
	public List<City> getAll() {
		return cityRepository.getAll();
	}
	
	@RequestMapping(value="/city/{cityID}", method = RequestMethod.GET,  produces="application/json")
	public City getByID(@PathVariable Integer cityID) {
		return cityRepository.getByID(cityID);
	}
	
	@RequestMapping(value="/city/name/{name}", method = RequestMethod.GET,  produces="application/json")
	public City getByName(@PathVariable String name) {
		return cityRepository.getByName(name);
	}
	
	@RequestMapping(value="/city/country/code/{countryCode}", method = RequestMethod.GET,  produces="application/json")
	public List<City> getByCountyCode(@PathVariable String countryCode) {
		return cityRepository.getByCountyCode(countryCode);
	}
	

}
