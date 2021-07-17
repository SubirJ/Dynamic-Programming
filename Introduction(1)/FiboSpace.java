/*
Space complexity and Auxiliary space for different functions of fibonaaci series

0 1 1 2 3 5 8 13
*/ 

class FiboSpace{
	//Method 1
	public static int fib(int n){
		if(n == 0 || n==1)
			return n;
			
		return fib(n-1) + fib(n-2);
	}
	
	//Method 2
	public static int fib1(int n){
		int[] arr = new int[n+1];
		
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2; i <= n; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];
	}	
	
	//Method 3
	public static int fib2(int n){
		if(n == 0 || n == 1)
			return n;
			
		int a = 0, b = 1, c = 0;
		
		for(int i = 2; i <= n; i++){
			c = a+b;
			a = b;
			b = c;
		}
		
		return c;
	}
	
	public static void main(String[] args){
		int x = 7;
		
		System.out.println(fib(x));
		System.out.println(fib1(x));
		System.out.println(fib2(x));
	}
}

/*
Auxiliary space(extra space) of Method 1 (fib): 
Major hint for Auxiliary Space of any recurrsion is, Auxiliary Space of any recurrsion tree is the height of the tree,
maximum length of root to leaf part. And that's what Auxiliary Space and Space Complexity for Recurrsion tree are.

For Ex: For n=4, we get tree for above code as

												fib(4)
 											 /          \
									    fib(3)           fib(2)
									   /      \         /	   \
								  fib(2)      fib(1) fib(1)    fib(0)
								 /      \		
	                         fib(1)     fib(0)

So the maximum length of above tree is 4 which is from fib(4) to fib(1) which is the left most branch.

So at a time maximum 4 function calls will be present at a time.

1> Call stack initially will be , fib(4) will be called which will first call fib(3) which will then call fib(2) and then 
   fib(1) which will return 1, so the call stack will be
											fib(1)
											  |
											fib(2)
											  |
											fib(3)
											  |
											fib(4)
											
	In the above call stack, fib(1) will get resolved and return 1, which will remove fib(1) form call stack
	but fib(2) won't get resolved because after resolving fib(1) it will call fib(0) so fib(0) will get added to call stack.
	so now call stack will be as,
											fib(0)
											  |
											fib(2)
											  |
											fib(3)
											  |
											fib(4)
											
    fib(0) will get resolved by returning 0 which in turn will resolve fib(2) as both its child are resolved,
	fin(2) will return 1 to fib(3) ie its parent. But it won't resolve fib(3) as it will now call fib(1)
	So call stack will be,
											fib(1)
											  |
											fib(3)
											  |
											fib(4)
	
	fib(1) will return 1 which will reolve fib 3, fib(3) will return 1+1=2 to its parent fib(4).
	Now fib 4 will call the another branch starting with fib(2) and so on.
	
	The thing to note here is, once you call a recurrsive function , it will go to leaf node first and start resolving calls
	from there, and won't make another calls unless the current call stack is resolved. That is why at any given point,
	The auxiliary space or space complexity of a recurrsive function is the maximum length of the root from the leaf.

	Auxiliary space of above function or code is order of 4, fib(4)->fib(3)->fib(2)->fib(1)
	So we can say Auxiliary Space required for this method at any given point will be O(n).
	
Auxiliary space(extra space) of Method 2 (fib1):
	Auxiliary space and Space Complexity for this method is going to be O(n) as we are using an array of n+1 length.
	
Auxiliary space(extra space) of Method 3 (fib2) :
For this method we use only constant space of variables like a,b,c,i which are not dependent on n.
The space remains constant for any value of n. So Auxiliary Space and Space Complexity of this method is O(1) / Theta(1)
 */