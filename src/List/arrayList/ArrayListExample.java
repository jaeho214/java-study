package List.arrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("ArrayList : " + list);

        list.add(1, 15);
        System.out.println("add(1,15) 호출 후 : " + list);

        list.addFirst(5);
        System.out.println("addFirst(5) 호출 후 : " + list);

        list.remove(1);
        System.out.println("remove(1) 호출 후 : " + list);

        list.removeFirst();
        System.out.println("removeFirst() 호출 후 : " + list);

        list.removeLast();
        System.out.println("removeLast() 호출 후 : " + list);

        System.out.println("get(1) : " + list.get(1));

        System.out.println("size() : " + list.size());

        System.out.println("indexOf(20) : " + list.indexOf(20));

        System.out.println("indexOf(300) : " + list.indexOf(300));

        ArrayList.ListIterator iterator = list.listIterator();
        System.out.print("hasNext : ");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.print("hasPrevious : ");
        while(iterator.hasPrevious()){
            System.out.print(iterator.previous() + " ");
        }
        System.out.println();

        while(iterator.hasNext()){
            int number = (int) iterator.next();
            if(number == 30){
                iterator.add(35);
            }
        }
        System.out.println("add(35) 호출 후 : " + list);


    }
}
