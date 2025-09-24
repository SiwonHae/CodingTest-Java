import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[K];
        long maxLen = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxLen = Math.max(maxLen, arr[i]);
        }
        
        long start = 1;
        long end = maxLen;
        while (start < end) {
            long mid = (start + end + 1) / 2;
            
            long current = 0;
            for (int i = 0; i < K; i++) {
                current += arr[i] / mid;
            }
            
            if (current >= N) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        
        bw.write(String.valueOf(start));
        bw.flush();
    }
}