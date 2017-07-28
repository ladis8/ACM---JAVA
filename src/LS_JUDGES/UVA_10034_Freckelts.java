package LS_JUDGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
/**
 * Created by Ladis on 3.4.2017.
 */
public class Freckelts {

        public static void main (String [] args) throws IOException {
            Locale.setDefault(Locale.US);


            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            int tests = Integer.parseInt(sc.readLine());


            while (tests-- > 0) {
                sc.readLine();

                int vertex = Integer.parseInt(sc.readLine());
                double[] coorx = new double[vertex];
                double[] coory = new double[vertex];


                List<Edge> list = new ArrayList<Edge>();

                for (int i = 0; i < vertex; i++) {
                    String[] input = sc.readLine().split(" ");
                    coorx[i] = Double.parseDouble(input[0]);
                    coory[i] = Double.parseDouble(input[1]);
                }

                //creating edges
                for (int i = 0; i < vertex - 1; i++) {
                    for (int j = i + 1; j < vertex; j++) {
                        Edge e = new Edge(i, j, (float) Math.sqrt(Math.pow(coorx[j] - coorx[i], 2) + Math.pow(coory[j] - coory[i], 2)));
                        list.add(e);
                    }

                }

                System.out.printf("%.2f\n",kruskalAlgoritm(list,vertex));
                if (tests !=0){
                    System.out.printf("\n");
                }

            }
        }

        public static double kruskalAlgoritm (List <Edge> edges, int nodeCount){
            DisjointSet ds = new DisjointSet(nodeCount);

            int edgecounter = 0;
            Collections.sort(edges);
            double price = 0;
            int i = 0;
            while (i < edges.size() && edgecounter< nodeCount -1){
                Edge e = edges.get(i);
                if (ds.find(e.PV) != ds.find(e.KV)){
                    ds.union(e.PV,e.KV);
                    price +=e.weight;
                }
                i++;
            }
            return price;
        }


    }

    class Edge implements Comparable <Edge>{

        public int PV;
        public int KV;
        public Double weight;
        public Edge (int PV, int KV, double weight){
            this.PV = PV;
            this.KV = KV;
            this.weight =weight;
        }
        @Override
        public int compareTo(Edge o) {
           return this.weight.compareTo(o.weight);
        }
    }

    class DisjointSet{
        private Node [] nodes;

        public DisjointSet (int nodeCount){
            nodes = new Node[nodeCount];

            for (int i = 0; i <nodeCount ; i++) {
                nodes [i] = new Node();
                nodes [i].id =i;
            }
        }

        public int union (int a, int b){
            Node noda = nodes [find(a)];
            Node nodb = nodes [find (b)];
            nodb.parent = noda;
            return noda.id;
        }

        public int find (int a){
            Node n = nodes [a];
            int jumps = 0;
            while (n.parent !=null){
                n = n.parent;
                jumps++;
            }
            if (jumps >1) repair (a, n.id);
            return n.id;
        }

        private void repair(int a, int rootId) {
            Node curr = nodes[a];

            while (curr.id != rootId) {
                Node tmp = curr.parent;
                curr.parent = nodes[rootId];
                curr = tmp;
            }
        }
        private static class Node {
            Node parent;
            int id;
        }
    }

