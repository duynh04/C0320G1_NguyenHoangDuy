package P6Collections.thuchanh.linkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList<String> ll = new MyLinkedList<>("10");
        ll.addFirst("11");
        ll.addFirst("12");
        ll.addFirst("13");
        ll.add(1,"9");
        ll.add(7,"9");

        ll.printList();
    }
}
