package THEORY.DAG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackpackProblem {

	public static void main(String[] args) throws IOException {
		
		BufferedReader rd = new BufferedReader (new InputStreamReader (System.in));
		String [] line = rd.readLine().split(" ");
		int maxweight = Integer.parseInt(line[0]);
		int numofthings = Integer.parseInt(line[1]);
		int [] weights = new int [numofthings];
		int [] prices = new int [numofthings];
		
		for (int i=0; i < numofthings; i++){
			line = rd.readLine().split(" ");
			weights[i] = Integer.parseInt(line[0]);
			prices [i] = Integer.parseInt (line[1]);
			
		}
		rd.close();
		
		int [] [] dag = new int [numofthings+1][maxweight +1];	
		
		//arrayinicialization
		for (int i =0; i< dag.length;i++){
			for (int j =0; j< dag [0].length;j++){
				dag [i][j] = -1;
			}
		}
		dag [0][0]=0;
		int maximum = 0;
		for (int i =0; i< numofthings;i++){
			
			for (int j =0; j< maxweight;j++){
				if (dag [i][j] != -1){
					
					//neprida predmet
					if (dag [i+1] [j] < dag [i][j]){
						dag [i+1][j] = dag [i][j];
					}		
					//prida predmet 
					int addweight =j +weights[i];
					int addprice = dag [i] [j] + prices [i];
					//System.out.println(addedweight);
					if (addweight <= maxweight && dag [i+1] [addweight] < addprice)
					{
							dag [i+1][addweight] = addprice;
							maximum = Math.max(maximum, addprice);
					}
				}
					
			}
			//printArray(dag);
		}
		System.out.println(maximum);
	}
	
	private static void printArray (int [][] dag){
		
		for (int i =0; i< dag.length;i++){
			for (int j =0; j< dag [0].length;j++){
				if (dag [i][j] == -1)
					System.out.print('.');
				else 
				System.out.print(dag [i][j]);
			}
			System.out.println();
		}
	}

}
