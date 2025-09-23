import java.io.*;
import java.util.*;

public class Main {
    static int N, R, Q;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] subtreeSize;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            
            adjList.get(U).add(V);
            adjList.get(V).add(U);
        }
        
        dfs(R);
        
        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            bw.write(subtreeSize[U] + "\n");
        }
        
        bw.flush();
    }
    
    public static void dfs(int node) {
        visited[node] = true;
        subtreeSize[node] = 1;
        
        for (int child : adjList.get(node)) {
            if (!visited[child]) {
            dfs(child);
            subtreeSize[node] += subtreeSize[child];
            }
        }
    }
}