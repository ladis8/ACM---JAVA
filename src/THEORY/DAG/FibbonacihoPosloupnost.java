package THEORY.DAG;

public class FibbonacihoPosloupnost {

	
	private static int[] fibbonaciarray;
	private static int n = 7;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		fibbonaciarray= new int [n+1];
		fibbonaciarray [2] = 1;
		int out = fibonnaci (n);

		System.out.println (out);
	}
	
	//[0][1][][]3
	
	private static int fibonnaci (int n){
		//n -=1;
		//System.out.println ("n: "+ n);
		//n ... pocet clenu posloupnosti
		if (fibbonaciarray [n] == 0 && n != 1){
			//System.out.println(fibbonaciarray [n]);
			fibbonaciarray [n] = fibonnaci (n-1) + fibonnaci (n-2);
			
		}
		/*if (n ==0)
			return 0;
		if (n ==1){
			System.out.println ("returned");
			return 1;
		}
		int fibb =FibbonacihoPosloupnost (n-1) + FibbonacihoPosloupnost (n-2);*/
		
		//System.out.println("return: "+ fibbonaciarray [n]);
		return fibbonaciarray [n]; 
		
	}

}
