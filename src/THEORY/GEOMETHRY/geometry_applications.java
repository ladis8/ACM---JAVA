package THEORY.GEOMETHRY;

public class geometry_applications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2,1};
		int [] B = {5,6};
		int [] C = {2,7};
		int [] AB = getVector (A,B);
		int [] AC = getVector (A,C);
		System.out.println(scalarproduct (AB,AC));
		System.out.println(AB[0] + " " + AB [1]);
		System.out.println(getDistance (getVector(new int []{0,2}, new int [] {5,3})));
		System.out.println(scalarproduct (new int [] {2,3}, new int [] {6,1}));
		int [] line = lineequation (new int [] {1,4}, new int [] {6,2}); 
		System.out.println(line [0]+"x + "+line [1] +"y+ "+line [2]);
		System.out.println(distancepointoline (line, new int []{6,6}));
		System.out.println(angle (new int [] {4,4}, new int [] {1,5}));
	}
	
	
	private static int [] getVector (int [] A, int [] B){
		//returns the vector AB = B-A
		return new int [] {B[0] - A[0], B[1] - A[1]};
	}
	private static int [] getNormalVector (int [] A, int [] B){
		return new int [] {A[1] - B[1], B[0] -A[0]}; 
	}
	private static int getDistanceSquare (int [] u){
		return u [0] * u [0] + u [1] * u[1];		
	}
	private static double getDistance (int [] u){
		return Math.sqrt (Math.pow(u[0],2) + Math.pow(u[1],2));		
	}
	
	private static int scalarproduct (int [] u, int [] v){
		return u[0] * v [0] + u [1] * v [1];
	}
	
	private static boolean collinearity (int [] u, int [] v){
		if (u[0] * v [1] - u[1] * v [0] == 0)
			return true;
		else return false;
	}
	private static boolean perpendicularity (int []u, int [] v){
		if (scalarproduct (u,v) == 0){
			return true;
		}
		else return false;
	}
	private static int areaoftriangle (int [] u, int [] v){
		//vektorovy soucin/2
		return Math.abs(u[0] * v [1] - u[1] * v [0])/2;
	}
	
	private static int [] lineequation (int [] A, int [] B){
		int a = A [1] - B [1];
		int b = B[0] - A [0];
		int c = -1* (a * A[0] + b *A[1]);
		return new int [] {a,b,c};
	}
	private static double distancepointoline (int [] line, int [] P){
		return Math.abs(line [0] * P[0]+ line [1] * P [1] + line [2])/getDistance (new int [] {line [0], line [1]});
	}
	
	private static double angle (int [] u, int []v){
		double convert = 180/Math.PI;
		double cos = scalarproduct (u,v)/(getDistance (u) * getDistance (v));
		return Math.acos(cos)*convert;
	}
	
	private static double distancepointtosegment (int [] P, int []A, int []B){
		int [] n = getNormalVector (A,B);
		int [] PA = getVector (P,A);
		int [] PB = getVector (P,B);
		if (	(angle (n, PA) <180 && angle (n, PB) < 180)		||		( angle(n, PA)>180 && angle(n, PA)<360 && angle(n,PB)>180 && angle(n,PB)<360)	)
			return Math.min(getDistance (PA), getDistance (PB));
		else  return distancepointoline (lineequation (A,B) , P);

			
		
	}

}
