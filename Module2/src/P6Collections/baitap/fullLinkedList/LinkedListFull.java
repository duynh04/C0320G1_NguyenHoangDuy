package P6Collections.baitap.fullLinkedList;


public class LinkedListFull<T> implements Cloneable {
    private Node<T> head;
    private int size;
    public LinkedListFull() {
        size = 0;
    }
    public LinkedListFull(T data) {
        head = new Node<>(data);
        this.size++;
    }
    public int getSize() {
        return  size;
    }
    public void addFirst(T data) {
        Node<T> current = head;
        head = new Node<>(data);
        head.next = current;
        size++;
    }
    public void addLast(T data) {
        Node<T> current = head;
        if (head == null) {
            addFirst(data);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(data);
            size++;
        }
    }
    public void add(int position, T data) {
        Node<T> current = head;
        Node<T> holder;
        int prePos = 1;
        if (position == 1 || head == null) {
            addFirst(data);
        } else {
            while (current.next != null && prePos < position - 1) {
                prePos++;
                current = current.next;
            }
            holder = current.next;
            current.next = new Node<>(data);
            current.next.next = holder;
            size++;
        }
    }
    public void removeFirst() {
        if (head.next != null)
            head = head.next;
        else
            head = null;
        size--;
    }
    public void remove(int position) {
        Node<T> current = head;
        Node<T> holder = null;
        int prePos = 1;
        if (head != null) {
            if (position == 1) {
                removeFirst();
            } else {
                while (current.next != null && prePos < position) {
                    prePos++;
                    holder = current;
                    current = current.next;
                }
                if (current.next != null) {
                    holder.next = current.next;
                } else {
                    holder.next = null;
                }
            }
            size--;
        }
    }
    public int indexOf(T data) {
        Node<T> current = head;
        int index = -1;
        int tempId = 1;
        while(current.next != null) {
            if (data == current.data) {
                index = tempId;
                break;
            }
            tempId++;
            current = current.next;
        }
        if(index == -1) {
            index = data == current.data ? tempId : -1;
        }
        return index;
    }
    public boolean contains(T data) {
        Node<T> current = head;
        boolean check = false;
        do {
            if (data == current.data) {
                check = true;
                break;
            }
            current = current.next;
        } while(current.next != null);
        return check;
    }
    public Node<T> get(int pos){
        Node<T> current = head;
        for(int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public LinkedListFull<T> clone() throws CloneNotSupportedException {
        LinkedListFull<T> cloned = (LinkedListFull<T>) super.clone();
        cloned.head = (Node<T>) head.clone();
        return cloned;
    }

    public void printList() {
        Node<T> current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

class Node<E> implements Cloneable{
    Node<E> next;
    E data;
    public Node(E data) {
        this.data = data;
    }
    public E getData() {
        return this.data;
    }
    public void setData(E data){
        this.data = data;
    }

    @Override
    public Node<E> clone() throws CloneNotSupportedException {
        return (Node<E>)super.clone();
    }
}
