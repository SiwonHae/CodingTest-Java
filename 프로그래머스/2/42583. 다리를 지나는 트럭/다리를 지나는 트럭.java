import java.util.*;

class Truck {
    int weight;
    int position;

    Truck(int weight, int position) {
        this.weight = weight;
        this.position = position;
    }
}

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Truck> bridge = new LinkedList<>();
        
        int totalWeight = 0;
        int idx = 0;

        while (idx < truck_weights.length || !bridge.isEmpty()) {
            answer++;

            if (!bridge.isEmpty() && bridge.peek().position > bridge_length) {
                totalWeight -= bridge.poll().weight;
            }

            if (idx < truck_weights.length && totalWeight + truck_weights[idx] <= weight) {
                bridge.add(new Truck(truck_weights[idx], 1));
                totalWeight += truck_weights[idx];
                idx++;
            }

            for (Truck truck : bridge) {
                truck.position++;
            }
        }
        
        return answer;
    }
}