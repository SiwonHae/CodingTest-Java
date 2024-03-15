import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, HashMap<String, Integer>> giftMap = new HashMap<>();
        Map<String, Integer> giftIndexMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        Set<String> nameSet = new HashSet<>();

        for (String s : friends) {
            giftMap.put(s, new HashMap<>());
            giftIndexMap.put(s, 0);
            resultMap.put(s, 0);
        }

        for (int i = 0; i < gifts.length; i++) {
            String sender = gifts[i].split(" ")[0]; // 준 사람
            String receiver = gifts[i].split(" ")[1]; // 받은 사람

            int sendCnt = giftIndexMap.get(sender);
            giftIndexMap.put(sender, sendCnt + 1);

            int receiveCnt = giftIndexMap.get(receiver);
            giftIndexMap.put(receiver, receiveCnt - 1);

            if (giftMap.get(sender).containsKey(receiver)) {
                giftMap.get(sender).put(receiver, giftMap.get(sender).get(receiver) + 1);
            } else {
                giftMap.get(sender).put(receiver, 1);
            }
        }

        for (int i = 0; i < friends.length; i++) {
            nameSet.add(friends[i]);

            for (int j = 0; j < friends.length; j++) {
                if (!nameSet.contains(friends[j])) {
                    // 주고 받은 선물 수가 같을 때
                    if (giftMap.get(friends[i]).getOrDefault(friends[j], 0) == giftMap.get(friends[j]).getOrDefault(friends[i], 0)) {
                        // 선물 지수 비교한다.
                        if (giftIndexMap.get(friends[i]) > giftIndexMap.get(friends[j])) {
                            int currentCnt = resultMap.get(friends[i]);
                            resultMap.put(friends[i], currentCnt + 1);
                        } else if (giftIndexMap.get(friends[i]) < giftIndexMap.get(friends[j])) {
                            int currentCnt = resultMap.get(friends[j]);
                            resultMap.put(friends[j], currentCnt + 1);
                        }
                    } else {
                        // 주고 받은 선물 수를 비교하자
                        if (giftMap.get(friends[i]).getOrDefault(friends[j], 0) > giftMap.get(friends[j]).getOrDefault(friends[i], 0)) {
                            int currentCnt = resultMap.get(friends[i]);
                            resultMap.put(friends[i], currentCnt + 1);
                        } else {
                            int currentCnt = resultMap.get(friends[j]);
                            resultMap.put(friends[j], currentCnt + 1);
                        }
                    }
                }
            }
        }

        int max = resultMap.get(friends[0]);
        for (int i = 0; i < resultMap.size(); i++) {
            max = Math.max(max, resultMap.get(friends[i]));
        }

        answer = max;

        return answer;
    }
}