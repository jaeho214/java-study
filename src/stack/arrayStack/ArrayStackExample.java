package stack.arrayStack;

public class ArrayStackExample {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

        arrayStack.push('A');
        arrayStack.print();

        arrayStack.push('B');
        arrayStack.print();

        arrayStack.push('C');
        arrayStack.print();

        arrayStack.pop();
        arrayStack.print();

        arrayStack.pop();
        arrayStack.print();

        arrayStack.peek();
        arrayStack.print();

        arrayStack.clear();
        arrayStack.print();
    }
}
