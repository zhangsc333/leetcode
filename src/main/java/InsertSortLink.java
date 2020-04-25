public class InsertSortLink {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return  head;
        }
        ListNode iTail = head;
        while(iTail != null && iTail.next != null){
            ListNode temp = iTail.next;
            ListNode secStart = temp.next;
            iTail.next = null;
            temp.next = null;
            ListNode iHead = head;
            while(iHead.next != null){
                if(iHead.val <= temp.val && iHead.next.val >= temp.val){
                    temp.next = iHead.next;
                    iHead.next = temp;
                    break;
                }
                if(temp.val < head.val){
                    temp.next = head;
                    head = temp;
                    break;
                }
                iHead = iHead.next;
            }
            if(iTail == head && temp.val < head.val){
                temp.next = head;
                head = temp;
            }
            if(temp.next == null){
                iTail.next = temp;
                iTail = temp;
            }
            iTail.next = secStart;
        }
        return head;
    }
}
