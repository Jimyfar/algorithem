package topological;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph{
    private int v;
    private LinkedList<Integer>[] adj;

    public static void main(String[] args){
        Graph g = new Graph(5);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(1, 4);
        g.addEdge(0, 2);
        g.addEdge(4, 1);
        g.topoSortByKahn();
//        g.toSortByDFS();
    }
    public Graph(int v){
        this.v = v;
        this.adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }
    public void topoSortByKahn() {
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++){
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v ; i++){
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int i = queue.remove();
            System.out.print(" -> " + i);
            for (int j = 0; j < adj[i].size(); j++){
                int w = adj[i].get(j);
                inDegree[w]--;
                if (inDegree[w] == 0) queue.add(w);
            }
        }
    }

    public void toSortByDFS(){
        LinkedList<Integer>[] inverseAdj = new LinkedList[v];
        for (int i = 0; i < v; i++){
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; i++){
            for(int j = 0; j < adj[i].size(); j++){
                int w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++){
            if (visited[i] == false){
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    public void dfs(
            int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited){
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }
        System.out.print(" -> " + vertex);
    }

//    private HashSet<Integer> hashTable = new HashSet<>();
//    public int findRootReferrerId(int actorId){
//        if (hashTable.contains(actorId)) return actorId;
//        hashTable.add(actorId);
//        int referrerId =
//                select referrer_id
//
//    }
}