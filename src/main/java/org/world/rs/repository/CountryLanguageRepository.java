package org.world.rs.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.world.rs.entity.CountryLanguage;

@Repository
@Transactional
public class CountryLanguageRepository {
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession(){
		return _sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<CountryLanguage> getAll() {
		return (List<CountryLanguage>) getSession().createQuery("from CountryLanguage").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<CountryLanguage> getByCountryCode(String countryCode) {
		return (List<CountryLanguage>) getSession().createQuery("from CountryLanguage where countryLanguagePK.countryCode = :countryCode")
				.setParameter("countryCode", countryCode).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<CountryLanguage> getByLanguage(String language) {
		return (List<CountryLanguage>) getSession().createQuery("from CountryLanguage where countryLanguagePK.language = :language")
				.setParameter("language", language).list();
	}
}
