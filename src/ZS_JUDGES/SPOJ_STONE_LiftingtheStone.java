package ZS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class SPOJ_STONE_LiftingtheStone {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader rd = new BufferedReader (new InputStreamReader (System.in));
		int numoftestcases = Integer.parseInt(rd.readLine());
		
		
	 
		String inp [];

		
		for (int i = 0; i < numoftestcases; i++){
			int n = Integer.parseInt(rd.readLine());
			double [] []points = new double [n+1] [2];
			
			inp = rd.readLine().split(" ");
			points [0] [0]=points [n] [0] = Double.parseDouble(inp [0]);
			points [0] [1] = points [n] [1]= Double.parseDouble(inp [1]);
			for (int j=1; j < n; j++){
				inp = rd.readLine().split(" ");
				points [j] [0] = Integer.parseInt(inp [0]);
				points [j] [1] = Integer.parseInt(inp [1]);			
			}
		calculate(points,n);
			
		}
		rd.close();
		
		

	}

	private static void calculate(double[][] points, int n) {
		
		n++;
		double [] precounted = new double [n];
		
		double area =0;
		for (int i= 0; i < n-1; i++){
			precounted [i] = points [i][0] * points [i+1][1] - points [i+1] [0] * points[i][1];
			area += precounted [i];
			
		}
		area /=2;
		
		double Cx =0;
		for (int i = 0; i < n-1; i++){
			Cx +=(points [i][0] + points [i+1][0]) *precounted [i];
			
		}
		Cx /=(6*area);
		double Cy =0;
		for (int i = 0; i < n-1; i++){
			Cy +=(points [i][1] + points [i+1][1]) * precounted [i];
			
		}
		Cy /=(6*area);
		
		System.out.printf(String.format(Locale.US, "%.2f %.2f\n", Cx,Cy));
		
	}

}
