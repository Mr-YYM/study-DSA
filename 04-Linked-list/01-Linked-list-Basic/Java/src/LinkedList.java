public class LinkedList<E> {

    private class Node{
        public E data;
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

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
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
        head = new Node(e, head);
        size++;
    }

    // 在链表 index 位置插入元素 e
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if(index == 0){
            addFirst(e);
        }
        else{
            Node prev = head;
            for(int i = 0; i < index - 1; i++){
                prev = prev.next;
            }

            // Node node = new Node(E);
            // node.next = prev.next;
            // prev.next = node;
            prev.next = new Node(e, prev.next);

            size++;
        }
    }

    // 在链表末尾添加元素 e
    public void addLast(E e){
        add(size, e);
    }

}