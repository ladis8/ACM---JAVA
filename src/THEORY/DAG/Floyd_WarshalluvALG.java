package THEORY.DAG;

import java.io.BufferedReader;
import java.io.FileReader;

public class Floyd_WarshalluvALG {
	
	private static void printGraph(int [][] graph){
		System.out.println();
		for (int i =0; i< graph.length;i++){
			for (int j =0; j< graph.length;j++){
				if (graph [i][j] == Integer.MAX_VALUE)
					System.out.print(". ");
				
				else
				System.out.print(graph [i][j] + " ");
				
			}
			System.out.println();
		}
	}
	
	private static int [][] readGraph (String path, boolean oriented){
			
		int [][] shortestpaths = null;
		try {
				BufferedReader rd = new BufferedReader (new FileReader (path));
				
			
				String line = rd.readLine();
	            int uzelnum = Integer.parseInt(line.split(" ") [0]);
	            shortestpaths = new int [uzelnum][uzelnum];
	            	for (int i=0; i < uzelnum;  i++){
	            		for (int j=0; j< uzelnum; j++){
		            		if (j != i){
		            			shortestpaths [i][j] =Integer.MAX_VALUE;
		            		}
	            		
	            	}
	            	 
	            }

	                while ((line = rd.readLine()) != null){
		            	int xcor = Integer.parseInt(line.split(" ") [0]);
		                int ycor = Integer.parseInt(line.split(" ") [1]);		               
		               
		               
		                	if (!(oriented))
		                		shortestpaths [ycor] [xcor] = Integer.parseInt(line.split(" ") [2]);     
			                			                				                	
		                	shortestpaths [xcor] [ycor] = Integer.parseInt(line.split(" ") [2]);
		                	
	                }  	
	                
	              
	
			}
	       catch (Exception e) {
	      	        e.printStackTrace();
	      	        }
		
		  return shortestpaths;
	 } 
	
	private static int [][] calculatePaths (int [][] graph){
		
		int size =graph.length;
		int [][] currentshortestpaths = graph;
		int [][] predessors = new int [size][size];
		
		//make array of predessors
		for (int i =0; i< size; i++){
			for (int j=0; j < size; j++){
				
				if (graph [i][j] != Integer.MAX_VALUE && graph [i][j] != 0){
					//zapise predchudce, radek, z ktereho se do uzlu dostal
					predessors [i][j] = i;
				}
				else {
					predessors [i][j]= -1;
				}
			}
			
		}
		
		printGraph (predessors);

	
		
		//prostrednik
		printGraph (currentshortestpaths);
		for (int k= 0; k < size; k++){
			
			//iterace pres matici
			for (int x=0; x < size; x++){			
				for (int y=0; y < size; y++){
					
					//FILTRACE CEST, KTER� NIKDY NEBUDOU KRAT�� (CESTY, KTER� JSOU ZAT�M NEKONE�NO, NEBO 0)
					if (currentshortestpaths[x][y] ==0 ||currentshortestpaths[x][k]==Integer.MAX_VALUE ||currentshortestpaths[k][y]==Integer.MAX_VALUE ){
						continue;
					}
					
					//HERE IS THE MAGIC HAPPEN
					//HLED�N� NEJKRAT�� CESTY MEZI UZLY X A Z p�es K
					//pokud je cesta z X p�es K do Y KRAT�� NE� SOU�ASN� CESTA (NEBO POKUD JE�T� CESTA NEN� DEFINOV�NA)
					//---> ZAP͊E CESTU
					//p�ep�e p�edch�dce nejkrat�� cest
					if (currentshortestpaths[x][y] > currentshortestpaths[x][k] + currentshortestpaths[k][y]) {						
						currentshortestpaths[x][y] = currentshortestpaths[x][k] + currentshortestpaths[k][y];
						predessors [x] [y] = predessors [k] [y];
					}
				}
			}
			printGraph (currentshortestpaths);
			printGraph (predessors);
			
		}
		
		
		
		return predessors;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int [][] predessors = calculatePaths(readGraph ("floyd.txt", true));
		System.out.println("SORTEST PATH ");
		getPath (predessors, 1,4 );
		

	}
	
	private static int getPath (int [][] p, int start, int goal){
		
		if (start ==goal){
			System.out.println(start);
		}
		
		else if (p [start][goal ] == -1 ){
			System.out.println ("Cesta neexistuje");
		}
		else {
			System.out.println(goal);
			return getPath (p, start, p [start][goal]);
		}
		
		return goal;
		
	}

}
