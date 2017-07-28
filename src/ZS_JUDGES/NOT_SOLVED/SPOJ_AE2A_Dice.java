package ZS_JUDGES.NOT_SOLVED;

import java.util.Scanner;

public class SPOJ_AE2A_Dice {

    private static int [] dice = {1,2,3,4,5,6};
    private static int [][] estimationarray;
    private static int nborder = 545;
    private static int eborder = 1908;
    
    //private static int n =3, estimation = 6;
    //private static int n, estimation;

    public static void main (String [] args){


        Scanner sc = new Scanner(System.in);
        int numoftestcases = Integer.parseInt(sc.nextLine());
        calculate(nborder,eborder);


        for (int test = 0; test < numoftestcases; test++) {
            String parts [] =sc.nextLine().split(" ");
            int n = Integer.parseInt(parts [0]);
            int estimation = Integer.parseInt(parts [1]);

            if (estimation ==0 || estimation >=eborder || n >= nborder ){
                System.out.println(0);
            }
            else {
                System.out.println(100* estimationarray [n] [estimation]/((int)Math.pow(6,n)));
            }


            //System.out.println(100* calculate(n, estimation)/((int)Math.pow(6,n)));
            //System.out.println(100* onethrow(0,0)/((int)Math.pow(6,n)));
        }





    }

    private static void calculate (int n, int estimation) {


        estimationarray = new int[n + 1][estimation + 1];

        for (int dicenum : dice) {
            estimationarray[1][dicenum] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < estimation && j <= i * 6; j++) {

                for (int dicenum : dice) {
                    if (!(j + dicenum > estimation)) {
                        estimationarray[i + 1][j + dicenum] += estimationarray[i][j];
                       //if (j + dicenum ==estimation)
                           //System.out.println("i:" + i + " j:" + j + " dicenum " + dicenum + " estimationrownum: " + estimationarray [i+1][estimation]);
                    }

                }


            }
        }

       // return estimationarray [n] [estimation];
    }

    /*private static int onethrow(int dic, int sum){

        if (dic == n ){
            if (sum ==estimation) {
                return 1;
            }
            else
                return 0;

        }
        else if (sum + n-dic > estimation ){
            return 0;
        }
        else

         return onethrow(dic+1, sum+1)+onethrow(dic+1, sum+2)+onethrow(dic+1, sum+3)+onethrow(dic+1, sum+4)+onethrow(dic+1, sum+5)+onethrow(dic+1, sum+6);

    }*/
}

