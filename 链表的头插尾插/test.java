package 链表的头插尾插;
//头插
public class test {
    public static Node pushFront(Node head,int val){
        Node node=new Node(val);
        node.next=head;
        return node;
    }
//头删
    public static Node popFront(Node head,int val){
        return head.next;
    }
//尾插
    public static Node pushBack(Node head,int val){
        Node node=new Node(val);
        if(head!=null){
            Node last=head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=node;
            return last;
        }else {
            return node;
        }
    }
    //尾删
    public static Node popBack(Node head,int val){
        if(head!=null){

        }
        return head;
    }

    public static void main(String[] args) {

    }
}
