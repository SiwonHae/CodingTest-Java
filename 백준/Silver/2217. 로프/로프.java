import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> rope = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            rope.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(rope, Collections.reverseOrder());

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, rope.get(i) * (i + 1));
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}