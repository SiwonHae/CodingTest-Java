import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Long> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (key1, key2) -> {
            if (map.get(key1).equals(map.get(key2))) {
                return Long.compare(key1, key2);
            }
            return Integer.compare(map.get(key2), map.get(key1));
        });

        bw.write(String.valueOf(keys.get(0)));
        bw.flush();
    }
}