import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        // 9999면 2세트를 사면 된다. 6을 9로 뒤집을 수 있어서.
        // 6과 9를 동일하게 취급하자. 9를 6으로 전부 바꾸자. 1세트에 6이 2개 들어있다. 1~8까지.
        N = N.replaceAll("9", "6");

        int[] needs = new int[10];
        for (int i = 0; i < N.length(); i++) {
            needs[N.charAt(i) - '0']++;
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 6) {
                result = Math.max(result, needs[i]);
            }
        }
        result = Math.max(result, (needs[6] + 1) / 2);

        bw.write(String.valueOf(result));
        bw.flush();
    }
}