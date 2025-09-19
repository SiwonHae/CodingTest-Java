import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            
            PriorityQueue<Long> pq = new PriorityQueue<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            
            long cost = 0;
            while (pq.size() >= 2) {
                long f1 = pq.poll();
                long f2 = pq.poll();
                long tmp = f1 + f2;
                pq.offer(tmp);
                
                cost += tmp;
            }
            
            bw.write(cost + "\n");
        }
        
        bw.flush();
    }
}