import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            // 맵의 사이즈 => 의상의 종류
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int result = 1;
            for (int cnt : map.values()) {
                result *= (cnt + 1);
            }
            result--;

            bw.write(result + "\n");
        }

        bw.flush();
    }
}
