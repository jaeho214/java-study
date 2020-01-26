package stack;

public interface Stack {
    boolean isEmpty();
    //boolean isFull();
    void push(Object item);
    Object pop();
    Object peek();
    void clear();
}
