import java.util.*;

class Solution {

    public int solution(int[] elements) {
        int answer = 0;

        int n = elements.length;
        // 원형 수열을 두 배 길이의 배열로 확장
        int[] sequence = new int[2 * n];
        for (int i = 0; i < n; i++) {
            sequence[i] = elements[i];
            sequence[i + n] = elements[i];
        }

        Set<Integer> set = new HashSet<>();

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < start + n; end++) {
                sum += sequence[end];
                set.add(sum);
            }
        }

        answer = set.size();
        return answer;
    }
}