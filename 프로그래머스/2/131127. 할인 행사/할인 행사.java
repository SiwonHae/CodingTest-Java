import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length; i++) {
            boolean isBuy = true;
            Map<String, Integer> currentMap = new HashMap<>();
            for (int j = 0; j < want.length; j++) {
                currentMap.put(want[j], 0);
            }
            
            for (int j = i; j < discount.length; j++) { // 수정된 부분
                currentMap.put(discount[j], currentMap.getOrDefault(discount[j], 0) + 1);
                if (j - i == 9) // 10일 동안의 할인 정보를 추적합니다.
                    break;
            }

            for (int j = 0; j < want.length; j++) {
                if (wantMap.get(want[j]) > currentMap.get(want[j])) {
                    isBuy = false;
                    break;
                }
            }

            if (isBuy) {
                answer++;
            }

        }

        return answer;
    }
}