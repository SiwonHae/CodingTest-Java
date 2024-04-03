import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // A B C D
        // 2 1 3 2
        // C D A B 순서로 실행됨.

        List<Integer> queue = new LinkedList<>();
        for (int i : priorities) {
            queue.add(i);
        }

        while (location >= 0) {

            int max = Collections.max(queue);

            int process = queue.get(0); // 제일 앞을 꺼낸다.
            queue.remove(0);

            if (process >= max) {
                location--;
                answer++;

                if (location < 0) {
                    break;
                }
            } else {
                queue.add(process);
                location--;
                if (location < 0) {
                    location = queue.size() - 1;
                }
            }
        }


        return answer;
    }
}