import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] scores;
    static int minScore = Integer.MAX_VALUE;
    static List<Integer> candidates = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        scores = new int[n + 1];
        
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (a == -1 && b == -1) {
                break;
            }
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        for (int i = 1; i <= n; i++) {
            scores[i] = bfs(i);
            minScore = Math.min(minScore, scores[i]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }
        
        bw.write(minScore + " " + candidates.size() + "\n");
        for (int candidate : candidates) {
            bw.write(candidate + " ");
        }
        bw.flush();
    }
    
    public static int bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        queue.offer(start);
        dist[start] = 0;
        int score = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : adjList.get(current)) {
                if (dist[next] != -1) {
                    continue;
                }
                
                dist[next] = dist[current] + 1;
                score = Math.max(score, dist[next]);
                queue.offer(next);
            }
        }
        
        return score;
    }
}