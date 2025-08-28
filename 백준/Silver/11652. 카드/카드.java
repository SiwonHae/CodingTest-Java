import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        int cnt = 0;
        long maxValue = -(1L << 62) - 1;
        int maxCnt = 0;

        for (int i = 0; i < N; i++) {
            if (i == 0 || arr[i - 1] == arr[i]) {
                cnt++;
            } else {
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    maxValue = arr[i - 1];
                }
                cnt = 1;
            }
        }

        if (cnt > maxCnt) {
            maxCnt = cnt;
            maxValue = arr[N - 1];
        }

        bw.write(String.valueOf(maxValue));
        bw.flush();
    }
}