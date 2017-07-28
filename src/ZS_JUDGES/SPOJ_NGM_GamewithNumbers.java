package ZS_JUDGES;
	
	import java.util.Scanner;

public class SPOJ_NGM_GamewithNumbers {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
				
			Scanner sc = new Scanner (System.in);
			String line= sc.nextLine();
			
			while ((line=sc.nextLine())!= null ){
				long number = Long.parseLong(line);
				
				if (number % 10 == 0){
					System.out.println(2);
				}
				else{
					System.out.println(1);
					System.out.println(number%10);
				}
				
				
			}
				
			
		}
	
	}
