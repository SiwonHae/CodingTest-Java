import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> m1 = new HashMap<>();
        Map<Integer, String> m2 = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            m1.put(name, i + 1);
            m2.put(i + 1, name);
        }

        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();

            if (Character.isLetter(cmd.charAt(0))) {
                bw.write(m1.get(cmd) + "\n");
            } else {
                bw.write(m2.get(Integer.parseInt(cmd)) + "\n");
            }
        }

        bw.flush();
    }
}