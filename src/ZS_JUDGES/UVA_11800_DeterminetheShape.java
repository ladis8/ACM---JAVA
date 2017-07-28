package ZS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_11800_DeterminetheShape {
	
	private static int [] u,v,w,t,x,y;
	private static int counter;

	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st;
		int numoftestcases = Integer.parseInt(rd.readLine());
		
		int [] [] points = new int [4][2]; 
		String inp [];
	
		
		for (counter = 1; counter <= numoftestcases; counter++){
			for (int j=0; j < 4; j++){
				st = new StringTokenizer (rd.readLine());
				
				points [j] [0] = Integer.parseInt(st.nextToken());
				points [j] [1] = Integer.parseInt(st.nextToken());
			}
			gettheshape(points);
			
		}
		rd.close();
		
		

	}
	
	
	private static void gettheshape(int [] [] points) {
		// TODO Auto-generated method stub
		
			int colinearcounter = 0;	
			boolean col1 =false, col2 =false, col3=false;
			
				u = getVector (points [0], points [1]); //vector 01
				v = getVector (points [2], points [3]); //vector 23
				if (collinearity (u,v)){
					colinearcounter++;
					col1= true;
				}				
				w = getVector (points [1], points [2]);
				t = getVector (points [0], points [3]);
				if (collinearity (w,t)){
					colinearcounter++;
					col2= true;
				}	
				x = getVector (points [0], points [2]);
				y = getVector (points [1], points [3]);
				if (collinearity (x,y)){
					colinearcounter++;
					col3= true;
				}
				
				
				
				
				if (colinearcounter == 2){
					if (col1&&col2){
						if (getDistanceSquare (u)== getDistanceSquare (w)){
							if (scalarproduct (u, w)==0)
								System.out.println("Case "+ counter+ ": Square");
							else 
								System.out.println("Case "+ counter+ ": Rhombus");
						}
						else {
							if (scalarproduct (u,w)==0)
								System.out.println("Case "+ counter+ ": Rectangle");
							else 
								System.out.println("Case "+ counter+ ": Parallelogram");
						}
						
						
					}
					else if (col2&&col3){
						if (getDistanceSquare (w) == getDistanceSquare (x)){
							if (scalarproduct (w,x)==0)
								System.out.println("Case "+ counter+ ": Square");
							else 
								System.out.println("Case "+ counter+ ": Rhombus");
						}
						else {
							if (scalarproduct (w,x)==0)
								System.out.println("Case "+ counter+ ": Rectangle");
							else 
								System.out.println("Case "+ counter+ ": Parallelogram");						}
				
					}
					else if (col1&& col3){
						if (getDistanceSquare (u) == getDistanceSquare (x)){
							
							if (scalarproduct (u, x)==0)
								System.out.println("Case "+ counter+ ": Square");
							else 
								System.out.println("Case "+ counter+ ": Rhombus");
						}
						else {
							if (scalarproduct (u,x)==0)
								System.out.println("Case "+ counter+ ": Rectangle");
							else 
								System.out.println("Case "+ counter+ ": Parallelogram");						}
					}
					
				}
				else if (colinearcounter ==1){
					System.out.println("Case "+ counter+ ": Trapezium");
					
				}
				else {
					System.out.println("Case "+ counter+ ": Ordinary Quadrilateral");
					
				}
			
		
	}



	private static int [] getVector (int [] A, int [] B){
		//returns the vector AB = B-A
		return new int [] {B[0] - A[0], B[1] - A[1]};
	}
	
	private static int getDistanceSquare (int [] u){
		return u [0] * u [0] + u [1] * u[1];		
	}
	
	private static int scalarproduct (int [] u, int [] v){
		return u[0] * v [0] + u [1] * v [1];
	}
	
	private static boolean collinearity (int [] u, int [] v){
		if (u[0] * v [1] - u[1] * v [0] == 0)
			return true;
		else return false;
	}
	

}
