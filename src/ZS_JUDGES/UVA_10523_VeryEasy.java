package ZS_JUDGES;


import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class UVA_10523_VeryEasy {

	public static void main(String[] args) throws IOException {
		Scanner rd = new Scanner (System.in);
		String inp;
		
		while (rd.hasNextLine()){
			inp = rd.nextLine();
			int n =Integer.parseInt(inp.split(" ") [0]);
			int a = Integer.parseInt(inp.split(" ") [1]);
			count(n,a);
			
		}

	}

	private static void count(int n, int a) {
		// TODO Auto-generated method stub
		BigInteger out = new BigInteger("0");
		BigInteger A = new BigInteger (Integer.toString(a));
		BigInteger I;
		for (int i=1; i <= n;i++){
			I =new BigInteger (Integer.toString (i));
			out =out.add(A.pow(i).multiply(I));		
		}
		System.out.println(out.toString());
		
		
	}

}
