/*
Finding Prime Factors of a number.

Input : 12
O/p : 2,2,3

Input : 13
o/p : 13

Input : 315
O/p : 3,3,5,7
*/

import java.util.*;

class PrimeFactors{
	
	//function to check prime or not
	public static boolean isPrime(int n){
		if(n == 1)
			return false;
		if(n == 2 || n == 3)
			return true;
		if(n % 2 == 0 || n % 3 == 0)
			return false;
			
		for(int i = 5; i*i <= n; i=i+6){
			if(n % i == 0 || n % (i+2) == 0)
				return false;
		}
		
		return true;
	}
	
	//simple solution
	//Time complexity : O(n) calls for isPrime function * O(n) for the for loop * log(n) for the while loop = O(n^2 log(n))
	//Space Complexity : O(1)
	public static void primeFactor(int x){
		
		for(int i=2; i<=x; i++){ //O(n) for this for loop
			if(isPrime(i)){	     //O(n) times call to isPrime function
				int k = i;
				while(x % k == 0){ //this goes for approx log n times
					System.out.println(i);
					k = k*i;
				}
			}
		}
	}
	
	//Efficient solution 
	//A number has divisors, and divisors occur in pair, like for number 30, divisors : (1,30),(2,15),(3,10),(5,6)
	//if x,y is a pair of divisor for number n such that x*y = n and if x <= y then x*x < n => x <= Sqrt(n) 
	//Time Complexity : O(Sqrt(n))
	//Space Complexity : O(1)
	public static void efficientPrimeFactor(int x){
		if(x == 1) return;
		
		for(int i=2; i*i <= x; i++){ //this goes for Sqrt(n) times in worst case
			while(x % i == 0){		 //this might go for log(n) times
				System.out.println(i);
				x = x/i;
			}
		}
		if(x > 1)
			System.out.println(x);
	}
	
	//More efficient Solution
	//We can make above aolution more efficient by checking conditions for 2 and 3 early before the main loop
	//This will eliminate most numbers with factors of 2 and 3
	//Also we will modify the loop, so that it runs for less than Sqrt(n) times
	//Time Complexity  : O(Sqrt(n)) if n is Prime number else faster
	//Space Complexity : O(1)
	public static void moreEfficientPrimeFactor(int x){
		if(x == 1) return;
		
		//Below we are checking for factors of 2 and 3 before the loop to shorten the number of conditions to check
		while(x % 2 == 0){
			System.out.println(2);
			x = x/2;
		}
		
		while(x%3 == 0){
			System.out.println(3);
			x = x/3;
		}
		
		for(int i=5; i*i <= x; i=i+6){ //It runs for less than Sqrt(n) times
			while(x%i == 0){
				System.out.println(i);
				x = x/i;
			}
			
			while(x%(i+2) == 0){
				System.out.println(i+2);
				x = x / (i+2);
			}
		}
		
		if(x > 3) //Condition changed from 1 to 3 because we have checked for 1,2,3 before itself
				System.out.println(x);
	}
	
	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0 ){
			System.out.println("Enter the number : ");
			n = sc.nextInt();
			
			System.out.println("Prime Factors : ");
			primeFactor(n);
			System.out.println("Prime Factor(Efficient): ");
			efficientPrimeFactor(n);
			System.out.println("Prime Factor(More Efficient): ");
			moreEfficientPrimeFactor(n);
		}
	}
}