public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    } 

    private Node dummyhead; // 使用虚拟头结点优化代码
    private int size;

    public LinkedList(){
        dummyhead = new Node(null, null);
        size = 0;
    }

    // 返回链表中元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    // 在链表头添加新的0元素e
    public void addFirst(E e){
        // Node node = new Node(e);
        // node.next = head;
        // head = node;
        // 三句代码简化成一句
        // head = new Node(e, head);
        // size++;
        add(0, e);
    }

    // 在链表 index 位置插入元素 e
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyhead;

        // 我的思考【ps：这里需要稍加思考一下，很容易就忘记了 20190621】：我们要找到插入位置之前【即 index -1 】的那个节点，
        // i < index : 本来这样 for 循环会走 index 次，导致prev指向 index 位置
        // 但由于头结点是一个虚拟的节点， 忽略掉的话，prev 实际就是在 index - 1 的位置，也就是插入位置之前的节点。
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }

        // Node node = new Node(E);
        // node.next = prev.next;
        // prev.next = node;
        prev.next = new Node(e, prev.next);

        size++;
    }

    // 在链表末尾添加元素 e
    public void addLast(E e){
        add(size, e);
    }

    // 获取 index 位置的元素
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("GET failed. Illegal index.");
        }

        Node cur = dummyhead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    // 修改链表中 index 位置的元素
    public void set(int index, E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("GET failed. Illegal index.");
        }

        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表中是够存在元素 e
    public boolean contains(E e){
        Node cur = dummyhead.next;
        while(cur != null){
            if(cur.e.equals(e)) return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        Node cur = dummyhead.next;
        while(cur != null){
            result.append(cur + "->");
            cur = cur.next;
        }
        result.append("null");

        return result.toString();
    }
}