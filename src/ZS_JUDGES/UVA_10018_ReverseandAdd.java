package ZS_JUDGES;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
public class UVA_10018_ReverseandAdd {

	private static long palindrom =0;
	

	public static void main(String[] args) {
		// PALINDROME REVERSE AND ADD

		Scanner sc = new Scanner (System.in);
		int numoftests = sc.nextInt();
		int iterrations=0;
		
		
		for (int i =0; i < numoftests; i++){
			
			palindrom = sc.nextLong();
			
			int palarray [] = new int [100]; 			
			long number = palindrom;
			ArrayList <Integer> list = new ArrayList ();
			while (number != 0)
			{    		
				int last_digit = (int) number % 10;
				list.add(last_digit);		           
			    number = number / 10; 
			}
			
			//add and reverse for first time		
			long reverse = reverse (palindrom);
			palindrom = palindrom + reverse;			
			//BigInteger palindromB = new BigInteger (Long.toString(reverse (palindrom)+palindrom));
			iterrations++;
		
			while (true){
				
				
				if ((reverse = reverse (palindrom)) ==palindrom){
					break;
				}
				else{					
					palindrom = palindrom + reverse;
					iterrations++;
					//System.out.println(palindrom + " "+iterrations);
				}
				
			}
			
			System.out.println(iterrations + " " + palindrom);
			palindrom =0;
			iterrations=0;
	
		}
		
		sc.close();
		
			
		}
		
	private static long reverse (long number){
		
		
		long reverse =0;
		BigInteger reverseB = new BigInteger("0");
		
		
		while (number != 0)
		{    		
			int last_digit = (int) number % 10;
		       
		     reverse = (reverse +last_digit) *10;
		    
		     
		     number = number / 10; 
		}
		reverse = reverse/10;
		
		//System.out.println(reverse);
		return  reverse;
	}




}
