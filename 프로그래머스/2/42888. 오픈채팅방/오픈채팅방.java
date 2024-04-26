import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        // "명령 아이디 닉네임"

        List<String> idList = new ArrayList<>();
        List<String> cmdList = new ArrayList<>();
        Map<String, String> infoMap = new HashMap<>(); // 아이디, 닉네임

        for (int i = 0; i < record.length; i++) {
            String[] log = record[i].split(" ");

            String cmd = log[0];
            String id = log[1];
            String nickname = "";

            if (cmd.equals("Enter")) {
                nickname = log[2];
                idList.add(id);
                cmdList.add(cmd);
                infoMap.put(id, nickname);
            } else if (cmd.equals("Leave")) {
                idList.add(id);
                cmdList.add(cmd);
            } else if (cmd.equals("Change")) {
                nickname = log[2];
                infoMap.put(id, nickname);
            }
        }

        String[] answer = new String[idList.size()];

        for (int i = 0; i < idList.size(); i++) {
            String id = idList.get(i);
            String nickname = infoMap.get(id);

            if (cmdList.get(i).equals("Enter")) {
                answer[i] = nickname + "님이 들어왔습니다.";
            } else if (cmdList.get(i).equals("Leave")) {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}