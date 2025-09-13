import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static int INF = 1000000000;
    static int[] dist;
    static List<List<Edge>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(u).add(new Edge(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }

        bw.flush();
    }

    public static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.weight, b.weight);
        });

        dist[K] = 0;
        pq.offer(new Edge(K, dist[K]));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int to = current.to;
            int weight = current.weight;

            if (dist[to] != weight) {
                continue;
            }

            for (Edge next : adjList.get(to)) {
                if (dist[next.to] <= dist[to] + next.weight) {
                    continue;
                }

                dist[next.to] = dist[to] + next.weight;
                pq.offer(new Edge(next.to, dist[next.to]));
            }
        }
    }

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}