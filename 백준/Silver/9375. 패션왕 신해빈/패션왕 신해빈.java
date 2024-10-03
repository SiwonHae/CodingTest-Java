import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            Map<String, Integer> map = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int result = 1;
            for (int value : map.values()) {
                result *= value + 1;
            }

            bw.write(String.valueOf(result - 1) + "\n");
        }

        bw.flush();
    }
}