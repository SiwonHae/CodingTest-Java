import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // k개 귤 포장할 때 사이즈 다른 귤이 최소가 되도록.

        Arrays.sort(tangerine);
        Map<Integer, Integer> map = new HashMap<>();
        // Key : 귤 사이즈, Value : 해당 귤의 개수

        for (int i = 0; i < tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                int currentCnt = map.get(tangerine[i]);
                map.put(tangerine[i], currentCnt + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (sum >= k) {
                break;
            }

            sum += list.get(i);
            answer++;
        }

        return answer;
    }
}