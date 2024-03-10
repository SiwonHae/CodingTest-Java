import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        // 1:빵, 2:야채, 3:고기
        // 1 2 3 1 이여야 1개 포장
        
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i : ingredient) {
            list.add(i);
            // 리스트의 마지막 4개의 요소가 1, 2, 3, 1인지 확인
            if (list.size() >= 4) {
                int size = list.size();
                if (list.get(size - 4) == 1 && list.get(size - 3) == 2 && list.get(size - 2) == 3 && list.get(size - 1) == 1) {
                    for (int j = 0; j < 4; j++) {
                        list.remove(list.size() - 1);
                    }
                    answer++;
                }
            }
        }

        return answer;
    }
}

