public class Array {

    private int[] data;
    private int size;

    // 构造函数，传入数组的容量 capacity 构造 Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参数构造函数，默认容量等于 10
    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size==0;
    }
}
