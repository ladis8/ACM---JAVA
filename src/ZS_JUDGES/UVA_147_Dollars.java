package ZS_JUDGES;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ladis on 12.11.2016.
 */
public class UVA_147_Dollars {

    private static final int [] coins = {5,10,20,50,100,200,500,1000,2000, 5000, 10000};
    private static final int maximumrange = 300000;
    private static final long [] solutiontab = new long [maximumrange+1];

    public static void main (String [] args){

        String [] splits;


        calculatesolutionTab();
        //printArray(solutiontab);

        Scanner sc = new Scanner(System.in);


        String input;

        while (!((input=sc.nextLine()).equals("0.00")))
            printoutput(input);


    }

    private static void printoutput(String input) {


        StringBuilder sb = new StringBuilder();
        char [] prefix = new char[6];
        Arrays.fill(prefix,' ');

        for (int i = 0; i < input.length(); i++){
            prefix [6-input.length() + i] = input.charAt(i);
        }

        int num = 100* Integer.parseInt(input.split("\\.") [0]) + Integer.parseInt(input.split("\\.") [1]);
        char [] suffix = new char [17];
        Arrays.fill(suffix,' ');
        String output = Long.toString(solutiontab[num]);

        for (int i = 0; i < output.length(); i++){
            suffix[17-output.length() + i] = output.charAt(i);
        }

        sb.append(prefix);
        sb.append(suffix);
        //sb.append("\n");
        System.out.println(sb.toString());

    }

    private static void calculatesolutionTab (){

        for (int coin : coins) {

            solutiontab [coin] +=1;

            for (int i = coin+1; i < solutiontab.length ; i++) {
                solutiontab [i] += solutiontab [i-coin];
            }

        }

    }

    private static void printArray(long array []){

        for (int i = 0; i <array.length; i++) {

            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <array.length; i++) {

            System.out.print(i + " ");
        }
        System.out.println();

    }
}
