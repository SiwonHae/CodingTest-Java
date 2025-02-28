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
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode current = node;
        node.next = head;



        while (node.next != null && node.next.next != null) {
            ListNode a = node.next; // 다음 노드
            ListNode b = node.next.next; // 다음 다음 노드

            // 0(임시 노드) -> 1 -> 2 -> 3 에서 1(a)은 3을 가리켜야 함.
            a.next = b.next;

            // 현재 노드의 다음 노드는 다음 다음 노드를 가리킨다.
            node.next = b; 

            // 현재 노드의 다음 다음 노드는 바로 그 이전 노드를 가리킨다.
            node.next.next = a;

            node = node.next.next;
        }

        return current.next;
    }
}