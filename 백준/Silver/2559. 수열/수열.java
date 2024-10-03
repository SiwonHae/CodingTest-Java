import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N - K + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + K; j++) {
                sum += a[j];
            }

            result = Math.max(result, sum);
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}