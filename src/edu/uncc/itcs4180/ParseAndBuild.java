/*	ITCS 4180 - 091
 * 	Date:  1/28/2014
 * 	Assignment:  HW1
 * 	Authors:  James Keller
 * 			  Kenneth Holsey
 */

package edu.uncc.itcs4180;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ParseAndBuild {
	private String file;
	private BufferedReader bufferedReader;
	private String line = "";
	private String delimiter = ",";
	List<Vehicle> vehicleList = new LinkedList<Vehicle>();
	
	//Allows reuse of the class by allowing the user to set the filepath
	public void setFileName(String fileName) {
		file = fileName;
	}
	
	//Method with modified code provided in the assignment with try/catch statements that read and parse CSV files, create user defined 
	//vehicle objects, while placing them in a linked list
	public void buildVehicleList() {		
		try {
			try {
				bufferedReader = new BufferedReader(new FileReader(file));
				while ((line = bufferedReader.readLine()) != null) {
					String[] vehicleArray = line.split(delimiter);
					//An array is used to hold the individual Strings created during the parsing process
					//these arrays are then passed to the Vehicle constructor for object initialization and creation
					Vehicle vehicle = new Vehicle(vehicleArray[0], vehicleArray[1], vehicleArray[2], vehicleArray[3], vehicleArray[4], vehicleArray[5], vehicleArray[6]);
					vehicleList.add(vehicle);
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
