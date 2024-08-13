import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] time;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[200001];

        if (N == K) {
            cnt++;
            bw.write(time[K] + "\n");
            bw.write(cnt + "\n");
            bw.flush();
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = 0;

                if (i == 0) {
                    next = current - 1;
                } else if (i == 1) {
                    next = current + 1;
                } else {
                    next = current * 2;
                }

                if (next >= 0 && next <= 100000) {
                    if (time[next] == 0 || time[next] >= time[current] + 1) {
                        time[next] = time[current] + 1;
                        queue.add(next);

                        if (next == K) {
                            cnt++;
                        }
                    }
                }
            }
        }

        bw.write(time[K] + "\n");
        bw.write(cnt + "\n");
        bw.flush();
    }
}
