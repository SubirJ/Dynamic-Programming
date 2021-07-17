/*
Space complexity :
Space Complexity is Order of growth of memory(or RAM) space in terms of input size.

Auxiliary Space :
Order of growth of extra space or temporary space in terms of input size.

Auxiliary space is used more that Space complexity because it gives more information

In method arrSum, the Space Complexity is O(n) as it differs as per array size.
If we add one more array of n size, it will still be O(n) Space Complexity.
But as we use only one array space in that, we get Auxiliary Space as : O(1)

Extra Space is space created outside other than input elements, arrSum uses one array for input but no other extra array 
is used.

When we talk about array problems or list problems or any problems which use such input container then we anyways
going to need Theta(n) space , their space complexity going to be atleast Theta(n)

If you use an extra array of size n the space complexity is going to remain Theta(n).
So we  rather use Auxiliary space.

For Example, in sorting algorithms, algorithms like insertion sort, bubble sort, selection sort do not use extra space
for computation so space complexity remains O(n) for all of them.
Some algorithms like merge sort require extra array to perform operation, but in that case also its space complexity
is Theta(n) / O(n).So we don't get a clear picture, if all sorting algorithms are O(n) space. Which one is more efficient?

So we use Auxiliary space for selecting most efficient sorting algorithm.
insertion sort, bubble sort, selection sort, heap sort they require Theta(1) auxiliary space.
While Merge Sort require Theta(n) auxiliary space, so it requires more space as compared to others.
Quick sort is Theta(log n) auxiliary space in best case because Quick Sort has recurrsion.

*/

class SpaceComplexity{
	//Direct formula of calculating sum
	//Only one variable or constant memory / space is used 
	//So, Space Complexity : Theta(1) / O(1)
	public static int getSum1(int n){
		return (n*(n+1)) / 2;
	}
	
	//normal method with loop
	public static int getSum2(int n){
		int sum = 0;
		for(int i=1; i<=n; i++){
			sum = sum + i;
		}
		
		return sum;
	}
	//In the above method 3 variables are used n,sum and i.
	//They remain constant, memory space doesn't vary if n=1000 or n=10000 because i and sum remains constant for any value
	//So, Space Complexity : Theta(1) / O(1) here as well
	//We cannot use Omega value of Space Complexity because it gives lower bound of memory which is not useful
	
	//Sum of array elements
	public static int arrSum(int[] arr, int n){
		int sum = 0;
		for(int i=1; i<=n; i++)
			sum = sum + i;
		
		return sum;
	}
	//In the above method, array and its size n is given
	//If n is 100 then we need a constant space of 100, if 1000 then 1000
	//So space increases as size increases, So, Space Complexity : Theta(n) / O(n)
	
	public static void main(String[] args){
		int n=10;
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(getSum1(n));
		System.out.println(getSum2(n));
		System.out.println(arrSum(arr, arr.length));
	}
}
