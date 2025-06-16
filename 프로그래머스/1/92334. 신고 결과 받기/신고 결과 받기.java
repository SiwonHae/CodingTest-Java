import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> cntMap = new HashMap<>();
        
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
        }
        
        for (String rep : report) {
            String[] splitReport = rep.split(" ");
            String from = splitReport[0];
            String to = splitReport[1];
            
            reportMap.get(from).add(to);
        }
        
        for (Set<String> reported : reportMap.values()) {
            for (String id : reported) {
                cntMap.put(id, cntMap.getOrDefault(id, 0) + 1);
            }
        }
        
        Set<String> blocked = new HashSet<>();
        for (String id : cntMap.keySet()) {
            if (cntMap.get(id) >= k) {
                blocked.add(id);
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            Set<String> reported = reportMap.get(id);
            
            int mailCnt = 0;
            for (String userId : reported) {
                if (blocked.contains(userId)) {
                    mailCnt++;
                }
            }
            
            answer[i] = mailCnt;
        }
        
        return answer;
    }
}