/*
Find all Prime Numbers las than given number

Input : 10
O/p : 2,3,5,7

Input : 23
O/p : 2,3,5,7,11,13,17,19,23
*/ 

import java.util.*;

class PrintPrimes{

	//function to check if prime or not
	//Time Complexity  :O(Sqrt(n))
	public static boolean isPrime(int a){
		if(a == 1)
			return false;
		if(a == 2 || a == 3)
			return true;
		if(a % 2 == 0 || a % 3 == 0)
			return false;
			
		for(int i = 5; i*i <= a; i=i+6){
			if(a % i == 0 || a % (i+2) == 0)
				return false;
		}
		
		return true;
	}
	
	//Simple Solution 
	//Time Complexity : O(n*Sqrt(n)) , Sqrt(n) of above function
	public static void findPrimes(int x){
		for(int i=2; i <= x; i++){
			if(isPrime(i))
				System.out.println(i);
		}
	}
	
	//Efficient Solution with Sieve of Eratosthenes method
	//We will mark the basic prime number factors like 2,3,5 as not prime, to a given number
	//If number is 10 then we will mark 4,6,8,9,10 as not prime as they are multiples of 2 and 3 and same will go for 5
	//This will help us eliminate a big chunk of numbers to check from
	public static void efficientFindPrime(int x){
		
		//initialize a boolean array of numbers given to the range ie x and mark them all true initially
		//then as we notice that they are multiples of basic numbers we will mark them false and print numbers which are true
		Boolean[] isPrime = new Boolean[x+1];
		
		Arrays.fill(isPrime, Boolean.TRUE);
		
		for(int i = 2; i*i <= x; i++){ //we give i*i<=x condition as smaller factors of a number are always less than Sqrt(number)
			if(isPrime(i)){
				for(int j = i*i; j <= x; j=j+i){ //Here we will mark the multiple of numbers as not prime
					isPrime[j] = false;
				}
			}
		}
		
		for(int i=2; i<=x; i++){
			if(isPrime[i])
				System.out.println(i);
		}
	}
	
	//We can make the above code more efficient
	//Time complexity : O(n loglog(n)) which is better than O(n*Sqrt(n))
	//Space Complexity : O(n)
	public static void printPrimes(int x){
		
		Boolean[] isPrime = new Boolean[x+1];
		Arrays.fill(isPrime, Boolean.TRUE);
		
		for(int i = 2; i <= x; i++){
			if(isPrime[i]){
				System.out.println(i);
				for(int j=i*i; j <= x; j=j+i){
					isPrime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the number to find primes less than that: ");
			n = sc.nextInt();
			
			System.out.println("Prime Factors(Simple Solution) : ");
			findPrimes(n);
			
			System.out.println("Prime Factors(Efficient Solution) : ");
			efficientFindPrime(n);
			
			System.out.println("Prime Factors (More Efficient) : ");
			printPrimes(n);
		}
	}
}