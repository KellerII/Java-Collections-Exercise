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

public class UserMap {
	private String file;
	private BufferedReader bufferedReader;
	private String line = "";
	private String delimiter = ",";
	Map<User, Integer> userMap = new HashMap<User, Integer>();
	
	//Allows reuse of the class by allowing the user to set the filepath
	public void setFileName(String fileName) {
		file = fileName;
	}
	
	//Method with modified code provided in the assignment with try/catch statements that read and parse CSV files, create user defined 
	//user objects, while placing them in a hashmap
	//User objects are placed as keys, whereas an Integer count is used for the value
	public void mapFrequency() {		
		try {
			try {
				bufferedReader = new BufferedReader(new FileReader(file));
				while ((line = bufferedReader.readLine()) != null) {
					String[] userArray = line.split(delimiter);
					//Passing empty Strings to the constructor for this collections since comparisons
					//will be made using only 2 attributes
					User user = new User(userArray[0], userArray[1], userArray[2], userArray[3], userArray[4], userArray[5]);
					
					//Compares the current user object to other users that are in the hashmap
					//if the user isn't found it is placed as a key with a value of 1, otherwise
					//the value for found user is incremented by 1
					if (userMap.isEmpty()) {
						userMap.put(user, new Integer(1));
					} else if(userMap.containsKey(user)) {
				        Integer count = (Integer)userMap.get(user);
				        userMap.put(user, new Integer(count.intValue() + 1));
				    } else {
				        userMap.put(user, new Integer(1));
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
