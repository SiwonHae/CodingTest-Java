import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        dist = new int[F + 1];
        Arrays.fill(dist, -1);
        
        int result = bfs(S);
        
        if (result != -1) {
            bw.write(String.valueOf(result));
        } else {
            bw.write("use the stairs");
        }
        
        bw.flush();
    }
    
    public static int bfs(int start) {
        if (start == G) {
            return 0;
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dist[start] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            int[] move = {current + U, current - D};
            for (int next : move) {
                if (next < 1 || next > F) {
                    continue;
                }
                
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    
                    if (next == G) {
                        return dist[next];
                    }
                    
                    queue.offer(next);
                }
            }
        }
        
        return -1;
    }
}