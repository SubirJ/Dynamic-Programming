/*
Analysis of Multiple loops

Finding time complexity when there are multiple loops
*/

import java.util.*;

class MultipleLoops{
	
	//Loop 1 : Subsequent Loops
	public static void func1(int n){
		for(int i=0; i<n; i++){
			System.out.print(i+" ");
		}
		//The above loop will run n times so TC : Theta(n) / O(n)
		
		System.out.println("\n");
		for(int i=1; i<n; i=i*2){
			System.out.print(i+" ");
		}
		//The above loop runs log n times so TC : Theta(log n) / O(log n)
		
		System.out.println("\n");
		for(int i=0; i<100; i++){
			System.out.print("*");
		}
		//This loop runs for constant time so TC : Theta(1) / O(1)		
		
		//So total TC of this function will be : O(n) + O(log n) + O(1) = O(n) after removing lower order terms
	}
	
	//Loop 2 : Nested Loops
	public static void func2(int n){
		System.out.println("\n");
		for(int i = 0; i < n; i++){
			System.out.println("\n");
			for(int j=1; j < n; j = j*2){
				System.out.print(" i : "+i+" j: " +j);
			}
		}
		//The loop with "i" runs for Theta(n) / O(n) TC and inner loop with "j" runs for Theta(log n) / O(log n) TC
		// So as it is nested for each n iterations of outer loop, inner loop runs n times as well
		// So time complexity here is : O(n log n) / Theta(n log n)
	}
	
	//Loop 3 : Mixed Loops
	public static void func3(int n){
		
		//first part
		System.out.print("\n");
		for(int i=0; i < n; i++){
			System.out.println("\n");
			for(int j=1; j < n; j = j*2){
				System.out.print(" i : "+i+" j: " +j);
			}
		}
		
		//second part
		System.out.print("\n\n");
		for(int i=0; i < n ; i++){
			for(int j=0; j<n; j++){
				System.out.print("*");
			}
		}
		//We already know the TC of first part is O/Theta(nlog n)
		//For second part, "i" loop runs for n times and "j" loop also runs for n times.
		//Also "j" loop runs for each iteration of i so it TC is : O(n^2)
		//So we get total TC of this function as : O(n log n) + O(n^2) = O/Theta(n^2) after removing lowest order term O(n log n)
	}
	
	//Loop 4 : Different Input
	public static void func4(int n){
		int m = 4;
		
		//first part
		System.out.print("\n");
		for(int i=0; i < n; i++){
			System.out.println("\n");
			for(int j=1; j < n; j = j*2){
				System.out.print(" i : "+i+" j: " +j);
			}
		}
		
		//second part
		System.out.print("\n\n");
		for(int i=0; i < m ; i++){
			for(int j=0; j<m; j++){
				System.out.print("*");
			}
		}
		//Again we know TC of first part = O(n log n)
		//Second part is based on another variable which is m.
		//So as these two parts are based on different variables we cannot discard lower term O(n log n)
		//So  TC here will be : O/Theta(n log n + m^2), as TC of second part is O(m^2)
	}
	
	public static void main(String[] args){
		int n = 10;
		
		func1(n);
		func2(n);
		func3(n);
	}
}