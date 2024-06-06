package C03;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch {

    public static <T> int distance(GraphNode<T> start, GraphNode<T> end){
        Queue<GraphNode<T>> queue = new LinkedList();
        Queue<Integer> disQueue = new LinkedList<>();
        HashSet<GraphNode<T>> visited = new HashSet<>();
        int currentDistance = 0;
        queue.add(start);
        disQueue.add(0);
        while(!queue.isEmpty()){
            GraphNode<T> fatherNode = queue.remove();
            currentDistance = disQueue.remove();
            if(fatherNode.equals(end)){
                return currentDistance;
            }
            visited.add(fatherNode);
            boolean added = false;
            for(GraphNode<T> childNode : fatherNode.getEdges()){
                if (visited.contains(childNode)) {
                    continue;
                }
                queue.add(childNode);
                disQueue.add(currentDistance+1);
            }
        }
        return -1;
    }

    //when use encapsulation, we will not use the set of visited
    public static <T> int distanceUseSearchNode(GraphNode<T> start, GraphNode<T> end){
        Queue<GraphNode<T>> queue = new LinkedList<>();
        start.distance = 0;
        queue.add(start);
        while(!queue.isEmpty()){
            GraphNode<T> fatherNode = queue.remove();
            fatherNode.visited=true;
            if(fatherNode.equals(end)){
                return fatherNode.distance;
            }
            for(GraphNode<T> child:fatherNode.getEdges()){
                if(child.visited){
                    continue;
                }

                //when we give the distance, and its value >=0,then we should not change its distance, it is the minimum distance
                //or if the distance >=0; this child node has already been added into the queue, we don't need to add again, just continue
                if(child.distance<0){
                    child.distance = fatherNode.distance+1;
                }
                queue.add(child);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        //create nodes
        GraphNode<String> a = new GraphNode<>("a");
        GraphNode<String> b = new GraphNode<>("b");
        GraphNode<String> c = new GraphNode<>("c");
        GraphNode<String> d = new GraphNode<>("d");
        GraphNode<String> e = new GraphNode<>("e");
        GraphNode<String> f = new GraphNode<>("f");

        // Creating connections/edges
        /*
         * a----b
         * | \  |
         * |  \ |
         * |    c
         * |   / \
         * d  /   \
         *  \ /    |
         *   e-----f
         */
        a.addUndirectedEdge(b);
        a.addUndirectedEdge(c);
        b.addUndirectedEdge(c);
        b.addUndirectedEdge(d);
        c.addUndirectedEdge(e);
        c.addUndirectedEdge(f);
        d.addUndirectedEdge(f);
        e.addUndirectedEdge(f);

        System.out.println("use queue: find a->f  dis: "+ distance(a,f));

        // Creating a node that is not connected to our graph to see if we get -1 as answer
        GraphNode<String> z = new GraphNode<>("z");
        System.out.println("use queue: find a->z  dis:"+ distance(a,z));

        System.out.println("use node Encapsulation: find a->f  dis: "+ distanceUseSearchNode(a,f));
        System.out.println("use node Encapsulation: find a->z  dis: "+ distanceUseSearchNode(a,z));
    }
}
