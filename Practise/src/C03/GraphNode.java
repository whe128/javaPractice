package C03;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    public T value;
    int distance;
    boolean visited;
    //the adjacent nodes
    private List<GraphNode<T>> edges =  new ArrayList<>();
    GraphNode(T value){
        this.value = value;
        distance = -1;
        visited = false;
    }

    public void addUndirectedEdge(GraphNode<T> node){
        edges.add(node);
        //why don't use addUndirectedEdges to add this to other node, because it will make forever loop
        node.edges.add(this);
    }

    public List<GraphNode<T>> getEdges() {
        return edges;
    }
}
