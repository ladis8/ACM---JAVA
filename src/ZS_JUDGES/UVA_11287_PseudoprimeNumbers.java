package ZS_JUDGES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_11287_PseudoprimeNumbers {
	
	private static boolean [] erastoten;

	public static void main(String[] args) throws IOException {

		BufferedReader rd = new BufferedReader (new InputStreamReader (System.in));
		String inp;
		
		while (!(inp=rd.readLine()).equals("0 0")){
			
			int p = Integer.parseInt(inp.split(" ") [0]);
			int a = Integer.parseInt(inp.split(" ") [1]);
			
			if ( isPseudoPrime (a,p) && !isPrime (p))
				System.out.println("yes");	
			else 
				System.out.println("no");	
		}
	}
	
	public static boolean isPseudoPrime (int a, int p){
		 return (powerx (a,p,p) == a)? true : false;
			    
	}
	
	private static long powerx (int x, int exponent, int modulo){
		
		
	    if (exponent == 0) //base case
	    	return 1;
	    else if (exponent %2 ==1){
	    	
	    	long p =  (powerx(x, exponent-1, modulo) %modulo);
		    long p1= x%modulo;
	    	return (p * p1) % modulo;
	    }
	    
	    else if (exponent%2==0){
	    	long p = powerx (x, exponent/2, modulo)%modulo;
	    	return (p*p)%modulo;
	    }
		return 0;
	}
	
	public static boolean isPrime (long number){
		
		int i = 2;
		while (i*i <= number){
			if (number % i ==0){
				return false;
			}
			i++;
		}
		return true;
	}	
}
