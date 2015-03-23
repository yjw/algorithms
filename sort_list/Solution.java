public class Solution {
    ListNode
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int step = 2;
        while(get_end(head, step) != null) {
            ListNode curr_head = head;
            ListNode curr_mid = get_end(curr_head, step);
            ListNode curr_tail = get_end(curr_head, step);
            while (curr_mid != null) {
                merge()
            }
        }
        
    }
    
    private ListNode get_mid(ListNode head, int step) {
        step /= 2;
        while (step > 0 && head != null) {
            step--;
            head = head.next;
        }
        return head;
    }
    
    private ListNode get_end(ListNode head, int step) {
        while (step > 0 && head != null) {
            step--;
            head = head.next;
        }
        return head;
    }
}
