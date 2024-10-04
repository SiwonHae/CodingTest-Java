import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);

            // 3의 배수 중 가장 각 자릿수가 모두 1인 가장 작은 수 111

            int target = 1;
            int result = 1;
            while (target % num != 0) {
                target = (target * 10 + 1) % num;
                result++;
            }

            bw.write(String.valueOf(result) + "\n");
        }

        bw.flush();
    }
}