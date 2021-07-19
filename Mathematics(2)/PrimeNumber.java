/*
Find whether the number is prime or not

Input : 13
O/p : true

Input : 14
o/p : false

Input : 101
O/p : true
*/

import java.util.*;

class PrimeNumber{
	
	//Simple Solution
	//Time Complexity : O(n)
	//Space Complexity : O(1)
	public static boolean checkPrime(int a){
		if(a == 2)
			return true;
		if((a%2 == 0) || (a == 1))
			return false;
		
		for(int i=3; i < a; i++){
			if(a % i == 0)
				return false;
		}
		return true;
	}
	
	//efficient Solution
	//If (x,y) is a pair of divisors of a given number "n" then x*y = n
	//and if x <= y then x*x <= n or x <= sqrt(n)
	//So we check number which divide given number n only till sqrt(n) to determine prime or not
	//Time Complexity : O(Sqrt(n))
	//Space complexity : O(1)
	public static boolean checkPrimeEfficient(int a){
		if(a == 1)
			return false;
			
		for(int i=2; i*i <= a; i++){
			if(a % i == 0)
				return false;
		}
		return true;
	}
	
	//We can make above solution more efficient in following way
	//We skip the iteration of 2 and 3 and there multiples in the for loop which helps us avoid many cases
	//we start fro m 5 and check two divisibility conditions at one time
	//And still the upper bound is O(Sqrt(n)) in worst case
	public static boolean checkPrimeMoreEfficient(int a){
		if(a == 1)
			return false;
		if(a == 2 || a == 3)
			return true;
		if(a % 2 == 0 || a % 3 == 0)
			return false;
		
		for(int i=5; i*i <= a; i=i+6){
			if(a%i == 0 || a%(i+2) == 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		int x = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter the number : ");
			x = sc.nextInt();
		
			System.out.println("Status(Simple) : "+checkPrime(x));
			System.out.println("Status(Efficient) : "+checkPrimeEfficient(x));
			System.out.println("Status(More Efficient) : "+checkPrimeMoreEfficient(x));
		}
	}
}