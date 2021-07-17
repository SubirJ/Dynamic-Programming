/*
Find the count of trailing zeros in a factorial

Input : 5
Ouput : 1 (120 has 1 trailing zero)

Input : 10
Ouptut : 2

Input : 100
Ouptut : 24
*/

import java.util.*;

class TrailingZeros{
	
	//Simple Solution
	//Time Complexity : Theta(n) / O(n)
	//Auxiliary space  / Space Complexity : Theta(1) / O(1)
	//Drawback : As we are finding factorials, For higher numbers like 20,30 or 100 , soln will cause an overflow,
	//			 data type may not be able to handle such greater numbers
	public static long zeroCount(int n){
		long fact = 1;
		int	zero_cnt = 0;
		
		for(int i=2; i<=n; i++){
			fact = fact * i;
		}
			
		while(fact % 10  == 0){
			zero_cnt++;
			fact = fact / 10;
		}
		
		return zero_cnt;
	}
	
	//efficient Solution
	//10 = 2*5, so we can see how 2s and 5s we have in prime factorization of given factorial
	//We can notice that number 5s are always going to be less that number of 2s in a prime factorization
	//So we can only calculate number of 5s present in prime factorization which will give us number of zeros
	//General formaula = no. of trailing zeros = floor(n/5) + floor(n/25) + floor(n/125) + ........
	//This gives us the number of 5s present in prime factorization
	//Time Complexity : Theta(log(n)) / O(log(n))
	//Auxiliary space  / Space Complexity : Theta(1) / O(1)
	public static int efficientZeroCount(int n){
		int zero_cnt = 0;
		
		for(int i = 5; i <= n; i=i*5){
			zero_cnt = zero_cnt + (n/i);
		}
		 
		return zero_cnt;
	}
	
	public static void main(String[] args){
		int n = 0; 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number to find trailing zeros : ");
		n = sc.nextInt();
		
		System.out.println("Efficient Solution : "+efficientZeroCount(n));
		System.out.println("Simple Solution Result : "+zeroCount(n));
	}
}
