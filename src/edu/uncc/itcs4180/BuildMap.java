/*	ITCS 4180 - 091
 * 	Date:  1/28/2014
 * 	Assignment:  HW1
 * 	Authors:  James Keller
 * 			  Kenneth Holsey
 */

package edu.uncc.itcs4180;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BuildMap {
	private String file;
	private BufferedReader bufferedReader;
	private String line = "";
	private String delimiter = ",";
	Map<Vehicle, Integer> vehicleMap = new HashMap<Vehicle, Integer>();
	
	//Allows reuse of the class by allowing the user to set the filepath
	public void setFileName(String fileName) {
		file = fileName;
	}
	
	//Method with modified code provided in the assignment with try/catch statements that read and parse CSV files, create user defined 
	//vehicle objects, while placing them in a hashmap
	//Vehicle objects are placed as keys, whereas an Integer count is used for the value
	public void mapFrequency() {		
		try {
			try {
				bufferedReader = new BufferedReader(new FileReader(file));
				while ((line = bufferedReader.readLine()) != null) {
					String[] vehicleArray = line.split(delimiter);
					//Passing empty Strings to the constructor for this collections since comparisons
					//will be made using only 2 attributes
					Vehicle vehicle = new Vehicle(vehicleArray[0], vehicleArray[1], "", "", "", "", "");
					
					//Compares the current vehicle object to other vehicles that are in the hashmap
					//if the vehicle isn't found it is placed as a key with a value of 1, otherwise
					//the value for found vehicle is incremented by 1
					if (vehicleMap.isEmpty()) {
						vehicleMap.put(vehicle, new Integer(1));
					} else if(vehicleMap.containsKey(vehicle)) {
				        Integer count = (Integer)vehicleMap.get(vehicle);
				        vehicleMap.put(vehicle, new Integer(count.intValue() + 1));
				    } else {
				        vehicleMap.put(vehicle, new Integer(1));
				    }
				 }
			} finally {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Something went wrong. Please check your filepath and try again.");
			e.printStackTrace();
		}
		
	}
}
