package A0Myself;

import java.util.HashSet;
import java.util.LinkedList;

public class GraphSearch {
    public static <T> int distanceSearch(GraphNode<T> start, GraphNode<T> end){
        LinkedList<GraphNode<T>> nodeQueue = new LinkedList<>();
        LinkedList<Integer> distanceQueue = new LinkedList<>();
        HashSet<GraphNode<T>> visited = new HashSet<>();

        nodeQueue.add(start);
        distanceQueue.add(0);

        //if the que is
        while(!nodeQueue.isEmpty()){
            //deque from the queue
            GraphNode<T> dequeNode = nodeQueue.remove();
            int dequeDistance = distanceQueue.remove();

            if(dequeNode.equals(end)){
                return dequeDistance;
            }

            visited.add(dequeNode);
            for(GraphNode<T> edges: dequeNode.getEdges()){
                if(!visited.contains(edges)){
                    //put in the que
                    nodeQueue.add(edges);
                    distanceQueue.add(dequeDistance+1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GraphNode<String> a = new GraphNode<>("a");
        GraphNode<String> b = new GraphNode<>("b");
        GraphNode<String> c = new GraphNode<>("c");
        GraphNode<String> d = new GraphNode<>("d");
        GraphNode<String> e = new GraphNode<>("e");
        GraphNode<String> f = new GraphNode<>("f");

        a.addUndirectedEdge(b);
        a.addUndirectedEdge(c);

        b.addUndirectedEdge(c);
        b.addUndirectedEdge(d);

        c.addUndirectedEdge(e);
        c.addUndirectedEdge(f);

        d.addUndirectedEdge(f);

        e.addUndirectedEdge(f);

        System.out.println(distanceSearch(a,b));

    }
}
