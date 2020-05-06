//Given a singly linked list L: L 0→L 1→…→L n-1→L n,
//        reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
//        You must do this in-place without altering the nodes' values.
//
//        For example,
//        Given{1,2,3,4}, reorder it to{1,4,2,3}.

public class ReorderList {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public class Solution {
        public void reorderList(ListNode head) {
            if(head == null){
                return;
            }
            ListNode middle = head;
            ListNode tail = head;
            while (tail.next != null && tail.next.next != null){
                middle = middle.next;
                tail = tail.next.next;
            }
            ListNode head2 = middle.next;
            middle.next = null;
            ListNode head3 = reverse(head2);
            ListNode then1 = head3;
            ListNode then2;
            while(head != null){
                then2 = head.next;
                head.next = then1;
                head = head.next;
                then1 = then2;
            }

        }
        private ListNode reverse(ListNode head){
            ListNode temp = null;
            while(head != null){
                ListNode me = head;
                head = me.next;
                me.next = temp;
                temp = me;
            }
            return head = temp;
        }
    }

}
