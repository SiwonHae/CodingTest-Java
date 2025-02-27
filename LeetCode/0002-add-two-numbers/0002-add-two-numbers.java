/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 리스트 l1을 역순으로 바꾼 정수값과 l2를 역순으로 바꾼 정수값을 더한다.
        // 그리고 그 더한값을 역순으로 한 자릿수 씩 리스트로 반환한다.

        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);

        char[] sum = String.valueOf(toBigInteger(r1).add(toBigInteger(r2))).toCharArray();

        ListNode prev = null;
        ListNode node = null;

        for (int i = 0; i < sum.length; i++) {
            char c = sum[i];
            
            node = new ListNode(Character.getNumericValue(c));
            node.next = prev;
            prev = node;
        }

        return node;
    }

    public ListNode reverseList(ListNode l) {
        ListNode prev = null;
        ListNode node = l;
        while (node != null) {
            ListNode next = node.next;

            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    public BigInteger toBigInteger(ListNode l) {
        StringBuilder sb = new StringBuilder();

        while (l != null) {
            sb.append(l.val);
            l = l.next;
        }

        return new BigInteger(sb.toString());
    }
}