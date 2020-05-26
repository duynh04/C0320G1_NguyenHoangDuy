package P6Collections.thuchanh.linkedList;

public class MyLinkedList<T> {
    private Node<T> head;
    private  int numNodes;

    public MyLinkedList() {
    }

    public MyLinkedList(T data) {
        head = new Node<>(data);
    }
    public void add(int pos, T data) {
        Node<T> current = head;
        Node<T> holder;
        if (pos == 1) {
            addFirst(data);
            return;
        }
        for(int i = 2; i < pos && current.next != null; i++) {
            current = current.next;
        }
        holder = current.next;
        current.next = new Node<>(data);
        current.next.next = holder;
        numNodes++;
    }
    public void addFirst(T data) {
        Node<T> temp = head;
        head = new Node<>(data);
        head.next = temp;
        numNodes++;
    }
    public Node<T> get(int pos){
        Node<T> temp = head;
        for(int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void printList() {
        Node<T> temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    private class Node<E> {
        private Node<E> next;
        private E data;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return this.data;
        }
    }
}
