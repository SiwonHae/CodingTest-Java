import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> adjList;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        
        parent = new int[N + 1];
        
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        bfs(1);
        
        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }
        
        bw.flush();
    }
    
    public static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : adjList.get(current)) {
                if (parent[current] == next) {
                    continue;
                }
                
                parent[next] = current;
                queue.offer(next);
            }
        }
        
    }
}