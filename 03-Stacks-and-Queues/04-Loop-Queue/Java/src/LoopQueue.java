public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front) resize(2 * getCapacity());

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // 使用取余形式，实现 front ！= 0 的情况下，当 front + 1 越过 data.length - 1 的时候，
            // 能够回到数组开头（ps：求余的作用就在这，类似于时钟），继续数组中的元素，直到遇到tail。
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        if(isEmpty()) throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        return data[front];
    }

    @Override
    public E deQueue() {
        if(isEmpty()) throw new IllegalArgumentException("Cannot dequeue from an empty queue");

        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity()/4 && getCapacity()/2 != 0) resize(getCapacity()/2);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue: size=%d , capacity=%d", size, getCapacity()));
        result.append("frort [");
        for (int i = front; i != tail; i = (i+1) % data.length) {
            result.append(data[i]);
            if((i+1) % data.length != tail) result.append(", ");
        }
        result.append("] tail");
        return result.toString();

    }
}
