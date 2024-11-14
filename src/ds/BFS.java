package ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj){

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0] = true;
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            vis[node] = true;
            for(Integer it: adj.get(node))
            {
                if(!vis[it]) {
                    queue.add(it);
                    vis[it] = true;
                }
            }
        }
        return bfs;
    }
}
