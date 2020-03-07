package datastructure.stack.listStack;

public class ListStackNode{
    private Object data;
    private ListStackNode link;

    public ListStackNode(){
        this.data = null;
        this.link = null;
    }

    public ListStackNode(Object data) {
        this.data = data;
        this.link = null;
    }

    public ListStackNode(Object data, ListStackNode link) {
        this.data = data;
        this.link = link;
    }

    public Object getData(){
        return this.data;
    }

    public ListStackNode getLink(){
        return this.link;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setLink(ListStackNode link) {
        this.link = link;
    }
}
