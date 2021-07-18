/*
Finding GCD of two numbers

Input : 4 and 6
Output: 2

Input : 100 and 200
Output: 100

Input : 7 and 13
Output: 1
*/

import java.util.*;

class GCD{
	
	//Simple Solution
	//We know, gcd <= min(a,b)
	//Time Complexity :  Worst case = O(min(a,b)), Best case = O(1)
	//Space Complexity : O(1)
	public static int findGCD(int x , int y){
		if(x % y == 0)
			return y;
		else if(y % x == 0)
			return x;
		
		for(int i = (x > y ? y : x) - 1; i>0 ;i--){
			if(x % i == 0){
				if(y % i == 0){
					return i;
				}
			}
		}
		
		return 0;
	}
	
	//Efficient Solution using Euclidean Algorithm
	//Time Complexity : O(log(min(a,b)))
	public static int findGCDRecursive(int x, int y){
		if(y == 0)
			return x;
		else
			return findGCDRecursive(y, x%y);
	}
	
	//Another Approach for Euclidean Algorithm
	//Time Complexity : O(log(min(a,b)))
	public static int findGCDDifference(int x, int y){
		while(x != y){
			if(x > y)
				x = x-y;
			else
				y = y-x;
		}
		
		return x; //Can also return "y" as both are equal
	}
	
	public static void main(String[] args){
		Scanner sc  = new Scanner(System.in);
		
		int x = 0, y = 0;

		System.out.println("Enter the numbers : ");
		x = sc.nextInt();
		y = sc.nextInt();
		
		System.out.println(findGCD(x,y));
		System.out.println(findGCDRecursive(x,y));
		System.out.println(findGCDDifference(x,y));
	}
}