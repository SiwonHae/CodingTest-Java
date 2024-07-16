import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> input = new HashMap();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            input.put(num, input.getOrDefault(num, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < m; i++) {
            Integer num = input.get(Integer.parseInt(st.nextToken()));

            if (num == null) {
                bw.write("0 ");
            } else {
                bw.write(num + " ");
            }
        }

        bw.flush();
    }
}
