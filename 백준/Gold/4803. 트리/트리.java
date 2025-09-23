import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int caseNum = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            if (n == 0 && m == 0) {
                break;
            }
        
            adjList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
            
                adjList.get(a).add(b);
                adjList.get(b).add(a);
            }
            
            visited = new boolean[n + 1];
            int treeNum = 0;
            
            for (int i = 1; i <= n; i++) {
                if (bfs(i)) {
                    treeNum++;
                }
            }
            
            bw.write("Case " + caseNum + ": ");
            if (treeNum == 0) {
                bw.write("No trees.\n");
            } else if (treeNum == 1) {
                bw.write("There is one tree.\n");
            } else {
                bw.write("A forest of " + treeNum + " trees.\n");
            }
            
            caseNum++;
        }

        bw.flush();
    }
    
    public static boolean bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        
        int vertexCnt = 0;
        int edgeCnt = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            vertexCnt++;
            
            for (int next : adjList.get(current)) {
                edgeCnt++;
                
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        
        return edgeCnt == (vertexCnt - 1) * 2;
    }
}