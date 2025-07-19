import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int result = 0;

        for (int i = 0; i < M; i++) {
            int pick = Integer.parseInt(st.nextToken());

            int targetIdx = 0;
            for (int num : deque) {
                if (num == pick) {
                    break;
                }
                targetIdx++;
            }

            int left = targetIdx;
            int right = deque.size() - targetIdx;
            int min = Math.min(left, right);

            result += min;

            if (left <= right) { // 왼쪽으로 이동
                for (int j = 0; j < left; j++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else { // 오른쪽으로 이동
                for (int j = 0; j < right; j++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
            deque.poll();
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}