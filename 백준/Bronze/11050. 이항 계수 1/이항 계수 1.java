import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int result = 1;
        
        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        
        for (int i = 1; i <= K; i++) {
            result /= i;
        }
        
        for (int i = 1; i <= N - K; i++) {
            result /= i;
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
}