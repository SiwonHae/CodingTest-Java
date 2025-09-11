import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<List<Node>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int cnt, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[V + 1];
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            adjList.get(A).add(new Node(B, C));
            adjList.get(B).add(new Node(A, C));
        }
        
        prim();
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
    
    public static void prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.weight, b.weight);
        });
        visited[1] = true;
        
        for (Node next : adjList.get(1)) {
            pq.offer(new Edge(1, next.to, next.weight));
        }
        
        while (!pq.isEmpty() && cnt < V - 1) {
            Edge current = pq.poll();
            int from = current.from;
            int to = current.to;
            int weight = current.weight;
            
            if (visited[to]) {
                continue;
            }
            
            result += weight;
            visited[to] = true;
            cnt++;
            
            for (Node next : adjList.get(to)) {
                if (!visited[next.to]) {
                    pq.offer(new Edge(current.to, next.to, next.weight));
                }
            }
        }
    }
    
    static class Edge {
        int from;
        int to;
        int weight;
        
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    
    static class Node {
        int to;
        int weight;
        
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}