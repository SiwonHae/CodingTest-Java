import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            int compare = Character.compare(s1.charAt(n), s2.charAt(n));
            
            if (compare == 0) {
                return s1.compareTo(s2);
            }
            
            return compare;
        });
        
        return strings;
    }
}