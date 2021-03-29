package 牛客链表的回文结构;

//import base.ListNode;

public class Solution {
    public boolean chkPalindrome(ListNode A) {
        ListNode middle = getMiddle(A);
        ListNode reverseHead = reverseList(middle);

        ListNode curA = A;
        ListNode curB = reverseHead;
        while (curA != null && curB != null) {
            if (curA.val != curB.val) {
                return false;
            }
            
            curA = curA.next;
            curB = curB.next;
        }
        
        return true;
    }

    private ListNode reverseList(ListNode middle) {//反转
        ListNode prev=null;
        ListNode cur=middle;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;

    }


    private ListNode getMiddle(ListNode a) {//中间节点

        int len = 0;
        for (ListNode cur = a; cur != null; cur = cur.next) {
            len++;
        }

        ListNode cur = a;
        for (int i = 0; i < len / 2; i++) {
            cur = cur.next;
        }
        return cur;
    }

}
