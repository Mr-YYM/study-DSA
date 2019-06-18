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

    // 返回数组的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size==0;
    }

    // 在所有元素的末尾插入一个元素    
    public void addLast(int e){
        // if(size==data.length){
        //     throw new IllegalArgumentException("AddLast failed. Array id full");
        // }
        // data[size] = e;
        // size++;
        add(size, e);
    }

    // 在数组开头插入一个元素
    public void addFirst(int e){
        add(0, e);
    }

    // 在数组指定的位置插入一个元素
    public void add(int index, int e){
        if(size == data.length){
            throw new IllegalArgumentException("AddLast failed. Array id full");
        }
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index>=0 and index <= size");
        }
        for(int i=size; i>index; i--){
            data[i] = data[i-1];
        }
        // for(int i=size-1; i>=index; i--){
        //     data[i+1] = data[i];
        // }
        data[index] = e;
        size++;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array: size=%d, capacity=%d\n", size, data.length));
        result.append('[');
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if(i!=size-1) result.append(", ");
        }
        result.append(']');
        return result.toString();
    }
}
