import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        if (N == K) {
            bw.write("0");
            bw.flush();
            return;
        }

        dist = new int[100001];
        Arrays.fill(dist, -1);
        
        bw.write(String.valueOf(bfs(N)));
        bw.flush();
    }

    public static int bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next < 0 || next >= 100001) {
                    continue;
                }

                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;

                    if (next == K) {
                        return dist[next];
                    }

                    queue.offer(next);
                }
            }
        }

        return -1;
    }
}