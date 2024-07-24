import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n - k + 1; i++) {
            int start = i;
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[start];
                start++;
            }
            max = Math.max(max, sum);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}
