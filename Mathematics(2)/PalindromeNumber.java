/*
Check whether a number is plaindrome or not

Input : 78987
Output : True

Input : 356
Output : False

Time complexity of this program is O(d) / Theta(d) where d is thed number of digits in the number
*/

import java.util.*;

class PalindromeNumber{
	
	public static boolean palindromeOrNot(int n){
		int result = 0;
		int temp = n;
		
		while(n > 0){
			result = result * 10 + (n % 10);
			n = n / 10;
		}
		
		return (result == temp);
	}
	
	public static void main(String[] args){
		int n = 78987;
		
		System.out.println(palindromeOrNot(n));
	}
}