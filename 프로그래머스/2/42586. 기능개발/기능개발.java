import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int endDay = 0;
            int restProgress = 100 - progresses[i];
            if (restProgress % speeds[i] != 0) {
                endDay = restProgress / speeds[i] + 1;
            } else {
                endDay = restProgress / speeds[i];
            }
            list.add(endDay);
        }

        List<Integer> result = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        for (int i = 0; i < list.size(); i++) {
            if (stack.isEmpty()) {
                stack.add(list.get(i));
            } else {
                if (stack.peek() < list.get(i)) {
                    stack.pop();
                    stack.push(list.get(i));
                    result.add(cnt);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
        }

        if (!stack.isEmpty()) {
            result.add(cnt);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}