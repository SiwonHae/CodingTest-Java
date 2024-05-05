import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리의 길이 bridge_length 만큼 지나가야 다리를 건너는 것.
        // 다리에 올라갈 수 있는 트럭 무게합은 weight 이하

        int answer = 0;

        int currentWeight = 0;
        int time = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            int currentTruck = truck_weights[i];

            while (true) {
                if (queue.isEmpty()) { // 다리에 트럭이 비어 있는 경우
                    queue.add(currentTruck);
                    currentWeight += currentTruck;
                    time++;
                    break;
                } else if (queue.size() == bridge_length) { // 트럭이 다리를 건넌 경우
                    currentWeight -= queue.poll();
                } else { // 트럭이 건너고 있는 경우
                     if (currentWeight + currentTruck <= weight) { // 다리가 무게를 견딜 수 있는 경우
                        queue.add(currentTruck);
                        currentWeight += currentTruck;
                        time++;
                        break;
                    } else {
                        // 다리의 무게가 견디지 못할 경우
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        answer = time + bridge_length;

        return answer;
    }
}