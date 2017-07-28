/**
 * Created by Ladis on 19.11.2016.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


class UVA_11631_DarkRoads
{

    public static void main (String [] args) throws IOException {


        BufferedReader sc  = new BufferedReader(new InputStreamReader(System.in) );


        String line;
        while (!((line=sc.readLine()).equals("0 0"))){

            int vertex = Integer.parseInt(line.split(" ") [0]);
            int edges = Integer.parseInt(line.split(" ") [1]);
            int totalprice = 0;

            List <Edge> list = new ArrayList<Edge>();

            for (int i = 0; i < edges; i++) {
                String [] input = sc.readLine().split(" ");
                Edge e = new Edge(Integer.parseInt(input [0]), Integer.parseInt(input [1]),Integer.parseInt(input [2]));
                list.add(e);
                totalprice+= e.weight;
            }
            System.out.println(totalprice - kruskalAlgoritm(list,vertex));
        }




    }

    public static int kruskalAlgoritm (List <Edge> edges, int nodeCount){
        DisjointSet ds = new DisjointSet(nodeCount);
        int edgecounter = 0;
        Collections.sort(edges);
        int price = 0;
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
        public int weight;
        public Edge (int PV, int KV, int weight){
            this.PV = PV;
            this.KV = KV;
            this.weight =weight;
        }
        @Override
        public int compareTo(Edge o) {
            if (this.weight > o.weight)
                return 1;
            else if (this.weight < o.weight)
                return  -1;
            else  return 0;
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
    //This code is contributed by Aakash Hasija