package THEORY.NUMBERS;

public class numberAlgorithms {
	
	public static void main(String [] args){
		System.out.println(GCD (810,306));
		System.out.println(EUCLID (306,810)[0] + " " + EUCLID (306,810) [1]);
		LITTLEFERMAT (25,42);
	}
	
	public static void LITTLEFERMAT (int a, int modulo){
		
		if (GCD (a, modulo) != 1)
			System.out.println("MULTIPLICATIVE INVERSE DOES NOT EXIST");
		else{
			
			System.out.print("MULTTIPLICATIVE INVERSE IS: ");
			System.out.print(power (a,modulo-2, modulo));
		}
		
	}
	
	private static int power (int x, int y, int m){	
	    if (y == 0) return 1;
	    int p = power(x, y/2, m) % m;
	    p = (p * p) % m;
	    return (y%2 == 0)? p : (x * p) % m;
}
	
	//EXTENDED EUCKLID ALGORITHM
	public static int []  EUCLID(int a, int b){
		
		int x0= 1, y0=0, x1=0, y1=1;
		int q, tmp;
		
		while (a >0){
			q = b/a;
			tmp=x1;
			x1= x0 - q*x1;

			x0=tmp;
			tmp=y1;
			y1=y0- q*y1;
			
			y0=tmp;
			System.out.println(a+ " "+q+" "+ x1 + " " +y1);
			tmp=a;
			a=b%a;
			b=tmp;
		}
		
		return new int[] {x1,y1};
		
	}

	//BASIC EUCKLID ALGORITHM
	public static int GCD (int a, int b){
		if (a == 0){
			return b;
		}
		else{
			System.out.println(b%a +" " + a);
			return GCD (b%a, a);
		}
	}

}
