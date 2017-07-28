package ZS_JUDGES;

import java.util.Scanner;

public class UVA_10165_StoneGame {


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Scanner sc = new Scanner (System.in);
			int numofpile = sc.nextInt();
			
			while (numofpile != 0){
				
				int nimsum=0;
				for (int i = 0; i < numofpile; i++){
					nimsum ^= sc.nextInt();
				}
				
				if (nimsum==0){
					System.out.println("No");
				}
				else{
					System.out.println("Yes");
				}
				
				numofpile = sc.nextInt();
				
			}
					

	}


}
