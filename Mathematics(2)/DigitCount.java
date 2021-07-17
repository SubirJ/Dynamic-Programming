/*
Finding count of digits in a number

Ex :
1> for n = 123 output = 3
2> for n = 58763 output = 5
*/
import java.util.*;

class DigitCount{
	
	//iterative Method
	//TC : O(n)
	public static int countDigit(int n){
		int cnt = 0;
		
		while(n > 0){
			n = n / 10;
			++cnt;
		}
		
		return cnt;
	}
	
	//Recurrsive Method
	//TC : O(n)
	public static int countDigitRecurrsive(int n){
		if(n == 0)
			return 0;
			
		return 1 + countDigitRecurrsive(n/10);
	}
	
	//Logarithmic Solution
	//TC : O(1), single line solution
	public static int countDigitLog(int n){
		return (int)Math.floor(Math.log10(n) + 1);
	}
	
	public static void main(String[] args){
		
		System.out.println(countDigit(58763));
		System.out.println(countDigitRecurrsive(58763));
		System.out.println(countDigitLog(58763));
	}
}