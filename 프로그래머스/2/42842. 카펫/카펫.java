class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 3; i <= 5000; i++) {
            for (int j = 3; j <= i; j++) {
                int brownCnt = i * 2 + (j - 2) * 2;
                int yelloCnt = i * j - brownCnt;
                
                if (brown == brownCnt && yellow == yelloCnt) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}