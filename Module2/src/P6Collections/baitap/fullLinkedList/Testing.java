package P6Collections.baitap.fullLinkedList;

public class Testing {
    public static void main(String[] args) throws CloneNotSupportedException {
        LinkedListFull<Integer> list = new LinkedListFull<>(1);
        list.addLast(5);
        list.add(3, 10);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.add(10, 20);
    System.out.println("index: " + list.indexOf(20));
//        LinkedListFull<Integer> list1 = list.clone();
//        list1.addFirst(6);
        list.printList();
//        System.out.println(list1.getSize());
    }
}
