import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            boolean isValid = true;
            String s = str1.substring(i, i + 2);

            for (int j = 0; j < s.length(); j++) {
                if (!Character.isLetter(s.charAt(j))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                s = s.toLowerCase();
                s1.add(s);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            boolean isValid = true;
            String s = str2.substring(i, i + 2);

            for (int j = 0; j < s.length(); j++) {
                if (!Character.isLetter(s.charAt(j))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                s = s.toLowerCase();
                s2.add(s);
            }
        }

        List<String> tempS1 = List.copyOf(s1);
        List<String> tempS2 = List.copyOf(s2);

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        // 교집합 : A와 B에 공통으로 존재하는 원소
        // 합집합 : A + B - A ∩ B
        for (String s : s1) {
            if (s2.remove(s)) {
                intersection.add(s);
            }
            
            union.add(s);
        }
        
        for (String s : s2) {
            union.add(s);
        }

        if (intersection.size() == 0 && union.size() == 0) {
            answer = 65536;
            return answer;
        }

        double j = (double) intersection.size() / union.size();
        answer = (int) (65536 * j);

        return answer;
    }
}