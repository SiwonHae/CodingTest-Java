import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            Deque<Paper> queue = new ArrayDeque<>();
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.offer(new Paper(i, Integer.parseInt(st.nextToken())));
            }
            
            int cnt = 0;
            
            while (!queue.isEmpty()) {
                Paper current = queue.poll();
                boolean flag = false;
                
                for (Paper paper : queue) {
                    if (paper.score > current.score) {
                        flag = true;
                        break;
                    }
                }
                
                if (flag) {
                    queue.offer(current);
                } else {
                    cnt++;
                    if (current.idx == M) {
                        bw.write(cnt + "\n");
                        break;
                    }
                }
            }
        } 
        
        bw.flush();
    }
    
    static class Paper {
        int idx;
        int score;
        
        public Paper(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }
}