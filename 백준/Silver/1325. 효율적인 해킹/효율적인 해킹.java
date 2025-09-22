import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int[] nums;
    static boolean[] visited;
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
            
            adjList.get(b).add(a);
        }
        
        for (int i = 1; i <= N; i++) {
            nums[i] = bfs(i);
            max = Math.max(max, nums[i]);
        }
        
        for (int i = 1; i <= N; i++) {
            if (nums[i] == max) {
                bw.write(i + " ");
            }
        }
        
        bw.flush();
    }
    
    public static int bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;
        
        int sum = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : adjList.get(current)) {
                if (visited[next]) {
                    continue;
                }
                
                queue.offer(next);
                visited[next] = true;
                sum++;
            }
        }
        
        return sum;
    }
}