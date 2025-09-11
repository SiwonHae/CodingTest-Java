import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        indegree = new int[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            adjList.get(A).add(B);
            indegree[B]++;
        }
        
        bfs();
        
        bw.write(sb.toString());
        bw.flush();
    }
    
    public static void bfs() {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");
            for (int next : adjList.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}