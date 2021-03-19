package 力扣21;

public class ListNode {
    public int val; // 元素
    public ListNode next;   // 指向下一个结点对象
    // next == null，代表链表的最后一个结点

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
