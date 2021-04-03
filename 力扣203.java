public class 力扣203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }
            cur=cur.next;
        }
        if(head.val==val){
            return head.next;
        }
        return head;
    }
}
