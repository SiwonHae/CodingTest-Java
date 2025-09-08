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
            bw.write(String.valueOf(binarySearch(num)));
            bw.newLine();
        }
        
        bw.flush();
    }
    
    public static int binarySearch(int target) {
        int start = 0;
        int end = N - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] < target) {
                start = mid + 1;
            } else if (A[mid] > target) {
                end = mid - 1;
            } else {
                return 1;
            }
        }
        
        return 0;
    }
}