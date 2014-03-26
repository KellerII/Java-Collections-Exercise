/*	ITCS 4180 - 091
 * 	Date:  1/28/2014
 * 	Assignment:  HW1
 * 	Author:  James Keller
 */

package edu.uncc.itcs4180;

//User defined vehicle class with the required attributes per the assignment and an override to the toString method. Getters were also included
//to assist with printing
public class Vehicle {
	private String model_year;
	private String manufacturer_name;
	private String model_name;
	private String type;
	private String horse_power;
	private String no_cylinders;
	private String no_gears;
	
	//Constructor
	public Vehicle(String year, String manufacturer, String model, String type, String horsePower, String noCylinders, String noGears) {
		model_year = year;
		manufacturer_name = manufacturer;
		model_name = model;
		this.type = type;
		horse_power = horsePower;
		no_cylinders = noCylinders;
		no_gears = noGears;
	}
	
	public String getModelYear() {
		return model_year;
	}
	
	public String getManufacturer() {
		return manufacturer_name;
	}
	
	//Override for the default toString based on the assignment instructions
	@Override
	public String toString() {
		return model_year + ", " + manufacturer_name + ", " + model_name + ", " + type + ", " + horse_power + ", " + no_cylinders + ", " + no_gears;
	}
	
	//Hashcode override default by Eclipse to allow user defined object comparison when dealing with map structures
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((horse_power == null) ? 0 : horse_power.hashCode());
		result = prime
				* result
				+ ((manufacturer_name == null) ? 0 : manufacturer_name
						.hashCode());
		result = prime * result
				+ ((model_name == null) ? 0 : model_name.hashCode());
		result = prime * result
				+ ((model_year == null) ? 0 : model_year.hashCode());
		result = prime * result
				+ ((no_cylinders == null) ? 0 : no_cylinders.hashCode());
		result = prime * result
				+ ((no_gears == null) ? 0 : no_gears.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	//Equals method override default by Eclipse to allow user defined object comparison when dealing with map structures
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (horse_power == null) {
			if (other.horse_power != null)
				return false;
		} else if (!horse_power.equals(other.horse_power))
			return false;
		if (manufacturer_name == null) {
			if (other.manufacturer_name != null)
				return false;
		} else if (!manufacturer_name.equals(other.manufacturer_name))
			return false;
		if (model_name == null) {
			if (other.model_name != null)
				return false;
		} else if (!model_name.equals(other.model_name))
			return false;
		if (model_year == null) {
			if (other.model_year != null)
				return false;
		} else if (!model_year.equals(other.model_year))
			return false;
		if (no_cylinders == null) {
			if (other.no_cylinders != null)
				return false;
		} else if (!no_cylinders.equals(other.no_cylinders))
			return false;
		if (no_gears == null) {
			if (other.no_gears != null)
				return false;
		} else if (!no_gears.equals(other.no_gears))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
