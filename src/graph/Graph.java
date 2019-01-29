package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph{
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.dfs(1, 4);
    }

    private int v;
    private LinkedList<Integer> adj[];
    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    pre[q] = w;
                    if (q == t) {
                        print(pre, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    public void print(int[] pre, int s, int t){
        if (s == t) {
            System.out.print(s);
            return;
        }
        print(pre, s, pre[t]);
        System.out.print(" -> " + t);
    }
    private static boolean found;
    public void dfs(int s, int t){
        found = false;
        boolean[] visited = new boolean[v];
        int[] pre = new int[v];
        for (int i = 0; i < v; i++){
            pre[i] = -1;
        }
        recurDfs(visited, pre, s, t);
        print(pre, s, t);
    }

    public void recurDfs(boolean[] visited, int[] pre, int w, int t){
        if(found) return;
        visited[w] = true;
        if(w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++){
            int q = adj[w].get(i);
            if(!visited[q]){
                pre[q] = w;
                recurDfs(visited, pre, q, t);
            }
        }
    }

}