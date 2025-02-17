import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("\\W+");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            boolean flag = true;

            for (String ban : banned) {
                if (ban.equals(word)) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                continue;
            }

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println(map);

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> map.get(o2) - map.get(o1));

        return keySet.get(0);
    }
}