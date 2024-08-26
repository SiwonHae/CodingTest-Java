import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.pay == o2.pay) {
                return o2.day - o1.day;
            }

            return o2.pay - o1.pay;
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            pq.add(new Lecture(pay, day));
        }

        boolean[] visited = new boolean[10001];
        int result = 0;

        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();

            for (int i = lecture.day; i > 0; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    result += lecture.pay;
                    break;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

class Lecture {
    int pay;
    int day;

    public Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

}
