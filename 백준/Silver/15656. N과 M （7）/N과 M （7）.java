import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] seq;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        seq = new int[N];
        arr = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(seq);
        
        backtrack(0);
        
        bw.write(sb.toString());
        bw.flush();
    }
    
    public static void backtrack(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            arr[depth] = seq[i];
            backtrack(depth + 1);
        }
    }
}