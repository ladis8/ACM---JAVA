package ZS_JUDGES;
//import java.io.BufferedReader;
//TASK NO. 11040 ANOTHER BRICK IN THE WALL

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UVA_11040_Addbricksinthewall {

	//private static int [] array;
	//private static BufferedReader rd;
	private static Scanner sc;
	private static final int numrows = 5;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
	
		//na�ti vrcholy		
		sc = new Scanner (System.in);	
		int loops = Integer.parseInt(sc.nextLine());
		
		//na�te prvn� vrchol
		int [] vrcholy = {Integer.parseInt(sc.nextLine())};
		System.out.println (vrcholy [0]);
		
			
		for (int i=0 ; i < loops; i ++){
		
			for (int j =0; j< numrows-1; j++){
				
				vrcholy = doPyramide (vrcholy);
			}
			vrcholy = new int [1];
			
			if (i != loops-1)
			//vrcholy [0] = Integer.parseInt(rd.readLine());
			vrcholy [0] = Integer.parseInt(sc.nextLine());
				
		}

	}
	
	private static int [] doPyramide (int [] vrcholy) throws IOException{
		
			int [] zakladny= type(sc.nextLine().split(" "));
			ArrayList <Integer> druharadka = new ArrayList<Integer>();		
			druharadka.add(zakladny[0]);
			
			for (int i =0; i < vrcholy.length; i++){
				
				int [] xyz = new int [3];
				xyz [0] = vrcholy [i];
				xyz [1] = zakladny [i];			
				xyz [2] = zakladny [i +1];	
				int [] output = count  (xyz);				
				druharadka.add(output [0]);
				druharadka.add(xyz[2]);
				
				System.out.print(output [1] + " "  + output [2] + " ");
						
			}
	
			//printing base
			System.out.println();
			for (int num : druharadka){
				System.out.print(num + " ");		
			}
			
			System.out.println();
			
			return zakladny;

		
	}
	
	private static int [] type (String [] numbers){
		
		int [] nums = new int [numbers.length];
		for (int i =0; i < numbers.length;i++){
			nums [i] = Integer.parseInt(numbers [i]);
		}
		return nums;
		
	}
	
	private static int[] count (int [] xyz){
		
		int a,b,c;
		int [] output = new int [3];
		
		c = (xyz [0]- xyz [1] - xyz [2])/2;
		a = xyz [1] + c;
		b = xyz [2] + c;
		
		output[0]= c;
		output[1]= a;
		output[2]= b;
		
		
		/*array [pointers[0] * 2] = a;
		array [pointers[0] * 2 +1] = b;
		array [pointers[1] /2] = c;*/
		
	
		return output;
		
	}
	



}
