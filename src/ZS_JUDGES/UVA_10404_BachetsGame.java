package ZS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_10404_BachetsGame {
	
	/*private class State{
		private boolean state;
		private int number;
		private State previousstate;
		
		public State (boolean state, int number, State previousstate){
			this.state = state;
			this.number = number;
			this.previousstate = previousstate;	
		}	
	}*/
	


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		BufferedReader rd = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st;
		String line=rd.readLine();
		
		while (line!= null  && !line.equals("")){
			
				st = new StringTokenizer (line);
				int size = Integer.parseInt(st.nextToken());
				int iterate = Integer.parseInt(st.nextToken());
				
				int [] substraction = new int [iterate];
				for (int i = 0; i < iterate; i++){
					substraction [i] = Integer.parseInt(st.nextToken());
				}
				if (size == 0){
					System.out.println("Ollie wins") ;
				}
				
				else if(getState(size, substraction)){
					System.out.println("Stan wins") ;
				}
				else{
					System.out.println("Ollie wins");
				}
				
			line = rd.readLine();
				
			}
		rd.close();
			
			
		
	}
	private static boolean getState(int size, int []substraction){
		
		size++;
		boolean [] statefield = new boolean [size];
		
		///false == P state
		///true == N state
		
	
		
		//1. label every position as P position
		//2. label every position that you can reach from P position as N position
		//3. find those position whose only moves are to labelled N positions label such positions as P positions
		
		//from every N position there is at least one move to a P position
		//from every P position, every move is to an N position
		
		int i = 0;
		while (i < size) {
			
			if (!statefield [i]){
				for (int plus : substraction){
					if (i+ plus < size)
						statefield [i + plus] = true;	
				}
				
			}
			i++;
		}
		
		/*for (boolean state : statefield){
			if (state){
				System.out.print("N ");
			}
			else {
				System.out.print ("P ");
			}
		
		}*/
	return (statefield[statefield.length -1]);

	}
		
}


