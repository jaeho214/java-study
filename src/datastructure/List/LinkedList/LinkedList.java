package datastructure.List.LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size=0;

    public void addFirst(Object object){
        //새로운 노드를 생성하여
        Node newNode = new Node(object);
        //원래 맨 처음에 있던 노드를 새로운 노드에 연결
        newNode.next = head;
        //맨 처음 값을 현재 넣어주는 값으로 갱신하고
        head = newNode;
        //사이즈 ++
        size++;
        //만약 맨 처음값의 다음 값이 null 이면 마지막 노드로 간주하여 tail에 저장
        if(head.next == null)
            tail = head;
    }

    public void addLast(Object object){
        Node newNode = new Node(object);
        //사이즈가 0이면 그냥 추가를 해주고
        if(size == 0)
            addFirst(object);
        //사이즈가 0이 아니면
        else{
            //맨 마지막에 있던 노드의 다음 값으로 새로운 노드를 지정해주고
            tail.next = newNode;
            //tail에 새롭게 삽입할 노드를 저장
            tail = newNode;
            size ++;
        }
    }

    public void add(int idx, Object object){
        if(idx == 0){
            addFirst(object);
        }else{
            //삽입할 공간의 바로 앞 노드까지 탐색하고
            Node temp1 = node(idx - 1);
            //삽입할 공간의 다음 노드를 temp2에 넣고
            Node temp2 = temp1.next;
            Node newNode = new Node(object);

            // temp1 과 temp2 사이로 삽입
            // 바로 앞 노드의 next를 삽입할 노드로 바꿔주고
            temp1.next = newNode;
            //삽입할 노드의 다음을 바로 뒤 노드로 바꿔준다
            newNode.next = temp2;
            size ++;
            if(newNode.next == null)
                tail = newNode;
        }
    }

    public Object remove(int idx){
        if(idx == 0)
            return removeFirst();

        //해당 인덱스 바로 앞의 노드를 가져온다.
        Node temp = node(idx - 1);
        //해당 인덱스에 해당하는 노드를 todoDeleted 라는 변수에 넣어준다.
        Node todoDeleted = temp.next;
        //해당 인덱스 바로 앞 노드의 next에 해당 인덱스 바로 뒤의 노드를 넣어준다
        temp.next = temp.next.next;

        //리턴해주기 위한 변수
        Object returnData = todoDeleted.data;

        //삭제한 노드가 마지막 노드라면
        if(todoDeleted == tail)
            //해당 인덱스 바로 앞 노드를 tail 로 저장
            tail = temp;

        todoDeleted = null;
        size --;
        return returnData;
    }

    public Object removeFirst() {
        Node temp = head;
        head = temp.next;

        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public int size(){
        return size;
    }

    public Object get(int idx){
        Node temp = node(idx);
        return temp.data;
    }

    public int indexOf(Object object){
        Node temp = head;
        int index = 0;

        while(temp.data != object){
            temp = temp.next;
            index ++;

            //없으면 -1리턴
            if(temp == null)
                return -1;
        }

        return index;
    }

    public ListIterator listIterator(){
        return new ListIterator();
    }

    public String toString(){
        if(head == null){
            return "[]";
        }
        Node temp = head;
        String str = "[";

        while(temp.next != null){
            str += temp.data + ", ";
            temp = temp.next;
        }

        str += temp.data;
        return str + "]";
    }
    //인덱스값의 노드를 리턴
    Node node(int index){
        Node x = head;
        for(int i=0;i<index;i++)
            x = x.next;
        return x;
    }

    public class ListIterator{
        //지난 노드
        private Node lastReturned;
        //다음 노드, 다음에 리턴될 노드
        private Node next;
        private int nextIndex;

        //초기화가 되면
        ListIterator(){
            //맨 앞에 있는 노드를 next로 넣어줌
            next = head;
            nextIndex = 0;
        }

        public Object next(){
            //노드를 리턴데이터로 넣어줌
            lastReturned = next;
            //그 다음 노드를 next 로 넣어줌
            next = next.next;
            //인덱스 ++
            nextIndex ++;

            return lastReturned.data;
        }

        public boolean hasNext(){
            //list의 크기를 넘어가면 false 리턴
            return nextIndex < size();
        }

        public void add(Object object){
            Node newNode = new Node(object);
            //마지막으로 리턴된 노드가 null이면 즉, 맨 첫번째 노드라면
            if(lastReturned == null){
                //맨 앞에 새로운 노드를 삽입하고
                head = newNode;
                //그 노드의 다음 노드에 next를 넣어줌
                newNode.next = next;
            }else{
                //마지막으로 리턴된 노드 다음에 새로운 노드를 넣어주고
                lastReturned.next = newNode;
                //next를 다시 연결해준다.
                newNode.next = next;
            }
            lastReturned = newNode;
            nextIndex ++;
            size ++;
        }

        public void remove(){
            if(nextIndex == 0)
                throw new IllegalStateException();
            LinkedList.this.remove(nextIndex-1);
            nextIndex--;
        }
    }

    public class Node{
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }


        public String toString(){
            return String.valueOf(this.data);
        }

    }
}
