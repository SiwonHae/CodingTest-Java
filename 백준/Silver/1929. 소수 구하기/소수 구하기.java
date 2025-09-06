import java.io.*;
import java.util.*;

public class Main {
    static boolean[] primeState;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        primeState = new boolean[N + 1];
        
        sieve(N);
        
        for (int i = M; i <= N; i++) {
            if (primeState[i]) {
                bw.write(String.valueOf(i));
                bw.write("\n");
            }
        }
        
        bw.flush();
    }
    
    public static void sieve(int n) {
        Arrays.fill(primeState, true);
        primeState[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (!primeState[i]) {
                continue;
            }
            
            for (int j = i * i; j <= n; j += i) {
                primeState[j] = false;
            }
        }
    }
}