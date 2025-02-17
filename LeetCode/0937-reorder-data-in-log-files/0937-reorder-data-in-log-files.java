import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (String s : logs) {
            String[] sp = s.split(" ");

            if (Character.isDigit(sp[1].charAt(0))) {
                digits.add(s);
            } else {
                letters.add(s);
            }
        }

        Collections.sort(letters, (o1, o2) -> {
            String[] logs1 = o1.split(" ", 2);
            String[] logs2 = o2.split(" ", 2);

            // Contents가 같으면 ID 순서로 정렬한다.
            if (logs1[1].compareTo(logs2[1]) == 0) {
                return logs1[0].compareTo(logs2[0]);
            } else {
                return logs1[1].compareTo(logs2[1]);
            }
        });

        String[] result = new String[logs.length];
        for (int i = 0; i < letters.size(); i++) {
            result[i] = letters.get(i);
        }

        int idx = letters.size();
        for (int i = 0; i < digits.size(); i++) {
            result[idx++] = digits.get(i);
        }

        return result;
    }
}