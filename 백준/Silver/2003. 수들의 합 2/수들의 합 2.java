import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0;
        int end = 0;
        int tmp = 0;
        int result = 0;
        
        while (true) {
            if (tmp >= M) {
                if (tmp == M) {
                    result++;
                }
                tmp -= arr[start++];
            } else {
                if (end == N) {
                    break;
                }
                tmp += arr[end++];
            }
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
}