import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] str = br.readLine().split("");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            list.add(Integer.parseInt(str[i]));
        }

        Collections.sort(list, Collections.reverseOrder());

        for (Integer i : list) {
            bw.write(String.valueOf(i));
        }

        bw.flush();
    }
}
