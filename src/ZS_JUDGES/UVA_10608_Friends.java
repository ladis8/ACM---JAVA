package ZS_JUDGES;

import java.util.ArrayList;
import java.util.Scanner;

public class UVA_10608_Friends {
	
	private static int [] [] graph;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		
		int numoftestcases =Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < numoftestcases; i++){
			String [] input =sc.nextLine().split(" ");
			int vertex = Integer.parseInt(input [0]);
			int relations = Integer.parseInt(input [1]);
			
			graph = new int[vertex] [vertex];
					
			for (int x =0; x < relations; x++){
				
				input = sc.nextLine().split(" ");			
				addandchangeneighbours(Integer.parseInt(input[0]), Integer.parseInt(input [1]));
				
			}
			
			System.out.println(getTheBiggest());
			//printGraph();
			
		}
		
		
		

	}

	private static int getTheBiggest() {
		// TODO Auto-generated method stub
		int maximum =0; 
		int current =0;
		for (int [] graphrow : graph){
			
			for (int edge : graphrow){
				if (edge==1){
					current++;
				}
			}
			
			if (current > maximum){
				maximum = current;
			}
			current =0;
				
			
				
		}
		return maximum;
		
	}

	private static void addandchangeneighbours(int parseInt, int parseInt2) {
		int ver1 = parseInt -1;
		int ver2 = parseInt2 -1;
		graph [ver1] [ver1] =1;
		graph [ver2] [ver2] =1;
		
		ArrayList <Integer> n = new ArrayList();
		n.add(ver1);
		ArrayList <Integer> n2 = new ArrayList();
		n2.add(ver2);
		
		
		
		for (int i = 0; i < graph.length; i++){
			if (graph [ver1][i] == 1){			
				//graph [ver2][i]= 1;
				//graph [i][ver2]= 1;
				n.add(i);
			}
		}
		
		for (int i = 0; i < graph.length; i++){
			if (graph [ver2][i] == 1){			
				//graph [ver1][i]= 1;
				//graph [i][ver1]= 1;
				n2.add(i);
			}
		}
		
		for (int vertex: n){
			for (int neigh : n2){
				graph [vertex][neigh]=1;
				graph [neigh][vertex]=1;
				
			}
		}
		
		//graph [ver1][ver2] =1;
		//graph [ver2][ver1] =1;
		
		
		
	}
	private static void printGraph(){
		for (int i =0; i< graph.length;i++){
			for (int j =0; j< graph.length;j++){
				System.out.print(graph [i][j] + " ");
				
			}
			System.out.println();
		}
	}

}
