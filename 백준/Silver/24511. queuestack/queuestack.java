import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        
        int[] C = new int[M];
        st = new StringTokenizer(br.readLine()); 
        for (int i = 0; i < M; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                queue.addLast(B[i]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int value : C) {
            queue.addFirst(value);
            sb.append(queue.pollLast() + " ");
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}