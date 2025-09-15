import java.io.*;
import java.util.*;

public class Main {
    static int[] A;
    static int[] B;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
           
            A = new int[N];
            B = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            
            int result = 0;
            
            Arrays.sort(B);
            
            for (int a : A) {
                result += binarySearch(a); // a보다 작은 B의 개수를 더한다.
            }
            
            bw.write(result + "\n");
        }
        
        bw.flush();
    }
    
    public static int binarySearch(int target) {
        int start = 0;
        int end = M - 1;
        int cnt = 0;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (B[mid] < target) {
                cnt = mid + 1;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return cnt;
    }
}