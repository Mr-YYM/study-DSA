public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(5);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enQueue(E e) {
        array.addLast(e);
    }

    @Override
    public E deQueue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("【Queue】size：%d  capacity：%d \n", array.getSize(), array.getCapacity()));
        result.append("Front [");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if(i != array.getSize()-1) result.append(", ");
        }
        result.append("] tail");
        return result.toString();
    }
}
