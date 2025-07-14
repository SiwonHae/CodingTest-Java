import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int cursor = 0;
        List<Integer> result = new ArrayList<>();

        while (list.size() > 0) {
            cursor = (cursor + K - 1) % list.size();

            int removed = list.remove(cursor);
            result.add(removed);
        }

        bw.write("<");
        for (int i = 0; i < result.size(); i++) {
            bw.write(String.valueOf(result.get(i)));
            if (i < result.size() - 1) {
                bw.write(", ");
            }
        }
        bw.write(">");

        bw.flush();
    }
}