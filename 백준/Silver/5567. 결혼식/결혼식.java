import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] dist;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        dist = new int[n + 1];
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        bfs(1);
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
    
    public static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dist[start] = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (dist[current] > 2) {
                continue;
            }
            
            for (int next : adjList.get(current)) {
                if (dist[next] > 0) {
                    continue;
                }
                
                queue.offer(next);
                dist[next] = dist[current] + 1;
                result++;
            }
        }
    }
}