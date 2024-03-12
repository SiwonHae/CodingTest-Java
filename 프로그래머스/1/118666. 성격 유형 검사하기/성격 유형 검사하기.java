import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for (int i = 0; i < survey.length; i++) {
            String[] s = survey[i].split("");
            int select = choices[i];

            if (select < 4) {
                int currentCnt = map.get(s[0]);
                if (select == 1) {
                    currentCnt += 3;
                } else if (select == 2) {
                    currentCnt += 2;
                } else {
                    currentCnt += 1;
                }
                map.put(s[0], currentCnt);
            } else if (select > 4) {
                int currentCnt = map.get(s[1]);
                if (select == 5) {
                    currentCnt += 1;
                } else if (select == 6) {
                    currentCnt += 2;
                } else {
                    currentCnt += 3;
                }
                map.put(s[1], currentCnt);
            }
        }

        String[] kind = {"R", "T", "C", "F", "J", "M", "A", "N"};

        for (int i = 0; i < map.size(); i += 2) {
            if (map.get(kind[i]) > map.get(kind[i + 1]) || map.get(kind[i]) == map.get(kind[i + 1])) {
                answer += kind[i];
            } else {
                answer += kind[i + 1];
            }
        }

        return answer;
    }
}