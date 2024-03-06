import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] last = new int[N + 1]; // 각 단계에 도전 중인 플레이어 수(인덱스 : 단계 번호)
        int[] total = new int[N + 1]; // 스테이지에 도달한 플에이어의 수(인덱스 : 단계 번호)
        for (int i = 0; i < stages.length; i++) {
            int cnt = 0;
            last[stages[i] - 1]++;
            while (cnt != stages[i]) {
                total[cnt]++;
                cnt++;
            }
        }

        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            // 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
            if (last[i] == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) last[i] / total[i]);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for (int i = 0; i < keySet.size(); i++) {
            answer[i] = keySet.get(i) + 1;
        }

        return answer;
    }
}