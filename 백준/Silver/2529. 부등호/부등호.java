import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static char[] arr;
    static boolean[] visited;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            char input = st.nextToken().charAt(0);
            arr[i] = input;
        }

        dfs("", 0);

        Collections.sort(list);

        bw.write(list.get(list.size() - 1) + "\n" + list.get(0));
        bw.flush();
    }

    public static void dfs(String num, int depth) {

        if (depth == k + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }

            if (depth == 0 || isValid(num.charAt(depth - 1) - '0', i, arr[depth - 1])) {
                visited[i] = true;
                dfs(num + i, depth + 1);
                visited[i] = false; // 원복
            }
        }
    }

    public static boolean isValid(int a, int b, char op) {
        if (op == '<') {
            if (a > b) {
                return false;
            }
        } else {
            if (a < b) {
                return false;
            }
        }

        return true;
    }
}
