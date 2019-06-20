import javax.swing.*;

public class Array<E> {

    private E[] data;
    private int size;

    // 构造函数，传入数组的容量 capacity 构造 Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
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
    public void addLast(E e){
        add(size, e);
    }

    // 在数组开头插入一个元素
    public void addFirst(E e){
        add(0, e);
    }

    // 在数组指定的位置插入一个元素
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index>=0 and index <= size");
        }
        if(size == data.length){
            resize(2*data.length); // 从实际应用上分析，扩容应当增加与数组容量相同数量级，而不应该扩容一个常数。
        }

        for(int i=size; i>index; i--){
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    // 获取 index 索引位置的元素
    E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    E getFirst(){
        return get(0);
    }

    E getLast(){
        return get(size-1);
    }

    // 修改 index 索引位置的元素
    void set(int index, E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        data[index] = e;
    }

    // 判断数组中是否存在元素e
    public boolean contains(int e){
        for (E t: data) {
            if(t.equals(e)) return true;
        }
        return false;
    }

    // 在数组中查找元素e，如果元素e不存在则返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) return i;
        }
        return -1;
    }

    // 从数组中删除 index 索引位置的元素，并返回删除的元素
    public E remove(int index){
        if(index < 0 || index >=size){
            throw new IllegalArgumentException("Remove failed. Invalid index.");
        }
        E ret = data[index];
        for(int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
//        data[size] = null; // loitering objects!
        if(size==data.length/2) resize(data.length/2);
        return ret;
    }

    // 删除数组的第一个元素
    public E removeFirst(){
        return remove(0);
    }

    // 删除数组中最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1) remove(index);
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

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
