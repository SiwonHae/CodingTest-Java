class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            
            // i개 단위로 자른다.
            String prev = s.substring(0, i);
            int cnt = 1;
            
            for (int j = i; j < s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length());
                String current = s.substring(j, endIdx);
                
                if (prev.equals(current)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(prev);
                    
                    prev = current;
                    cnt = 1;
                }
            }
            
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(prev);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}