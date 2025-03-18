import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            
            map.put(from, map.getOrDefault(from, new PriorityQueue<>()));
            map.get(from).add(to);
        }
        
        List<String> answer = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        
        stack.push("ICN");
        while (!stack.isEmpty()) {
            while (map.containsKey(stack.getFirst()) && !map.get(stack.getFirst()).isEmpty()) {
                stack.push(map.get(stack.getFirst()).poll());
            }
            
            answer.add(0, stack.pop());
        }
        
        return answer.toArray(new String[0]);
    }
}