public class 力扣201 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.next.val!=val) {
                cur = cur.next;
            }else {
                cur.next=cur.next.next;
            }
        }
        if(head.val==val){
            return head.next;
        }
        return head;
    }
}
