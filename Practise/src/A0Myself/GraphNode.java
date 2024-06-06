package A0Myself;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphNode<T> {
    public T value;

    private List<GraphNode<T>> edges = new ArrayList();

    public GraphNode(T value){
        this.value = value;
    }
    public void addUndirectedEdge(GraphNode<T> other){
        edges.add(other);
        other.edges.add(this);
    }

    public List<GraphNode<T>> getEdges() {
        return Collections.unmodifiableList(edges);
    }
}
