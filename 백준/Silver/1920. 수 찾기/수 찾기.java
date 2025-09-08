import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int result = Arrays.binarySearch(A, num);
            if (result >= 0) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        
        bw.flush();
    }
}