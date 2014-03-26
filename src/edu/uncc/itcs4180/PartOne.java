/*	ITCS 4180 - 091
 * 	Date:  1/28/2014
 * 	Assignment:  HW1
 * 	Author:  James Keller
 */

package edu.uncc.itcs4180;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class PartOne {
	public static void main(String[] args) {
		//Creates a hashmap based on the input of both text files. As the txt files are parsed and user objects are created
		//duplicates are identified and counted in the hashmap
		UserMap totalUsers = new UserMap();
		totalUsers.setFileName("/Users/jtkeller2/UNC Charlotte/Spring 2014/ITCS 4180/src/edu/uncc/itcs4180/userListOld.txt");
		totalUsers.mapFrequency();
		//System.out.println(totalUsers.userMap.size());
		totalUsers.setFileName("/Users/jtkeller2/UNC Charlotte/Spring 2014/ITCS 4180/src/edu/uncc/itcs4180/userListNew.txt");
		totalUsers.mapFrequency();
		//System.out.println(totalUsers.userMap.size());
		
		//New treemap for sorting user objects in order by age
		Map<String, User> uniques = new TreeMap<String, User>(Collections.reverseOrder());
		
		//Iterating through the user objects in the hashmap to identify those that only
		//occurred once (are unique). Those unique users are then placed in a treemap
		//while reversing the key for value and inserting user age for a key for sorting
		//using the reverseorder method from Collections
	    for (Map.Entry<User, Integer> entry : totalUsers.userMap.entrySet()) {
	    	//System.out.println(entry.getKey() + " = " + entry.getValue());
	    	if (entry.getValue() == 1) {
	    		//System.out.println(entry.getKey());
	    		uniques.put(entry.getKey().getAge(), entry.getKey());
	    	}
	    }
	    //Printing unique set size based on the assignment instructions
	    System.out.println("Total Size for the Unique Set: " + uniques.size());
	    //Printing the uniques in ascending order
	    System.out.println("\n------------------------");
	    System.out.println("Uniques in Ascending Order:");
	    System.out.println("------------------------");
	    for (Map.Entry<String, User> entry : uniques.entrySet()) {
	    	System.out.println(entry.getValue());
	    }
	}
}
