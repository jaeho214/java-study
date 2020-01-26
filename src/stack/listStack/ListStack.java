package stack.listStack;

import stack.Stack;

public class ListStack implements Stack {
    private ListStackNode top;

    public ListStack(){
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public void push(Object item) {
        ListStackNode newNode = new ListStackNode();

        if(isEmpty()){
            newNode.setData(item);
            newNode.setLink(null);
            this.top = newNode;
        }else{
            newNode.setData(item);
            newNode.setLink(top);
            top = newNode;
        }
    }

    @Override
    public Object pop() {
        Object data = peek();
        top = top.getLink();
        return data;
    }

    @Override
    public Object peek() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        }else
            return top.getData();
    }

    @Override
    public void clear() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }else{
            top = null;
        }
    }

    public void print(){
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }else{
            ListStackNode temp = top;
            System.out.print("[" + temp.getData() + ", ");
            while(temp.getLink() != null){
                temp = temp.getLink();
                System.out.print(temp.getData() + ", ");
            }
            System.out.println("]");
        }
    }
}
