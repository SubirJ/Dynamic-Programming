/*
BigInteger Factorial

To handle factorials of higher number and avoid integer value overflow
*/

import java.util.*;
import java.math.*;

class BigFactorial{
	
	public static void factorialDigits(int n){
		
		BigInteger f = new BigInteger("1");
		
		for(int i=2; i<=n; i++){
			f = f.multiply(BigInteger.valueOf(i));
		}
		
		System.out.println(f);
	
	}

	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
			
		while(n>0){
			System.out.println("Enter the number : ");
			n = sc.nextInt();
			
			System.out.println("Digits : ");
			factorialDigits(n);
		}
	}	
}