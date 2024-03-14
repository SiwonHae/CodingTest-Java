import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        Map<String ,Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            // callings[i] 의 등수 -1
            // callings[i] 의 바로 앞 선수는 callings[i]의 등수 - 1의 value를 가진 key임

            int currentRank = map.get(callings[i]);

            // 바로 앞 선수 찾기
            String frontPlayer = players[currentRank - 1];

            players[currentRank - 1] = callings[i];
            players[currentRank] = frontPlayer;

            map.put(callings[i], currentRank - 1);
            map.put(frontPlayer, currentRank);
        }

        answer = players;
        
        return answer;
    }
}