package datastructure.List.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        LinkedList.ListIterator li = list.listIterator();
        System.out.println(li.next());
        System.out.println(li.next());
    }
}
