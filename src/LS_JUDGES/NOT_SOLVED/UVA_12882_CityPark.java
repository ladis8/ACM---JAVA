package LS_JUDGES.NOT_SOLVED;

/*
7
4 9 4 2
2 6 2 4
4 2 2 6
10 4 1 4
1 5 3 1
8 3 2 3
1 1 3 2
*/

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;

/**
 * Created by Ladislav on 5/4/2017.
 */
public class UVA_12882_CityPark {
    public static Edge [] edgesh ;
    public static Edge [] edgesv ;
    public static DisjointSet<Integer> union;


    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int stones = Integer.parseInt(rd.readLine());
        edgesh = new Edge[stones *2];
        edgesv = new Edge[stones *2];

        int [][] rectangles = new int[stones][4];

        for (int i = 0; i < stones ; i++) {
            String [] parts = rd.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                rectangles [i][j] = Integer.parseInt(parts[j]);
            }
            edgesh[2*i]=      new Edge (rectangles[i][0]             ,rectangles[i][1],rectangles[i][3],rectangles[i][2],false,i); //coor[3] is height
            edgesh [2*i +1] = new Edge (rectangles[i] [0]+ rectangles[i][2],rectangles[i][1], rectangles[i][3],rectangles[i][2],true,i);

            edgesv [2*i] = new Edge(rectangles[i] [1], rectangles[i] [0], rectangles[i] [2],rectangles[i][3],false,i);
            edgesv [2*i +1] = new Edge(rectangles[i] [1]+ rectangles[i][3],rectangles[i] [0],  rectangles[i] [2],rectangles[i][3],true,i);

        }
        Arrays.sort(edgesh);
        Arrays.sort(edgesv);
        union  = new DisjointSet<Integer>(stones);
        //System.out.println(union.toString());

        /*for (Edge e : edgesh){
            System.out.println(e);
        }*/

        int counter = 0;
        while (counter < 2*stones){
            int end = getIndex(edgesh, counter, 2* stones);
            //System.out.println(end);
            //System.out.println(union.toString());
            overlap(edgesh, counter, end);
            counter =end;
        }

        counter = 0;
        while (counter < 2*stones){
            int end = getIndex(edgesv, counter, 2*stones);
            //System.out.println(end);
            overlap(edgesv, counter, end);
            //System.out.println(union.toString());
            counter =end;
        }

        //System.out.println(union.toString());
        int [] areas = new int [stones];

        //Arrays.sort(union.nodes);
        for (int i = 0; i <stones ; i++) {
            areas [union.find(i).id]+= rectangles[i][2] * rectangles[i][3];
        }

        int maxarea =0;
        for (Integer ar : areas){
            if (ar > maxarea){
                maxarea = ar;
            }
        }
        System.out.println(maxarea);


    }

    private static void overlap(Edge [] e, int counter, int end) {
        for (int i= counter; i< end; i++){
            for (int j = i+1; j < end; j++){

                if (e[i].x2 + e[i].size >= e[j].x2){
                    //System.out.println(e[i].rectangle + " "+  e[j].rectangle);
                    union.union(e[i].rectangle, e[j].rectangle);

                }
            }
        }
    }

    public static int getIndex(Edge[] e, int startindex, int n){
        int i = startindex +1;
        while (i <n && e[i].x1 == e[startindex].x1){
            i++;
        }
        return i;
    }


    public static class Edge implements Comparable<Edge>{

        public  Integer x1,x2, size, size2;
        public  boolean end;
        public  int rectangle;

        public Edge(Integer x1, Integer x2, Integer x3, Integer size3, boolean end,int rectangle){
            this.x1 = x1; this.x2 = x2; this.size = x3;this.size2= size3;
            this.rectangle = rectangle;
            this.end = end;
        }


        @Override
        public int compareTo(Edge o) {
            return this.x1 != o.x1? this.x1.compareTo(o.x1) :( this.x2!=o.x2 ? this.x2.compareTo(o.x2) : this.size.compareTo(size));
        }

        public String toString (){
            return ("( " + x1 + " "+ x2+ " " + size +")");
        }
    }



    public static class DisjointSet<ENTITY> {

        private Node[] nodes;

        public DisjointSet(int n) {
            nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(0,null,i);
            }
        }

        public int union(int a, int b) {
            Node repA = nodes[find(a).id];
            Node repB = nodes[find(b).id];

            if (repA.id == repB.id) return repA.id;

            if(repA.rank == repB.rank){
                repB.parent = repA;
                repA.rank++;
                return repA.id;
            } else if(repA.rank > repB.rank){
                repB.parent = repA;
                return repA.id;
            } else {
                repA.parent = repB;
                return repB.id;
            }
        }

        /**
         * Vrati reprezentanta komponenty obsahujici uzel s danym id
         * @param a id uzlu
         * @return reprezentant
         */
        public Node find(int a) {
            Node n = nodes[a];
            int jumps = 0;
            while (n.parent != null) {
                n = n.parent;
                jumps++;
            }
            if (jumps > 1) repair(a, n.id);
            return n;
        }

        /**
         * Kontrahuje cestu do reprezentanta
         * @param a id uzlu, ze ktereho bude cesta opravena
         * @param rootId id reprezentanta
         */
        private void repair(int a, int rootId) {
            Node curr = nodes[a];
            while (curr.id != rootId) {
                Node tmp = curr.parent;
                curr.parent = nodes[rootId];
                curr = tmp;
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < nodes.length; i++) {
                builder.append(find(i) + " ");
            }
            return builder.toString();
        }

    }
    public static class Node implements Comparable<Node> {

        public int rank;
        public Node parent;
        public Integer id;

        public Node (int rank, Node parent, Integer id){
            this.rank =rank; this.id = id; this.parent =parent;
        }

        public String toString(){
            return Integer.toString((Integer) this.id);
        }

        @Override
        public int compareTo(Node o) {
            System.out.println(this.id);
            return (this.parent.equals(null)? this.id : this.parent.id).compareTo(o.parent.equals(null) ? o.id : o.parent.id);
        }
    }
}

