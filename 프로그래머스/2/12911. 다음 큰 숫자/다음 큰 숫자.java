class Solution {
    public int solution(int n) {
        int answer = 0;

        // Integer.bitCount(n) 은 n을 이진수로 변환해서 1의 개수를 반환한다.
        int cntN = Integer.bitCount(n);

        int num = n + 1;
        while (true) {
            int cntNum = Integer.bitCount(num);

            if (cntN == cntNum) {
                answer = num;
                break;
            }
            
            num++;
        }

        return answer;
    }
}