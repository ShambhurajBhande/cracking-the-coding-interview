package ctci.treeandgraph;
/* @author Shambhuraj created on 2/20/2020*/
/*Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes. */
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addChildren(0, 1);
        graph.addChildren(0, 2);
        graph.addChildren(1, 2);
        graph.addChildren(2, 0);
        graph.addChildren(2, 3);
        graph.addChildren(3, 3);

        boolean isRoutePresent = isRoutePresent(graph, graph.getGraph().size(), 0, 3);
        System.out.println(isRoutePresent);
    }

    private static boolean isRoutePresent(Graph graph, int length, int start, int end) {
       if(start==end)
           return true;
        boolean visited[] = new boolean[length];

        Queue queue = new PriorityQueue();
        visited[start] = true;
        queue.add(start);

        Iterator<Integer> iterator;
        while (!queue.isEmpty()) {
            start = (int) queue.poll();
            int n;
            iterator = graph.getNodes(start).listIterator();
            while (iterator.hasNext()) {
                n = iterator.next();
                if (n == end) {
                    return true;
                }
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }
}
