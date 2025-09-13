import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int start, end;
    static int INF = 1000000000;
    static int[] dist;
    static int[] prev;
    static List<List<Edge>> adjList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());


        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        prev = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(u).add(new Edge(v, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        bw.write(dist[end] + "\n");
        List<Integer> path = new ArrayList<>();
        int current = end;
        while (current != start) {
            path.add(current);
            current = prev[current];
        }
        path.add(current);

        Collections.reverse(path);

        bw.write(path.size() + "\n");
        for (int x : path) {
            bw.write(x + " ");
        }

        bw.flush();
    }

    public static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.weight, b.weight);
        });

        dist[start] = 0;
        pq.offer(new Edge(start, dist[start]));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int to = current.to;
            int weight = current.weight;

            if (dist[to] != weight) {
                continue;
            }

            for (Edge next : adjList.get(to)) {
                int nTo = next.to;
                int nWeight = next.weight;

                if (dist[nTo] <= dist[to] + nWeight) {
                    continue;
                }

                dist[nTo] = dist[to] + nWeight;
                pq.offer(new Edge(nTo, dist[nTo]));
                prev[nTo] = to;
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