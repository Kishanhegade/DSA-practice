package ds;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public List<Integer>  dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> ls = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfs(0,vis,adj,ls);
        return ls;
    }

    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);
        for(Integer it:adj.get(node))
        {
            if(!vis[it])
            {
                vis[it] = true;
                dfs(it,vis,adj,ls);
            }
        }
    }
}
