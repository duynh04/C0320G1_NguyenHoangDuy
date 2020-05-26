package P6Collections.baitap.fullLinkedList.fullList;

import java.util.ArrayList;
import java.util.Arrays;

public class FullList<E> implements Cloneable{
    int size = 0;
    static  final int DEFAULT_CAPACITY = 10;
    private  Object[] elementData;

    public FullList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public FullList(int intitalCapacity) throws Exception {
        if (intitalCapacity > 0)
            this.elementData = new Object[intitalCapacity];
        else
            throw new Exception("Invalid input capacity.");
    }
    private void grow() {
        int newSize = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newSize);
    }
    public int size () {
        return size;
    }
    public int indexOf (E data) {
        for (int i = 0; i < this.elementData.length;i++) {
            if (this.elementData[i] == data) {
                return i + 1;
            }
        }
        return -1;
    }
    public boolean contains (E data) {
        return indexOf(data) != -1;
    }
    public void clear() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }
    public void add(E e) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = e;
    }
    public void add (int index,E data) {
        if (size == elementData.length) {
            grow();
        }
        Object[] tempArray = new Object[elementData.length + 1];
        System.arraycopy(elementData,0,tempArray,0,index-1);
        tempArray[index-1] = data;
        System.arraycopy(elementData,index-1,tempArray,index,elementData.length - (index-1));
        elementData = tempArray;
        size++;
    }
    public void remove (int index) {
        Object[] tempArray = new Object[elementData.length - 1];
        System.arraycopy(this.elementData,0,tempArray,0,index-1);
        System.arraycopy(this.elementData,index,tempArray,index-1,this.elementData.length - index);
        this.elementData = tempArray;
    }
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elementData[i];
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public void print () {
        for (Object value : this.elementData) {
            if (value != null) {
                System.out.println(value);
            }
        }
    }
}
