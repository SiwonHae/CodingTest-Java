import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        int avg = sum / 5;

        bw.write(avg + "\n" + list.get(2));
        bw.flush();
    }
}
