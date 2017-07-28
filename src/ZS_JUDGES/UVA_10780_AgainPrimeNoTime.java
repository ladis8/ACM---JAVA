package ZS_JUDGES;

import java.util.ArrayList;
import java.util.Scanner;

public class UVA_10780_AgainPrimeNoTime {
	private static ArrayList <Integer> cinitele;
	private static ArrayList <Integer> exponenty;
	private static ArrayList <Integer> prvoexponenty;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		int numoftests = sc.nextInt();
		int iterrations=0;
		int m;
		int n;
		
		
		for (int i =0; i < numoftests; i++){
			m = sc.nextInt();
			n= sc.nextInt();
			System.out.println("Case "+(i+1)+":");
			
			if (rozklad(m)){
				//System.out.println("sdss");
				if (m > n){
					
					System.out.println("Impossible to divide");
				}
				else {
					System.out.println(countm(n, m));
				}
			}
			else {
				
				/*for (int delitel : cinitele){
					System.out.println(delitel);
				}
				for (int exponent : exponenty){
					System.out.println(exponent);
				}*/
				
				int min = Integer.MAX_VALUE;
				for (int j=0; j < cinitele.size();j++){
					if (cinitele.get(j) > m){
						System.out.println("Impossible to divide");
					}
					else {
						int exp =countm(n, cinitele.get(j))/exponenty.get(j);
						//System.out.println(cinitele.get(j) + " " +exponenty.get(j) + " "+exp);
						if (exp< min){
							min = exp;
						}
						
					}
					
				}
				if (min ==0){
					System.out.println("Impossible to divide");
				}
				else{
					System.out.println(min);
				}
				
			}
		}

	}

	private static int countm(int n, int m) {
		int counter = 0;
		while (n >= m){
			counter = counter + n/m;
			n= n/m;
		}
		return counter;
		
	}
	
	public static boolean rozklad (int n) {
		
		
	    int zbytek = n;
	    int counter =0;
	    cinitele =  new ArrayList <Integer>();
	    exponenty = new ArrayList <Integer>();
	    
	    for (int i = 2; i <= Math.sqrt(zbytek); i++) {
	    	
	    	if (zbytek%i ==0){
	    		cinitele.add(i);
	    		while (zbytek % i == 0) {
	 	            zbytek = zbytek / i;
	 	            counter++;    
	 	        }
	    		exponenty.add(counter);
	    		//System.out.println(i + " " +counter);
	    		
	    		counter=0;
	    	}
	       
	    }
	    //System.out.println(zbytek);
	    if (zbytek > 1) {
	    	if (zbytek==n){
	    		return true;
	    	}
	    	cinitele.add(zbytek);
    		exponenty.add(1);
	   }
	    return false;
	}
	

}
