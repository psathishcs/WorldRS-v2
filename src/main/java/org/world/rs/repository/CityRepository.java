package org.world.rs.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.world.rs.entity.City;

@Repository
@Transactional
public class CityRepository {
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession(){
		return _sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<City> getAll() {
		return (List<City>) getSession().createQuery("from City").list();
	}

	public City getByID(Integer id) {
			return (City) getSession().createQuery("from City where id = :id")
				.setParameter("id", id).uniqueResult();

	}
	
	public City getByName(String name) {
		return (City) getSession().createQuery("from City where name = :name")
			.setParameter("name", name).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<City> getByCountyCode(String countryCode) {
		return (List<City>) getSession().createQuery("from City where countryCode = :countryCode")
			.setParameter("countryCode", countryCode).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<City> getByCountyName(String countryName) {
		return (List<City>) getSession().createQuery("FROM City WHERE countryCode IN ( SELECT code FROM Country co where co.name = :countryName")
			.setParameter("countryName", countryName).list();
	}
	

}
