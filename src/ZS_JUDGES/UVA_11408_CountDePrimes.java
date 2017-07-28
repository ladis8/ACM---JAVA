package ZS_JUDGES;

import java.util.ArrayList;
import java.util.Scanner;

public class UVA_11408_CountDePrimes {
	

	//private static ArrayList <Integer> cinitele;
	private static final int border = 5000000;
	private static boolean erastoten [] = new boolean [border+2];
	private static int sumsofprimefactors [] = new int [border+2];
	private static int dePrime []= new int [border+1];
	private static int countofdePrime [] = new int [border+2];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			String line;
			Scanner sc = new Scanner (System.in);
			int counter=0;
			extendedsieve (border);
			//countdeprime(border);
			countdeprime2 (border);
			
			int i=1;
			while (!((line = sc.nextLine()).equals("0"))){
				String [] digits = line.split(" ");
				int a = Integer.parseInt(digits [0]);
				int b = Integer.parseInt(digits [1]);
				
				
					//System.out.println("I =" +i+" "+ "Input: " + a+ " " + b);
					System.out.println(numofdeprime (a,b));	
					
				
				
				
				//System.out.println(countofdePrime [b]);
				//System.out.println(countofdePrime [a]);
				i++;
				
				/*counter =0; 				
				for (int i = a; i<= b;i++){
					if (UVA_11408_CountDePrimes [i] ==1)						+
						counter++;
				}
					System.out.println(counter);*/
					
				
				/*for (int i = a; i <= b; i++){
					rozklad (i);
					int sum =0;
					for (int cinitel: cinitele){
						sum+=cinitel;
					}
					if (!erastoten [sum]){ //if is not divisebla
						//System.out.print("number: " +i + " ");
						/*for (int j = 0; j < cinitele.size(); j++){
							System.out.print(cinitele.get(j)+ " ");
						}
						System.out.println();
						counter++;
					}*/
						
			}		
	}

private static void countdeprime(int size) {
	ArrayList <Integer> cinitele;	
	
	for (int number = 2; number <= size; number++ ){
		
		if (dePrime [number] ==0){
			cinitele= new ArrayList <Integer>();
			
			int sum = 0;
			cinitele = rozklad (number);
			for (int cinitel : cinitele){
				sum += cinitel;
			}
			int state;
			if (!erastoten [sum]){
				state= 1; //number is UVA_11408_CountDePrimes number
			}
			else {
				state = 2; //number is not UVA_11408_CountDePrimes number
			}
			for (int cinitel:cinitele){
				for (int i=1; number*i <=size; i++){
					dePrime [number] = state;
				}
			}
			
			
		}
			
	}
		
}

private static void countdeprime2(int size) {
	int counter = 0;
	for (int i=2; i <=size+1; i++){
		countofdePrime [i] = counter;
		if (!erastoten [sumsofprimefactors [i]])
			counter++;
		
	}
	
}
private static int numofdeprime (int a, int b){
	
	return countofdePrime [b+1] - countofdePrime [a];
}

public static void extendedsieve( int size){
		
		erastoten [0] = erastoten [1] = true;	
		for (int i = 2; i<= size; i++){
			
			if (!erastoten [i]){ //number is not divseable
				sumsofprimefactors [i] = i;
				
				for (int j = 2; i*j <= size; j++){							
					erastoten [i*j] = true; //number is deviseable
					sumsofprimefactors [j*i] += i;				
				}				
			
			}
			
		}
	
			
			
}
	
public static ArrayList<Integer> rozklad (int n) {
		
		
	    int zbytek = n;
	    ArrayList <Integer> cinitele =  new ArrayList <Integer>();
	    
	    for (int i = 2; i*i <= zbytek; i++) {
	    	
	    	if (zbytek%i ==0){
	    		cinitele.add(i);
	    		while (zbytek % i == 0) {
	 	            zbytek = zbytek / i;
	 	        }
	    	}
	       
	    }
	    if (zbytek > 1) {
	   
	    	cinitele.add(zbytek);
	   }
	    return cinitele;
	    
	}

}
