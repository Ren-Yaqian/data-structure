public class 力扣206反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
                pre=cur;
                cur=next;
                }
                return pre;
        }
    }

