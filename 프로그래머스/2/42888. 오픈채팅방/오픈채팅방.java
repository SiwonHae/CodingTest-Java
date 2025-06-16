import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>(); // 유저 아이디와 닉네임
        
        for (String cmds : record) {
            String[] cmd = cmds.split(" ");
            String action = cmd[0];
            
            if (action.equals("Enter") || action.equals("Change")) {
                String userId = cmd[1];
                String nickname = cmd[2];
                map.put(userId, nickname);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String cmds : record) {
            String[] cmd = cmds.split(" ");
            String action = cmd[0];
            String userId = cmd[1];
            
            if (action.equals("Enter")) {
                result.add(map.get(userId) + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                result.add(map.get(userId) + "님이 나갔습니다.");
            }
        }
        
        return result.toArray(new String[0]); 
    }
}