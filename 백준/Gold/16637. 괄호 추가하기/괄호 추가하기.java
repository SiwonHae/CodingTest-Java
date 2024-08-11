import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> numList = new ArrayList<>();
    static List<Character> operList = new ArrayList<>();
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String expr = br.readLine();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                numList.add(c - '0');
            } else {
                operList.add(c);
            }
        }

        dfs(0, numList.get(0));

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int idx, int num) {
        if (idx == numList.size() - 1) {
            result = Math.max(result, num);
            return;
        }

        // 괄호 X
        dfs(idx + 1, calc(num, numList.get(idx + 1), operList.get(idx)));

        // 괄호 O
        if (idx + 2 <= numList.size() - 1) {
            int tmp = calc(numList.get(idx + 1), numList.get(idx + 2), operList.get(idx + 1));
            dfs(idx + 2, calc(num, tmp, operList.get(idx)));
        }
    }

    public static int calc(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a- b;
        } else {
            return a * b;
        }
    }
}
