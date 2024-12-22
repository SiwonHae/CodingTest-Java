import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        List<Integer> reserveList = new ArrayList<>();
        for (int i : reserve) {
            reserveList.add(i);
        }

        List<Integer> lostList = new ArrayList<>();
        for (int i : lost) {
            if (reserveList.contains(i)) {
                reserveList.remove((Integer) i);
                answer++;
            } else {
                lostList.add(i);
            }
        }
       
        for (int lostNum : lostList) {
            for (int j = 0; j < reserveList.size(); j++) {
                int reserveNum = reserveList.get(j);
                if (reserveNum - 1 == lostNum || reserveNum + 1 == lostNum) {
                    answer++;
                    reserveList.remove(j);
                    break;
                }
            }
        }
        
        return answer;
    }
}