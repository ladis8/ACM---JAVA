package ZS_JUDGES;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Ladis on 12.11.2016.
 */
public class SPOJ_COINS_BytelandianGoldCoins {

    //SPOJ COINS - Bytelandian gold coins//

    private static HashMap<Long, Long> hashmap;

    public static void main (String [] args){


        hashmap = new HashMap();
        hashmap.put(0L,0L);
        hashmap.put(1L,1L);

        Scanner sc = new Scanner (System.in);

        while(sc.hasNext()) {
            String s1 = sc.nextLine();
            if(!s1.equals(null)) {

                System.out.println(calculatemax(Long.parseLong(s1)));
            }
        }
    }

    private static long calculatemax(long num) {

        if (!(hashmap.containsKey(num))){

            long a = calculatemax (num/2) + calculatemax(num/3) + calculatemax(num/4);
            if (a > num)
                hashmap.put(num, a);

            else
                hashmap.put(num, num);

        }

        return hashmap.get(num);

    }

}
