import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> kindMap = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                kindMap.put(kind, kindMap.getOrDefault(kind, 0) + 1);
            }

            int result = 1;
            for (int cnt : kindMap.values()) {
                result *= (cnt + 1);
            }
            result--;

            bw.write(result + "\n");
        }

        bw.flush();
    }
}
