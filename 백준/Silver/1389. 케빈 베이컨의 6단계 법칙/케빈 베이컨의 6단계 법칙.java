import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        for (int i = 1; i <= N; i++) {
            nums[i] = bfs(i);
        }
        
        for (int i = 1; i <= N; i++) {
            if (nums[i] == min) {
                bw.write(String.valueOf(i));
                break;
            }
        }
        bw.flush();
    }
    
    public static int bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        
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
            }
        }
        
        int sum = 0;
        for (int x : dist) {
           sum += x; 
        }
        
        min = Math.min(min, sum);
        
        return sum;
    }
}