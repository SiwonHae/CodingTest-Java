import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] dist;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        
        dist = new int[N + 1];
        Arrays.fill(dist, -1);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        bfs(1);
        
        int cnt = 0;
        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == max && !flag) {
                bw.write(i + " " + dist[i]);
                flag = true;
                cnt++;
            } else if (dist[i] == max) {
                cnt++;
            }
        }
        
        bw.write(" " + cnt);
        bw.flush();
    }
    
    public static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dist[start] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : adjList.get(current)) {
                if (dist[next] != -1) {
                    continue;
                }
                
                queue.offer(next);
                dist[next] = dist[current] + 1;
                max = Math.max(max, dist[next]);
            }
        }
    }
}