import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (list.size() != N) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }

            list.add(queue.poll());
        }

        bw.write("<");
        for (int i = 0; i < list.size() - 1; i++) {
            bw.write(list.get(i) + ", ");
        }
        bw.write(list.get(list.size() - 1) + ">");

        bw.flush();
    }
}