import java.util.*;

public class Digraph {
    private final int V;
    private List<Set<Integer>> adj;

    public Digraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new HashSet<>());
    }

    public int V() {
        return V;
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);  // duplicate edges ignored
    }

    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj(v))
                R.addEdge(w, v);
        return R;
    }
}