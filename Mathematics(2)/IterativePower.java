/*
Iterative Power : Binary Exponentiation
This program will help us find solution of number to a power

Input : x=2 and n=3, n>=0
O/p : 8

Input : x=3 and n=4
O/p : 81

Input : x=5 and n=0
O/p : 1

Input : x=5 and n=1
O/p : 5

Similar to Power.java program, but here we will require Space Complexity of only O(1) instead of O(log n)

Concept is : 
1) Every number can be written as sum of power of 2 (Set bits in binary representation)
Ex : 3^10 = 3^8 * 3^2        => 10 = 1010
	 3^19 = 3^16 * 3^2 + 3^1 => 19 = 10011
	 
2) We can traverse through all the bits of a number(LSB to MSB) in O(log(n)) times
Ex : for 4^5 :
	binary of 5  = 0101
	So we will multiply 4 as follows = 	0   1   0   1   =  4^4 * 4^1 = 1024
									   4^8 4^4 4^2 4^1
									   
	for 3^4
	binary of 4 =  0   1   0   0  = 3^4 = 81 
				  3^8 3^4 3^2 3^1
*/
import java.util.*;

class IterativePower{
	
	//Efficient solution
	//Time Complexity : O(log n)
	//Auxiliary Space : O(1)
	//We can use long instead of int to avoid overflow
	//Also we can use modulo for the answer and storing of numbers to avoid integer overflow and handle large numbers
	public static long findPower(long x, long n){
		long res = 1;
		while(x > 0){
			if(n%2 != 0)
				res = res * x;
			x = x*x;
			n = n/2;
		}
		
		return res;
	}

	public static void main(String[] args){
		long x=1,n=1;
		
		Scanner sc = new Scanner(System.in);
		
		while(x > 0){
			
			System.out.println("Enter the number to find the power of : ");
			x = sc.nextInt();
			
			System.out.println("Enter the Power : ");
			n = sc.nextInt();
			
			System.out.println("Result : "+findPower(x,n));
		}
	}
}