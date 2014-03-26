/*	ITCS 4180 - 091
 * 	Date:  1/28/2014
 * 	Assignment:  HW1
 * 	Author:  James Keller
 */

package edu.uncc.itcs4180;

public class User {
	private String firstName;
	private String midInit;
	private String lastName;
	private String age;
	private String city;
	private String state;
	
	//Constructor
	public User(String firstName, String midInit, String lastName, String age, String city, String state) {
		this.firstName = firstName;
		this.midInit = midInit;
		this.lastName = lastName;
		this.age = age;
		this.city = city;
		this.state = state;
	}
	
	public String getAge() {
		return age;
	}
	
	//Method toString override for printing
	@Override
	public String toString() {
		return firstName + ", " + midInit + ", " + lastName + ", " + age + ", " + city + ", " + state;
	}

	//Hashcode method override for comparing equal user objects
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((midInit == null) ? 0 : midInit.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	//Equals method override for comparing equal user objects
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (midInit == null) {
			if (other.midInit != null)
				return false;
		} else if (!midInit.equals(other.midInit))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
}
