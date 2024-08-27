import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Meet> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meet(start, end));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }

            return o1.end - o2.end;
        });

        int result = 0;

        int end = 0;
        for (int i = 0; i < N; i++) {
            Meet m = list.get(i);

            // 종료 시간이 다음 회의 시작 시간 보다 작다면 회의 시작 가능!
            if (end <= m.start) {
                end = m.end;
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

class Meet {
    int start;
    int end;

    public Meet(int start, int end) {
        this.start = start;
        this.end = end;
    }
}