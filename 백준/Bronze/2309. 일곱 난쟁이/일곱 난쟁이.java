import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
            sum += list.get(i);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - list.get(i) - list.get(j) == 100) {
                    list.set(i, 0);
                    list.set(j, 0);
                    Collections.sort(list);
                    for (int k = 2; k < list.size(); k++) {
                        bw.write(list.get(k) + "\n");
                    }
                    bw.flush();
                    return;
                }
            }
        }
    }
}
