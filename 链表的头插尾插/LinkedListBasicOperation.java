package 链表的头插尾插;

public class LinkedListBasicOperation {

    public static Node pushFront(Node head, int val) {
        // 1. 把元素 val 装入结点中
        Node node = new Node(val);
        node.next = head;
        return node;
    }

//    头删
    public static Node popFront(Node head) {
        // head != null

        return head.next;
    }

//
    private static void printLinkedList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

//    尾插
    private static Node pushBack(Node head, int val) {
        Node node = new Node(val);
        if (head != null) {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;

            return head;
        } else {
            return node;//返回头节点
        }
    }

//    尾删

    private static Node popback(Node head,int val) {
        if(head.next==null){
            return null;
        }else{
            Node last=head;
            while(last.next.next!=null){
                last=last.next;
            }
            last.next=null;
            return head;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        head = pushBack(head, 1);
        head = pushBack(head, 2);
        head = pushBack(head, 3);

        printLinkedList(head);
        head = popback(head,1);
    }
}
