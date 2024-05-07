class Solution {
    public int[] solution(long n) {

        String s = String.valueOf(n);
        char[] cArr = s.toCharArray();

        int[] answer = new int[cArr.length];
        
        int idx = cArr.length - 1;
        for (int i = 0; i < cArr.length; i++) {
            answer[i] = Integer.parseInt(String.valueOf(cArr[idx--]));
        }
        
        return answer;
    }
}