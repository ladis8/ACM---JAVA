package ZS_JUDGES;

import java.util.ArrayList;
import java.util.Scanner;

public class UVA_11387_The3RegularGraph {
	
	private static ArrayList <Integer>vertexnum ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner (System.in);
		
		vertexnum = new ArrayList<Integer> ();
		int num;
		
		while ((num =Integer.parseInt(sc.nextLine()))!= 0 ){
			
			vertexnum.add(num);			
		}
		
		for (int vertex : vertexnum){
			
			printgraph(vertex);
			
		}

	}

	private static void printgraph(int vertex) {
		
		if (vertex < 4 || vertex %2 ==1){
			System.out.println("Impossible");
		}
		else {
			
			int numofedges = 3* vertex/2;
			System.out.println(numofedges);
			
			int step = vertex/2;
			for (int i = 1; i <= vertex; i++){
				
			///prvn� hrana	
				if (i != vertex){
					System.out.println(i + " " + (i+1));
				}
				else {
					System.out.println(i + " " + 1);
				}
				
				
				//druh� hrana
				if (i*2 <= vertex){			
					System.out.println(i + " " + (i+step) );
				}
		
				
			}
			
			
			
			
		}
		
	}

}
