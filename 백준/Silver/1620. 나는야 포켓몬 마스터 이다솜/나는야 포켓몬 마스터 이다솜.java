import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String , Integer> map2 = new HashMap<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            map1.put(i + 1, name);
            map2.put(name, i + 1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (Character.isDigit(cmd.charAt(0))) {
                bw.write(map1.get(Integer.parseInt(cmd))+ "\n");
            } else {
                bw.write(map2.get(cmd) + "\n");
            }

        }

        bw.flush();
    }
}
