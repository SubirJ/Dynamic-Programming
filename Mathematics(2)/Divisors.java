/*
Find the divisors of a given number 

Input : 15
O/p : 1, 3, 5, 15

Input : 100
O/p : 1,2,4,5,10,20,25,50,100

Input : 7
O/p : 1,7
*/

import java.util.*;

class Divisors{
	
	//Simple Solution 
	//Time Complexity : O(n)
	//Space Complexity : O(1)
	public static void findDivisors(int x){
		for(int i=1; i <= x/2; i++){
			if(x % i == 0)
				System.out.println(i);
		}
		System.out.println(x);
	}
	
	//Efficient Solution
	//Divisors of a number always appear in pairs
	//The smallest of the two divisors is always less that sqaure root of the given number
	//if x and y are two divisors of number n such that x*y = n and x <= y then x*x <= n => x <= Sqrt(n)
	//Time Complexity :  O(Sqrt(n))
	//Space Complexity : O(1)
	public static void efficientDivisors(int x){
		for(int i=1; i*i <= x; i++){
			if(x % i == 0){
				System.out.println(i);
				if(i != x/i)
					System.out.println(x/i);
			}
		}
	}
	
	//We will modify the above solution to print divisors in order keeping the Time Complexity as O(Sqrt(n))
	//We will run a loop for 1 to Sqrt(n) and then another loop from cuurent value of greater than or equal to sqrt(n) to 1
	//But in second loop we will print multiple of that divisors
	//Time Complexity : O(Sqrt(n))
	//Space Complexity : O(1)
	public static void printDivisors(int x){
		int i = 1;
		
		//first loop prints smaller divisors
		//It has Time Complexity as O(Sqrt(n))
		for(i=1; i*i < x; i++){
			if(x % i == 0)
				System.out.println(i);
		}
		
		//Second loop will print the bigger divisors of the above divisors
		//It has Time Complexity as O(Sqrt(n))
		for( ; i>=1; i--){
			if(x % i == 0){
				System.out.println(x/i);
			}
		}
		
		//Total Time Complexity of the function = O(Sqrt(n)) + O(Sqrt(n)) = O(Sqrt(n))
	}
	
	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the number : ");
			n = sc.nextInt();
			
			System.out.println("Divisors are : ");
			findDivisors(n);
			
			System.out.println("Divisors(Efficient, but not in order) : ");
			efficientDivisors(n);
			
			System.out.println("Divisors (Efficient and in order) : ");
			printDivisors(n);
		}
	}
}