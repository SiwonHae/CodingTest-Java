import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] pSum = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            pSum[i] = pSum[i - 1] + temp;
        }
        
        int result = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            result = Math.max(result, pSum[i] - pSum[i - K]);
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
}