package P6Collections.baitap.fullLinkedList.fullList;


public class FullListTest {
    public static void main(String[] args) {
        FullList<Integer> myListFull = new FullList<>();
        myListFull.add(1);
        myListFull.add(3);
        myListFull.add(4);
        myListFull.add(5);
        myListFull.add(6);
        myListFull.print();
        myListFull.add(2,2);
        myListFull.remove(2);
        myListFull.print();

    }
}
