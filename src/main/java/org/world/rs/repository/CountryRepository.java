package org.world.rs.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.world.rs.entity.Country;

@Repository
@Transactional
public class CountryRepository {
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession(){
		return _sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Country> getAll(){
		return (List<Country>) getSession().createQuery("from Country").list();
	}
	
	public Country getByID(String code){
		return (Country)getSession().createQuery("from Country where code = :code")
				.setParameter("code", code).uniqueResult();
	}
	
	public Country getByName(String name){
		return (Country)getSession().createQuery("from Country where name = :name")
				.setParameter("name", name).uniqueResult(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Country> getByContinent(String continent){
		return (List<Country>) getSession().createQuery("from Country where continent = :continent")
				.setParameter("continent", continent).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Country> getByRegion(String region){
		return (List<Country>) getSession().createQuery("from Country where region = :region")
				.setParameter("region", region).list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Country> getByCountryLessGNP(float gnp){
		return (List<Country>) getSession().createQuery("from Country where gnp <= :gnp")
				.setParameter("gnp", gnp).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Country> getByCountryGreateGNP(float gnp){
		return (List<Country>) getSession().createQuery("from Country where gnp >= :gnp")
				.setParameter("gnp", gnp).list();
	}
	
}
