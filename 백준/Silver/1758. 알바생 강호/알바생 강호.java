import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        long result = 0;
        for (int i = 0; i < N; i++) {
            int tip = list.get(i) - i;
            if (tip > 0) {
                result += tip;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}