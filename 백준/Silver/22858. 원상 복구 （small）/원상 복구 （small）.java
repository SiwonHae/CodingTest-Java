import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        while (cnt != K) {
            int[] tmp = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                tmp[D[i]] = S[i];
            }
            S = tmp;

            cnt++;
        }

        for (int i = 1; i <= N; i++) {
            bw.write(S[i] + " ");
        }

        bw.flush();
    }
}