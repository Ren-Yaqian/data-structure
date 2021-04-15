package hashtablev1;

// key 不允许重复
public class MyHashTable {
    // 1. 维护数组(元素类型是链表）
    private Node[] array;
    // 2. 有效元素个数
    private int size;

    private int hashFunction(int key) {
        if (key < 0) {
            throw new RuntimeException("不支持 key < 0。");
        }
        return key % array.length;
    }

    public void insert(int key) {
        // 1. 找到下标
        // 2. 判断是否存在（key 不能重复）
        // 3. 插入到链表中（头插/尾插都行）
        int index=hashFunction(key);
        for(Node cur=array[index];cur!=null;cur=cur.next){
            if(cur.key==key){
                throw new RuntimeException("key重复");
            }
        }
        Node node=new Node(key);
        node.next=array[index];
        array[index]=node;

        size++;
    }

    public boolean remove(int key) {
        // 1. 找到下标
        // 2. 在链表中找到对应的结点删除
        int index=hashFunction(key);
        if(array[index]==null){
            return false;
        }
        if(array[index].key==key){
            array[index]=array[index].next;
            size--;
            return true;
        }
        Node prev=array[index];
        while(prev.next!=null){
            if(prev.next.key==key){
                prev.next=prev.next.next;
                return true;
            }
        }
        return false;
    }

    // 平均: O(1)  最坏: O(n)
    public boolean find(int key) {
        // 1. 根据哈希函数，计算出合法下标
        int index = hashFunction(key);

        // 2. 在 array[index] 这条链表中，遍历查找 key 是否存在
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return true;
            }
        }

        return false;
    }
}
