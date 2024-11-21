import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(list);

        long max = Long.MIN_VALUE;

        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                max = Math.max(max, list.get(i) + list.get(N - i - 1));
            }
        } else {
            max = list.get(N - 1);
            for (int i = 0; i < N / 2; i++) {
                max = Math.max(max, list.get(i) + list.get(N - i - 2));
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}