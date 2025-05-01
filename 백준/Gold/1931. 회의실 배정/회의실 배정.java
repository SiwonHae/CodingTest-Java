import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }

            return o1.end - o2.end;
        });

        int result = 0;
        int lastEndTime = 0;

        for (Meeting meeting : list) {
            if (meeting.start >= lastEndTime) {
                result++;
                lastEndTime = meeting.end;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}