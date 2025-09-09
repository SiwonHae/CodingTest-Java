import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            int absNum1 = Math.abs(n1);
            int absNum2 = Math.abs(n2);
            
            if (absNum1 == absNum2) {
                return Integer.compare(n1, n2);
            }
            
            return Integer.compare(absNum1, absNum2);
        });
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.offer(x);
            }
        }

        bw.flush();
    }
}