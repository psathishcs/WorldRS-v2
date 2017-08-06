package org.world.rs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author sparthasarathy
 *
	 *mysql> desc city;
	+-------------+----------+------+-----+---------+----------------+
	| Field       | Type     | Null | Key | Default | Extra          |
	+-------------+----------+------+-----+---------+----------------+
	| ID          | int(11)  | NO   | PRI | NULL    | auto_increment |
	| Name        | char(35) | NO   |     |         |                |
	| CountryCode | char(3)  | NO   | MUL |         |                |
	| District    | char(20) | NO   |     |         |                |
	| Population  | int(11)  | NO   |     | 0       |                |
	+-------------+----------+------+-----+---------+----------------+
	5 rows in set (0.00 sec)
 */
@Entity
@Table(name="city")
public class City  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="CountryCode")
	private String countryCode;
	
	@Column(name="District")
	private String district;
	
	@Column(name="Population")
	private String population;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("ID = ").append(id).append(", ")
							.append("Name = ").append(name).append(", ")
							.append("CountryCode = ").append(countryCode).append(", ")
							.append("District = ").append(district).append(", ")
							.append("population = ").append(population).append(".");
							
		return str.toString();
	}
}
