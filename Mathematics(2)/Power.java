/*
For a number, find its power to a given number.

Input : x=2 and n=3, n>=0
O/p : 8

Input : x=3 and n=4
O/p : 81

Input : x=5 and n=0
O/p : 1

Input : x=5 and n=1
O/p : 5
*/

import java.util.*;

class Power{
	
	//Simple Solution
	//Time Complexity : O(n)
	//Space Complexity : O(1) 
	public static int findPower(int x, int n){
		int res = 1;
		
		for(int i=0; i<n; i++){
			res = res * x;
		}
		
		return res;
	}
	
	//Efficient Solution
	//It is based on the concept that, power(x,n) = if(n%2 == 0)
	//													power(x,n/2) * power(x,n/2)
	//												else
	//													power(x,n-1) * x
	//Time Complexity : O(log n)
	//Auxiliary Space : O(log n)
	public static int findPowerRecurrsive(int x, int n){
		if(n == 0)
			return 1;
		int temp = power(x,n/2);
		temp = temp * temp;
		if(n%2 == 0)
			return temp;
		else
			return temp * x;
	}
	/*
	Time Complexity : 
		T(n) = T([n/2]) + O(1)
		if n=16
						O(1) ..........n=16
						/
					   O(1)  ..........n=8
					   /
					 O(1)    ..........n=4
					 /
				    O(1)     ..........n=2
					.......
					
		For recurrsive calls we also require log(n) auxiliary space
	*/
	
	public static void main(String[] args){
		int x=1, n=1;
		
		Scanner sc = new Scanner(System.in);
		
		while(x > 0){
			System.out.println("Enter the number to find the power of : ");
			x = sc.nextInt();
			
			System.out.println("Enter the power : ");
			n = sc.nextInt();
			
			System.out.println("Result : "+findPower(x,n));
		}
	}
}