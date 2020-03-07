package datastructure.stack.listStack;

public class ListStackExample {
    public static void main(String[] args) {

        ListStack listStack = new ListStack();    // 스택 생성


        listStack.push("A");
        listStack.print();
        listStack.push("B");
        listStack.print();
        listStack.push("C");
        listStack.print();
        listStack.push("D");
        listStack.print();
        listStack.push("E");
        listStack.print();
        listStack.push("F");
        listStack.print();

        listStack.pop();
        listStack.print();
        listStack.pop();
        listStack.print();

        listStack.peek();
    }

}
