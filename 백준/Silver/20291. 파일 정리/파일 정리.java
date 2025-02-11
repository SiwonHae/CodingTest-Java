import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] file = br.readLine().split("\\.");
            String name = file[0];
            String exe = file[1];

            map.put(exe, map.getOrDefault(exe, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + " " + map.get(list.get(i)) + "\n");
        }

        bw.flush();
    }
}