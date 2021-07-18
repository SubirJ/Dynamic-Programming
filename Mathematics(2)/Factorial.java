/*
Program to find factorial of a given number.

Input : 5
Output : 120

Input : 7
Output : 5040

Iterative solution is better than recursive
*/

import java.util.*;

class Factorial{
	
	//Iterative Solution
	//It will run for n-1 times
	//Time Complexity : O(n) / Theta(n)
	//No extra space is required
	//Auxiliary Space : O(1) / Theta(1)
	public static int findFactorialIteartive(int n){
		int result = 1;
		
		for(int i=2; i <= n; i++){
			result = result * i;
		}
		
		return result;
	}
	
	//Recursive Solution
	//Time Complexity : O(n) / Theta(n)
	//Auxiliary Space : O(n) / Theta(n)
	public static int findFactorial(int n){
		
		if(n == 1)
			return 1;
			
		return (n * findFactorial(n-1));
	}
	
	public static void main(String[] args){
		int n = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to find the factorial : ");
		n = sc.nextInt();
		
		System.out.println("Recursive : "+findFactorial(n));
		System.out.println("Iterative : "+findFactorialIteartive(n));
	}
}