/*
Finding the power set of a given string.

Input : "abc"
O/p : "","a","b","c","ab","ac","bc","abc"

Input : "ab"
O/p : "","a","b","ab"

Note : the combinations of a string with "n" characters is 2^n.
	   Like, the power set of "abc" with 3 characters will have 2^3 = 8 combinations like we can see above
*/

import java.util.*;

class PowerSet{
	
	//function to find Power Set
	public static void printPowerSet(String str){
		int n = str.length();
		int powSize = Math.pow(2,n);
		
		
	}

	public static void main(Stringp[] args){
		String str = "";
		
		Scanner sc = new Scanner(System.in);
		
		while(str != "1"){
			System.out.println("Enter the string to get the power set of : ");
			str = sc.next();
			
			System.out.println("Power set is : ");
			printPowerSet(str);
		}
	}
}