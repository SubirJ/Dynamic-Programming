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
	//
	public static void printPowerSet(String str){
		int n = str.length();
		int powSize = (int)Math.pow(2,n);
		
		for(int counter=0; counter < powSize; counter++){
			for(int j=0; j < n; j++){
				if((counter & (1 << j)) != 0)
					System.out.print(str.charAt(j));
			}
			System.out.println("");
		}
	}

	public static void main(String[] args){
		String str = "";
		
		Scanner sc = new Scanner(System.in);
		
		while(str != null){
			System.out.println("Enter the string to get the power set of : ");
			str = sc.next();
			
			System.out.println("Power set is : ");
			printPowerSet(str);
		}
	}
}