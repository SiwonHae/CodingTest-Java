import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Integer> inputList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            inputList.add(num);
            list.add(num);
        }

        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(list.get(i))) {
                continue;
            }
            map.put(list.get(i), idx++);
        }

        for (int i = 0; i < n; i++) {
            bw.write(map.get(inputList.get(i)) + " ");
        }

        bw.flush();
    }
}
