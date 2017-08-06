package org.world.rs.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CountryLanguagePK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String countryCode;
	private String language;
	
	public CountryLanguagePK() {}
	
	public CountryLanguagePK(String countryCode, String language){
		this.countryCode = countryCode;
		this.language = language;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("CountryCode = ").append(countryCode).append(", ")
				.append("Language = ").append(language).append(", ");
		return str.toString();
	}

}
