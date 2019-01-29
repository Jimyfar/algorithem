//package map;
//
//import java.util.LinkedList;
//
//public class Graph {
//    private LinkedList<Edge> adj[];
//    private int v;
//
//    public Graph(int v) {
//        this.v = v;
//        this.adj = new LinkedList[v];
//        for (int i = 0; i < v; i++) {
//            this.adj[i] = new LinkedList<>();
//        }
//    }
//
//    public void addEdge(int s, int t, int w) {
//        this.adj[s].add(new Edge(s, t, w));
//    }
//
//    private class Edge {
//        public int sid;
//        public int tid;
//        public int w;
//
//        public Edge(int sid, int tid, int w) {
//            this.sid = sid;
//            this.tid = tid;
//            this.w = w;
//        }
//    }
//
//    private class Vertex {
//        public int id;
//        public int dist;
//
//        public Vertex(int id, int dist) {
//            this.id = id;
//            this.dist = dist;
//        }
//    }
//
//    private class PriorityQueue {
//        private Vertex[] nodes;
//        private int count;
//
//        public PriorityQueue(int v) {
//            this.nodes = new Vertex[v + 1];
//            this.count = v;
//        }
//
//        public Vertex poll() {
//
//        }
//
//        public void add(Vertex vertex) {
//
//        }
//
//        public void update(Vertex vertex) {
//
//        }
//
//        public boolean isEmpty() {
//
//        }
//    }
//
//    public void dijkstra(int s, int t) {
//        int[] predecessor = new int[this.v];
//        Vertex[] vertexs = new Vertex[this.v];
//        for (int i = 0; i < this.v; i++) {
//            vertexs[i] = new Vertex(i, Integer.MAX_VALUE);
//        }
//        PriorityQueue queue = new PriorityQueue(this.v);
//        boolean[] inqueue = new boolean[this.v];
//        vertexs[s].dist = 0;
//        queue.add(vertexs[s]);
//        inqueue[s] = true;
//        while (!queue.isEmpty()) {
//            Vertex minVertex = queue.poll();
//            if (minVertex.id == t) break;
//            for (int i = 0; i < adj[minVertex.id].size(); i++) {
//                Edge e = adj[minVertex.id].get(i);
//                Vertex nextVertex = vertexs[e.tid];
//                if (minVertex.dist + e.w < nextVertex.dist) {
//                    nextVertex.dist = minVertex.dist + e.w;
//                    predecessor[nextVertex.id] = minVertex.id;
//                    if (inqueue[nextVertex.id] == true) {
//                        queue.update(nextVertex);
//                    } else {
//                        queue.add(nextVertex);
//                        inqueue[nextVertex.id] = true;
//
//                }
//            }
//        }
//        System.out.print(s);
//        print(s, t, predecessor);
//
//    }
//
//    public void print(int s, int t, int[] predecessor) {
//        if (s == t) return;
//        print(s, predecessor[t], predecessor);
//    }
