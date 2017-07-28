package LS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_4324_Ugly_Windows {


            private static char[][] array;
            public static void main(String[] args) throws IOException  {
                // TODO Auto-generated method stub

            BufferedReader rd = new BufferedReader (new InputStreamReader(System.in));
            String line = rd.readLine();



                while (!(line.equals("0 0"))){
                    String [] parts = line.split(" ");

                    int m = Integer.parseInt(parts[0]);
                    int n = Integer.parseInt(parts[1]);
                    array = new char[m][n];

                    for(int i = 0; i < m; i++){
                        line =rd.readLine();
                        for (int j =0; j < n; j++){
                            array [i][j]=line.charAt(j);
                        }
                    }
                    countwindows();
                    line = rd.readLine();
                }






            }
            private static void countwindows() {
                int m = array.length;
                int n = array[0].length;

                char read ;
                int [] out = new int [26];
                int [][] edges = new int [26][8];




                for(int ii = 0; ii < m; ii++){
                    for (int jj =0; jj < n; jj++){
                        if (array[ii][jj] != '.' && out [array[ii][jj] - 'A'] ==0 ){
                            read = array[ii][jj];
                            //System.out.println(read);


                            int x = ii;
                            int y = jj;

                            int i = ii;
                            int j = jj;



                            while (j < n && array [i] [j] == read){
                                j++;
                            }

                            j--;
                            edges[read-'A'][0] = i;
                            edges[read-'A'][1] = j;

                            if (i+1 < m && array[i+1][j]==read){
                                while (i < m && array[i][j]==read){
                                    i++;
                                }

                                i--;
                                edges[read-'A'][2] = i;
                                edges[read-'A'][3] = j;

                                if (j-1 >=0 && array[i][j-1]==read){
                                    while (j >= 0 && array[i][j]==read){
                                        j--;
                                    }

                                    j++;
                                    edges[read-'A'][4] = i;
                                    edges[read-'A'][5] = j;

                                    if (i-1 >=0 && array[i-1][j]==read){
                                        while (i >= 0 && array[i][j]==read){
                                            i--;
                                        }

                                        i++;
                                        edges[read-'A'][6] = i;
                                        edges[read-'A'][7] = j;
                                        if (array[i][j+1]==read){
                                            while (j < n && array[i][j]==read){

                                                if (i == x && j==y){
                                                    out [read-'A'] = 1;
                                                    int p = read- 'A';


                                                    for (int z = 0 ; z < 26; z++){
                                                        if (out[z] == 1 && z!=array[x][y] -'A'){

                                                            if (edges[z][0]<edges[p][0] && edges[z][1]>edges[p][1]		&& edges[z][2]>edges[p][2] &&edges[z][3]>edges[p][3] 		&&edges[z][4]>edges[p][4] &&edges[z][5]<edges[p][5] 	&&edges[z][6]<edges[p][6] &&edges[z][7]<edges[p][7]){
                                                                out[z] = -1;}
                                                        }
                                                    }
											        break;
                                                }
                                                j++;
                                            }
                                        }
                                        else{out [read- 'A'] = -1;}
                                    }
                                    else{out [read- 'A'] = -1;}
                                } else{out [read- 'A'] = -1;}
                            } else{out [read- 'A'] = -1;}

                        }
                    }
                }


                for (int i=0;i< 26; i++){
                    if (out[i]==1){
                        System.out.print(((char) (i+'A')));
                    }
                }
                System.out.println();

            }

}




