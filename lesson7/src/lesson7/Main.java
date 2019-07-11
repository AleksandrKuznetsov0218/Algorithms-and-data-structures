package lesson7;

public class Main {

    public static void main(String[] args) {
//        Graph graph = new Graph(10);
//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(0,2);
//        graph.addEdge(0,4);
//        graph.addEdge(2,9);
//        graph.addEdge(4,9);
//        graph.addEdge(1,3);
//        graph.addEdge(3,5);
//        graph.addEdge(3,8);
//        graph.addEdge(6,7);
//
//        System.out.println(graph.getAdjList(0));
//        System.out.println(graph.getAdjList(3));
//
//        BreadthFirstPath bfp = new BreadthFirstPath(graph,0);
//        System.out.println(bfp.pathTo(9));
//        System.out.println(bfp.hasPathTo(8));
//        System.out.println(bfp.hasPathTo(6));


        Graph graph = new Graph(30);

        int[] v1 = new int[60];
        int[] v2 = new int[60];

        for (int i = 0; i < 60; i++) {
            v1[i] = (int) (Math.random() * 30);
            v2[i] = (int) (Math.random() * 30);
            graph.addEdge(v1[i], v2[i]);
        }

        BreadthFirstPath bfp = new BreadthFirstPath(graph,0);
        System.out.println(bfp.hasPathTo(25));
        System.out.println(bfp.pathTo(25));
    }
}
