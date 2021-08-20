import java.util.*;

class Test{
	
	static boolean checkKthBit(int n, int k)
    {
        // Your code here
        int b = (n & (1 << k));
    
		System.out.println(b);
		
        return true;
    }
	
	public static void main(String[] args){
		int n = 1, k=0;
		
		Scanner sc = new Scanner(System.in);
		
		while(n>0){
			System.out.println("Enter the number : ");
			n = sc.nextInt();
			k = sc.nextInt();
			
			System.out.println(checkKthBit(n,k));
			
		}
	}
}