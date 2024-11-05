package unit07.sourceTarget;

import java.util.LinkedList;
import java.util.List;

import unit07.graphs.AdjacencyGraph;

public class AdjacencyGraphSTv2<E> extends AdjacencyGraph<E> {
    private AdjacencyGraph<E> graph;
    private E s;
    private E t;

    @SuppressWarnings("unchecked")
    public AdjacencyGraphSTv2(AdjacencyGraph<E> graph, E[] S, E[] T) {
        this.graph = graph;
        this.s =  (E)("DummyNode");
        this.t =  (E)("DummyNode2");
        graph.add(s);
        graph.add(t);


        for (E targetNodes : T) {
            // graph.add(targetNodes);
            graph.connectDirected(targetNodes,t);
        }
        for (E sourceNodes : S) {
            // graph.add(sourceNodes);
            graph.connectDirected(s, sourceNodes);
        }    
    }

    // @Override
    // public void connectDirected(E a, E b) {
    //     Vertex<E> vertexA = vertices.get(a);
    //     Vertex<E> vertexB = vertices.get(b);
    //     vertexA.connect(vertexB);
    // }

    public boolean bfSearch() {
        return graph.bfSearch(s,t);
    }

    public List<E> bfPath() {
        if(graph.bfSearch(s,t)){
        List<E> pathie = graph.bfPath(s,t);
        List<E> path = new LinkedList<>();
        for (int i = 0; i < pathie.size() -2;i++){
            path.add(i,pathie.get(i+1));
        }
        return path;
    }else{
        return  null;
    }

    };
}