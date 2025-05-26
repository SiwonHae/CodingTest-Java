import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Deque<Balloon> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.addLast(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!deque.isEmpty()) {
            Balloon current = deque.pollFirst();
            
            sb.append(current.idx + " ");
            
            if (deque.isEmpty()) {
                break;
            }
            
            int moveIdx = current.value;
            
            if (moveIdx > 0) {
                for (int i = 0; i < moveIdx - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < -moveIdx; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }       
        
        bw.write(sb.toString());
        bw.flush();
    }
    
    static class Balloon {
        int idx;
        int value;
        
        public Balloon(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}