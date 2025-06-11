import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n + 2];
        int[] next = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        Deque<Integer> deleted = new ArrayDeque<>(); // 삭제된 행의 인덱스를 보관하는 스택
        
        k++;
        
        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.push(k);
                prev[next[k]] = prev[k];
                next[prev[k]] = next[k];
                k = n < next[k] ? prev[k] : next[k];
            } else if (c.startsWith("Z")) {
                int restore = deleted.pop();
                next[prev[restore]] = restore;
                prev[next[restore]] = restore;
            } else {
                String[] command = c.split(" ");
                int x = Integer.parseInt(command[1]);
                
                for (int i = 0; i < x; i++) {
                    k = command[0].equals("U") ? prev[k] : next[k];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for (int i : deleted) {
            answer[i - 1] = 'X';
        }
        
        return new String(answer);
    }
}