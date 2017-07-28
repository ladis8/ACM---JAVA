package LS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by stefk on 6.4.2017.
 */
public class UVA_2824_CryptoColumns {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String keyword = rd.readLine();
        String text;

        while (!keyword.equals("THEEND")){
            text = rd.readLine();
            int size = text.length() / keyword.length();



            order [] el = new order[keyword.length()];
            for (int i = 0; i < keyword.length() ; i++) {
                order o  = new order();
                o.order = i;
                o.des = keyword.charAt(i);
                el[i] = o;
            }
            Arrays.sort(el);

            char [][] array = new char[size][keyword.length()];

            int counter=0;
            for (int i = 0; i < el.length; i++) {
                for (int j = 0; j < size ; j++) {
                    array [j][el[i].order]= text.charAt(counter);
                    counter++;
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j <keyword.length() ; j++) {
                    System.out.print(array[i][j]);
                }
            }
            System.out.println();
            keyword = rd.readLine();

        }
    }
    public static class order implements Comparable<order>{

        public int order;
        public Character des;

        @Override
        public int compareTo(order o) {
            return this.des.compareTo(o.des);
        }
    }
}
