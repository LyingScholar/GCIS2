package unit07.sourceTarget;

import java.util.LinkedList;
import java.util.List;

import unit07.graphs.AdjacencyGraph;


public class AdjacencyGraphST<E> extends AdjacencyGraph<E>{
    private AdjacencyGraph<E> graph;
    private E[] S;
    private E[] T;

    public AdjacencyGraphST(AdjacencyGraph<E> graph, E[] S, E[] T) {
        this.graph = graph;
        this.S = S;
        this.T = T;
    }

    public boolean bfSearch() {
        for (E sourceNode : S) {
            for (E targetNode : T) {
                if (graph.bfSearch(sourceNode, targetNode)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<E> bfPath() {
        List <List<E>> paths = new LinkedList<>();
        for (E sourceNode : S) {
            for (E targetNode : T) {
                List <E> path = graph.bfPath(sourceNode, targetNode);
                if (path != null) {
                    paths.add(path);
                }
            }
        }
        if(paths.size()!=0){
            List<E> minimum = paths.get(0);
            for(List<E> path : paths){
                if(path.size()< minimum.size()){
                    minimum = path;
                }
            }
            return minimum;
        }
        return null;
    }
} 