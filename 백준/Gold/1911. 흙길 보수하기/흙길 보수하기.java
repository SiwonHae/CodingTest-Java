import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] pools = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pools[i][0] = start;
            pools[i][1] = end;
        }

        Arrays.sort(pools, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int result = 0;
        int lastPos = 0;

        for (int[] pool : pools) {
            int start = pool[0];
            int end = pool[1];

            if (lastPos < start) {
                lastPos = start;
            }

            if (lastPos < end) {
                int remain = end - lastPos;
                int need = (remain + L - 1) / L;

                result += need;
                lastPos += need * L;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}