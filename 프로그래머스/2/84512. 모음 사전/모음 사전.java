class Solution {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static int answer = 0;
    static boolean flag = false;
    
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    private void dfs(String current, String target) {
        if (flag) {
            return;
        }
        
        if (current.length() > 0) {
            answer++;
            
            if (current.equals(target)) {
                flag = true;
                return;
            }
        }
        
        if (current.length() >= 5) {
            return;
        }
        
        for (char vowel : vowels) {
            dfs(current + vowel, target);
        }
    }
}