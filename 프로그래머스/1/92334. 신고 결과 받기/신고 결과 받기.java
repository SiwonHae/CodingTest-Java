import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> idMap = new HashMap<>();
        // 이름 : 인덱스 번호
        // muzi : 0
        // frodo : 1
        // apeach : 2
        // neo : 3

        Map<String, HashSet<String>> reportInfo = new HashMap<>();
        // 신고 당한 이름 : 신고한 사람 이름
        // muzi : {appeach} -> 무지를 신고한 사람이 appeach임.

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            idMap.put(name, i);
            reportInfo.put(name, new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            String reporter = report[i].split(" ")[0];
            String target = report[i].split(" ")[1];
            reportInfo.get(target).add(reporter);
        }

        for (String key : reportInfo.keySet()) {
            if (reportInfo.get(key).size() >= k) {
                for (String id : reportInfo.get(key)) {
                    answer[idMap.get(id)]++;
                }
            }
        }


        return answer;
    }
}