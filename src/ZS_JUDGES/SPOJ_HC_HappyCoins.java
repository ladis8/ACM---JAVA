package ZS_JUDGES;

import java.util.Scanner;

public class SPOJ_HC_HappyCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		int numoftest = Integer.parseInt(sc.nextLine());
		
		for (int i =0; i < numoftest; i++){
			int coins = Integer.parseInt(sc.nextLine());
			int lxh = 0;
			int hhb=0;
			
			for (int j = 0 ; j < coins; j++){
				if (sc.nextLine().equals("lxh")){
					lxh++;		
				}
				else{
					hhb++;
				}
			}
			
			if (coins ==1){
				if (lxh ==1){
					System.out.println("lxh");
				}
				else{
					System.out.println("hhb");
				}
				
			}
			else if ((lxh)%2 ==0){
				System.out.println("hhb");
			}
			else{
				System.out.println("lxh");
			}
			/*
			else if ((lxh^hhb) ==0){
				System.out.println("lxh");
			}
			else {
				System.out.println("hhb");
			}*/
	
		}
	}

}
