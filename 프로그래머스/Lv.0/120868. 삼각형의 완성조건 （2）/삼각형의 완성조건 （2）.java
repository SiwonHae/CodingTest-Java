class Solution {
    public int solution(int[] sides) {
        int answer = 0;

        int maxLine = Math.max(sides[0], sides[1]);
        int otherLine = Math.min(sides[0], sides[1]);

        int longer = maxLine + otherLine;
        int shorter = maxLine - otherLine;
        
        answer = longer - shorter - 1;

        return answer;
    }
}