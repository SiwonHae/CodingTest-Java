import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        // 0 1 3 5 6
        // 0회 이상 인용된 논문의 수 : 5개, 나머지 0편의 논문은 0회 이하 인용됨.
        // 1회 이상 인용된 논문의 수 : 4개, 나머지 1편의 논문은 1회 이하 인용됨.
        // 3회 이상 인용된 논문의 수 : 3개, 나머지 2편의 논문은 3회 이하 인용됨.
        // 5회 이상 인용된 논문의 수 : 2개, 나머지 3편의 논문은 5회 이하 인용됨.
        // 6회 이상 인용된 논문의 수 : 1개, 나머지 4편의 논문은 6회 이하 인용됨.


        for (int i = 0; i < citations.length; i++) {
            int hIndex = citations.length - i; // i 번째 인용된 논문 보다 더 많이 인용된 논문의 수

            if (citations[i] >= hIndex) {
                answer = hIndex;
                break;
            }
        }

        return answer;
    }
}