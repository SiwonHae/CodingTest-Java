import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;


        // 모든 음식의 스코빌이 K 이상이 되도록 섞는다.
        // 가장 낮은 스코빌 + (그 다음 낮은 스코빌 * 2)
        // 섞기 때문에 가장 낮은 스코빌 음식, 그 다음 낮은 스코빌 음식 삭제
        // 섞은 스코빌 음식 추가.

        // 우선 순위 큐를 사용하면 가장 작은 원소가 head에 온다.
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : scoville) {
            priorityQueue.add(i);
        }

        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() < 2) {
                return -1;
            }
            
            int food = priorityQueue.poll();
            food += (priorityQueue.poll() * 2);
            answer++;
            priorityQueue.add(food);
        }

        return answer;
    }
}