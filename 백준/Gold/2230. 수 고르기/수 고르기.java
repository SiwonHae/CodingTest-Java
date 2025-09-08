import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(A);
        
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        
        while (start < N) {
            while (end < N && A[end] - A[start] < M) {
                end++;
            }
            
            if (end == N) {
                break;
            }
            
            min = Math.min(min, A[end] - A[start]);
            start++;
        }
        
        bw.write(String.valueOf(min));
        bw.flush();
    }
}