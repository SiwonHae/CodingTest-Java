import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Problem> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.add(new Problem(deadline, value));
        }

        Collections.sort(list, (o1, o2) -> {
            return o1.deadline - o2.deadline;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Problem p : list) {
            if (pq.size() < p.deadline) {
                pq.offer(p.value);
            } else if (!pq.isEmpty() && pq.peek() < p.value) {
                pq.poll();
                pq.offer(p.value);
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    static class Problem {
        int deadline;
        int value;

        public Problem(int deadline, int value) {
            this.deadline = deadline;
            this.value = value;
        }
    }
}