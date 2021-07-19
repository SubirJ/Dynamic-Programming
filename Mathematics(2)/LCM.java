/*
Finding LCM of two numbers

Input : 4 and 3
Output : 12

Input : 12 and 15 
Output : 60

Input : 2 and 8
Output : 8 (If one number divides another then greatest number is LCM)

Input : 3 and 7
Output : 21 (If two numbers are co prime then LCM is product of the two)
*/
import java.util.*;

class LCM{
	
	//Simple Solution
	//Time Complexity : O(a*b - max(a,b))
	//Space Complexity : O(1)
	public static int findLCMBasic(int x, int y){
		int res = Math.max(x,y);
		
		while(true){
			if((res % x == 0) && (res % y == 0)){
				return res;
			}
			res++;
		}
	}
	
	//function to find gcd
	//Time Complexity : O(log(min(a,b)))
	//Space Complexity : O(1)
	public static int findGCD(int x, int y){
		if(y == 0)
			return x;
		
		return findGCD(y, x%y);
	}
	
	//efficient solution based on the formula
	//For two given numbers a and b, a*b = LCM(a,b) * GCD(a,b)
	public static int findLCM(int x, int y){
		return ((x*y) / findGCD(x,y));
	}
	
	public static void main(String[] args){
		int a=0, b=0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the numbers : ");
		a = sc.nextInt();
		b = sc.nextInt();
		
		System.out.println("LCM(Simple) : "+findLCMBasic(a,b));
		System.out.println("LCM(efficient): "+findLCM(a,b));
	}
}