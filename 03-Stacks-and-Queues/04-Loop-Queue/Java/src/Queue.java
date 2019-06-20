public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enQueue(E e);
    E getFront();
    E deQueue();
}
