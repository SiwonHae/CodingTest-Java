class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int targetLen = p.length();
        long target = Long.parseLong(p);
        
        for (int i = 0; i < t.length() - targetLen + 1; i++) {
            long n = Long.parseLong(t.substring(i, i + targetLen));
            if (n <= target) {
                answer++;
            }
        }
        
        return answer;
    }
}