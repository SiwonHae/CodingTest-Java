import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Problem> list = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            list.add(new Problem(deadline, cnt));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.deadline == o2.deadline) {
                return o2.cnt - o1.cnt;
            }

            return o1.deadline - o2.deadline;
        });

        int result = 0;

        for (int i = 0; i < N; i++) {
            int deadline = list.get(i).deadline;
            int cnt = list.get(i).cnt;

            result += cnt;

            pq.add(cnt);
            if (pq.size() > deadline) {
                result -= pq.poll();
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

class Problem {
    int deadline;
    int cnt;

    public Problem(int deadline, int cnt) {
        this.deadline = deadline;
        this.cnt = cnt;
    }
}
