package ZS_JUDGES;

import java.util.Scanner;

public class UVA_138_StreetNumbers {
	
	private static boolean [] [] array;
	private static int counter =0;
	
	public static void main(String[] args){
		
		
		Scanner sc = new Scanner (System.in);
		String line;
			
		//get the single number = number of vertex
		while (true){
			line = sc.nextLine();
			int x = Integer.parseInt(line.split(" ") [0]);
			if (x ==0){
				break;
			}
			
			int y = Integer.parseInt(line.split(" ") [1]);
			counter =0;
			array = new boolean [x+2][y+2];
			
			for (int i =0; i < x; i ++){
				line = sc.nextLine();
				for (int j =0; j < y; j++){
					
					if (line.charAt(j) == '*')
						array [i+1][j+1] =false;
					else
						array [i+1][j+1] =true;
				}
								
			}
			//printarray(array);
			
			for (int i =0; i< array.length;i++){
				for (int j =0; j< array [i].length;j++){
					
					if (array [i][j]){
						search(i, j);
						counter++;	
					}
					
				}
				
				
			}
			System.out.println(counter);
			
			//printarray(array);
	
		}
		sc.close();
		
		
	}

	private static void search(int i, int j) {
		
		
		array [i][j]=false;
		
		if (array[i-1][j-1]){
			array [i-1][j-1]=false;
			search(i-1, j-1);
		}
		if (array[i-1][j]){
			array [i-1][j]=false;
			search(i-1, j);
		}
		if (array[i-1][j+1]){
			array [i-1][j+1]=false;
			search(i-1, j+1);
		}
		if (array[i][j-1]){
			array [i][j-1]=false;
			search(i, j-1);
		}
		if (array[i][j+1]){
			array [i][j+1]=false;
			search(i, j+1);
		}
		if (array[i+1][j-1]){
			array [i+1][j-1]=false;
			search(i+1, j-1);
		}
		if (array[i+1][j]){
			array [i+1][j]=false;
			search(i+1, j);
		}
		if (array[i+1][j+1]){
			array [i+1][j+1]=false;
			search(i+1, j+1);
		}

		
	}

	private static void printarray(boolean[][] array) {
		// TODO Auto-generated method stub
		
		System.out.println("GRAPH: ");
		for (int i =0; i< array.length;i++){
			
			for (int j =0; j< array [i].length;j++){
				System.out.print(array [i][j] + " ");
				
			}
			System.out.println();
			
		}
		
	}

}
