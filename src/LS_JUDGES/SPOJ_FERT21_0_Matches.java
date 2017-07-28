package LS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;



/**
 * Created by Ladis on 26.2.2017.
 */
public class SPOJ_FERT21_0_Matches {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(rd.readLine());
        int[] testcases = new int[tests+1];

        BigDecimal[] solutions;
        int m = 0;

        for (int i = 1; i <= tests; i++){
            int n = Integer.parseInt(rd.readLine());
            testcases[i] = n;
            m = Math.max(m, n);
        }
        solutions = new BigDecimal[m + 1];

        BigDecimal out = BigDecimal.valueOf(0.5);
        BigDecimal k = BigDecimal.valueOf(0.5);
        for (int i = 2; i < m ; i++) {
            solutions[i] = out;
            out = out.multiply(k);
        }
        solutions[m] = out;

        for (int i = 1; i <= tests; i++){
            if (testcases [i] == 1){
                System.out.printf("1\n");
            }
            else{
                System.out.printf("%s\n",solutions[testcases[i]].toPlainString());
            }
        }
    }

}
