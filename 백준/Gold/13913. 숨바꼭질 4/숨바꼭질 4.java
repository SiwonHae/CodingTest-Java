import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] time;
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[200001];
        path = new int[200001];

        Arrays.fill(time, -1);

        if (N == K) {
            bw.write(0 + "\n" + K + "\n");
            bw.flush();
            return;
        }

        bfs();

        bw.write(time[K] + "\n");

        Stack<Integer> stack = new Stack<>();
        for (int i = K; i != N; i = path[i]) {
            stack.push(i);
        }

        stack.push(N);

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.flush();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        time[N] = 0;

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

                if (next >= 0 && next <= 100000 && time[next] == -1) {
                    time[next] = time[current] + 1;
                    path[next] = current;
                    queue.add(next);

                    if (next == K) {
                        return;
                    }
                }
            }
        }
    }
}
