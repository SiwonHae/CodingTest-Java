import java.io.*;
import java.util.*;

public class Main {
    static int N, mp, mf, ms, mv;
    static int[][] board;
    static int minCost = Integer.MAX_VALUE;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        board = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0, 0, 0, new ArrayList<>());


        if (minCost == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(minCost + "\n");
            for (int i : result) {
                bw.write(i + " ");
            }
        }

        bw.flush();
    }

    public static void dfs(int index, int tp, int tf, int ts, int tv, int cost, List<Integer> selected) {
        if (tp >= mp && tf >= mf && ts >= ms && tv >= mv) {
            if (cost < minCost || (cost == minCost && compareList(selected, result))) {
                minCost = cost;
                result = new ArrayList<>(selected);
            }
        }

        if (index == N) {
            return;
        }

        selected.add(index + 1);
        dfs(index + 1, tp + board[index][0], tf + board[index][1], ts + board[index][2], tv + board[index][3], cost + board[index][4], selected);
        selected.remove(selected.size() - 1);

        dfs(index + 1, tp, tf, ts, tv, cost, selected);
    }

    static boolean compareList(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
}