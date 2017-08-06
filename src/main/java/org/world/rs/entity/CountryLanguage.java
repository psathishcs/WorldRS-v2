package org.world.rs.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * 
 * @author sparthasarathy
 *
 *mysql> desc countrylanguage;
+-------------+---------------+------+-----+---------+-------+
| Field       | Type          | Null | Key | Default | Extra |
+-------------+---------------+------+-----+---------+-------+
| CountryCode | char(3)       | NO   | PRI |         |       |
| Language    | char(30)      | NO   | PRI |         |       |
| IsOfficial  | enum('T','F') | NO   |     | F       |       |
| Percentage  | float(4,1)    | NO   |     | 0.0     |       |
+-------------+---------------+------+-----+---------+-------+
4 rows in set (0.00 sec)
 */
@Entity
@Table(name="countrylanguage")
public class CountryLanguage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CountryLanguagePK countryLanguagePK;
	private char isOfficial;
	private float percentage;
	
	public enum IsOfficial{
		T,
		F
	}


	public CountryLanguagePK getCountryLanguagePK() {
		return countryLanguagePK;
	}

	public void setCountryLanguagePK(CountryLanguagePK countryLanguagePK) {
		this.countryLanguagePK = countryLanguagePK;
	}
	
	public char getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(char isOfficial) {
		this.isOfficial = isOfficial;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append(countryLanguagePK)
				.append("IsOfficial = ").append(isOfficial).append(", ")
				.append("Percentage = ").append(percentage).append(".");
				
		return str.toString();
	}
}
