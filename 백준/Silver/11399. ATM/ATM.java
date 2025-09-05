import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] P = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        // 돈 인출이 가장 빨리 끝나는 사람이 먼저 처리하자.
        Arrays.sort(P);
        
        int sum = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i];
            result += sum;
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
}