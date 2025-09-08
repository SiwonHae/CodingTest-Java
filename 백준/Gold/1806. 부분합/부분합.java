import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int sum = seq[0];
        
        while (start < N) {
            while (end < N && sum < S) {
                end++;
                if (end != N) {
                    sum += seq[end];
                }
            }
            
            if (end == N) {
                break;
            }
            
            min = Math.min(min, end - start + 1);
            sum -= seq[start];
            
            start++;
        }
        
        if (min == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(min));
        }
        bw.flush();
    }
}