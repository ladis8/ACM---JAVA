package ZS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class UVA_920_SunnyMountains {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader rd = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st;
		int numoftestcases = Integer.parseInt(rd.readLine());
	 
		
		
		for (int i = 0; i < numoftestcases; i++){
			int n = Integer.parseInt(rd.readLine());
			int [] []points = new int [n][2];
				
			
			for (int j=0; j < n; j++){
				st = new StringTokenizer (rd.readLine());
				points [j][0] = Integer.parseInt(st.nextToken());
				points [j] [1]= Integer.parseInt(st.nextToken());			
			}
			quickSort(points, 0, n-1);
			calculate (points);
					
		}
		rd.close();
	}
		
	private static void calculate(int[][] points) {
		// TODO Auto-generated method stub
		double altitude = 0;
		double sum = 0;
		for (int i = points.length-1; i>0; i-=2){
			int X [] = points [i];
			int Y [] = points [i-1];
			
			
			if (Y [1] > altitude){
				int [] line = lineequation (X, Y);
				double x = -1* (line [2] +line [1] * altitude)/line[0];
				sum+= getDistance (getVector (new double [] {x, (double) altitude}, new double [] {(double) Y[0], (double) Y[1]}));
				altitude = Y[1];
				
				
			}
				
		}
		System.out.printf(String.format(Locale.US, "%.2f\n", sum));
		
	}

	public static void quickSort(int[][] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle][0];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i][0] < pivot) {
				i++;
			}
 
			while (arr[j][0] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i][0];
				arr[i][0] = arr[j][0];
				arr[j][0] = temp;
				temp = arr [i][1];
				arr[i][1] = arr[j][1];
				arr [j] [1] = temp;			
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
	
	private static int [] lineequation (int [] A, int [] B){
		int a = A [1] - B [1];
		int b = B[0] - A [0];
		int c = -1* (a * A[0] + b *A[1]);
		return new int [] {a,b,c};
	}
	private static double getDistance (double[] u){
		return Math.sqrt (Math.pow(u[0],2) + Math.pow(u[1],2));		
	}
	private static double [] getVector (double [] A, double [] B){
		//returns the vector AB = B-A
		return new double [] {B[0] - A[0], B[1] - A[1]};
	}
	
	
}


