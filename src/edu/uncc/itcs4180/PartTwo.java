/*	ITCS 4180 - 091
 * 	Date:  1/28/2014
 * 	Assignment:  HW1
 * 	Author:  James Keller
 */

package edu.uncc.itcs4180;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class PartTwo {
	public static void main(String[] args) throws IOException {
		ParseAndBuild rawData = new ParseAndBuild();
		rawData.setFileName("/Users/jtkeller2/UNC Charlotte/Spring 2014/ITCS 4180/src/edu/uncc/itcs4180/raw_data.csv");
		//Creates a linked list from the raw_data.csv file
		rawData.buildVehicleList();
		String fileName = "/Users/jtkeller2/UNC Charlotte/Spring 2014/ITCS 4180/src/edu/uncc/itcs4180/distinct_vehicles.csv";
		
//		//Demonstrates vehicle object storage/control/printing in a linked list
//		//Used for testing
//		System.out.println("Demonstrating control/printing of the vehicle object list:");
//		for (Vehicle v : rawData.vehicleList) {
//		System.out.println(v);
//		}
//		System.out.println("Raw Data Vehicle Object Count: " + rawData.vehicleList.size());
		
		//Creates a linked hash set and then adds the vehicle objects from the list
		//in order to remove duplicates, while preserving order
		Set<Vehicle> distinctSet = new LinkedHashSet<Vehicle>();
		for (Vehicle v : rawData.vehicleList) {
			distinctSet.add(v);
		}
		
//		//Demonstrates duplicate removal
//		System.out.println("\nDemonstrating the removal of duplicate vehicle objects:");
//		for (Vehicle v : distinctSet) {
//		System.out.println(v);
//		}
//		System.out.println("Vehicle Object Count: " + distinctSet.size() + "\n");
		
		//Creates a distinct_vehicles.csv file and writes to the file from
		//the distinctSet
		try {
		    PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
		    for (Vehicle v: distinctSet) {
		    outFile.println(v);
		    }
		    outFile.close();
		} catch (IOException e) {
			System.out.println("Something went wrong. Please check your filepath and try again.");
			e.printStackTrace();
	    }
	    
	    //Creates a hashmap from the distinct.csv file using the value of the map to count the frequency of vehicles
	    //with the same year and manufacturer
	    BuildMap distinctData = new BuildMap();
	    distinctData.setFileName("/Users/jtkeller2/UNC Charlotte/Spring 2014/ITCS 4180/src/edu/uncc/itcs4180/distinct_vehicles.csv");
	    distinctData.mapFrequency();
	    
	    //Prints the frequency hashmap based on formatting instructions provided in the assignment
	    int count = 1;
	    for (Map.Entry<Vehicle, Integer> entry : distinctData.vehicleMap.entrySet()) {
	        System.out.println(count + "-" + ((Vehicle) entry.getKey()).getModelYear().trim() + "-" + ((Vehicle) entry.getKey()).getManufacturer().trim() 
	        		+ ":" + entry.getValue());
	        count++;
	    }
	    System.out.println("------------------------------------------");
	    System.out.println("Total: " + distinctData.vehicleMap.size());
	    System.out.println("------------------------------------------");
	    
	    //Copies the hashmap created from the distinct_data.csv into a treemap, while reversing the 
	    //keys and values since treemaps normally sort by key
	    //Calls on a method in the Collection library to reverse the sort order
	    Map<Integer, Vehicle> sortedMap = new TreeMap<Integer, Vehicle>(Collections.reverseOrder());
	    for (Map.Entry<Vehicle, Integer> entry : distinctData.vehicleMap.entrySet()) {
	    	sortedMap.put(entry.getValue(), entry.getKey());
	    }
	    
	  //Prints the frequency treemap based on formatting instructions provided in the assignment
	    System.out.println("\n------------------------------------------");
	    System.out.println("Top 10 Models:");
	    System.out.println("------------------------------------------");
	    count = 1;
	    //Using a custom iterator to print the treemap 10 times
	    Set<Entry<Integer, Vehicle>> set = sortedMap.entrySet();
	    Iterator<Entry<Integer, Vehicle>> it = set.iterator();
	    while(count < 11) {
	    	Map.Entry<Integer, Vehicle> sm = (Map.Entry<Integer, Vehicle>)it.next();
		    	System.out.println(count + "-" + ((Vehicle) sm.getValue()).getModelYear().trim() + "-" + ((Vehicle) sm.getValue()).getManufacturer().trim() 
		        		+ ":" + sm.getKey());
		    	count++;
	      }
	}
}
