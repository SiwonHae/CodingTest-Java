import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // A B C D
        // 2 1 3 2
        // C D A B 순서로 실행됨.

        // 내림차순으로 우선순위 큐 만듬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : priorities) {
            pq.offer(i);
        }
        // 3 2 2 1 로 저장됨

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    pq.poll();
                    answer++;

                    if (i == location) {
                        return answer;
                    }
                }
            }
        }


        return answer;
    }
}
