package ZS_JUDGES;

import java.util.Scanner;

public class SPOJ_MMMGAME_MMGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		int numoftests = sc.nextInt();
		String line;
		
		
		//John starts firts
		for (int i = 0; i < numoftests; i++){
			
			int sum = 0;
			int different = sc.nextInt();
			int [] mme = new int [different];
			
			for (int j = 0 ; j< different; j++){
				mme [j] = sc.nextInt();
				sum += mme[j];
				
			}
			
			if (sum == different){
				if (sum%2 == 0 )
					System.out.println("John");
				else
					System.out.println("Brother");
				
				
			}
			else{
				
				//P STATE -- IF NIM SUM IS NOT EQUAL TO 0 
				
				int nimsum=0;
				for (int j= 0; j < different; j++){
					nimsum^=mme[j];
				}
				
				//
				if (nimsum==0)
					System.out.println("Brother");
				
				
				else
					System.out.println("John");
				
				
			}
		
			
		}

	}

}
