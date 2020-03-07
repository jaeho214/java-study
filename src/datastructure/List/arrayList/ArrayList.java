package datastructure.List.arrayList;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class ArrayList {
    private int size = 0;
    private Object[] elementData = new Object[100];

    public boolean add(int index, Object object){
        // null 값을 넣으면  에러처리
        if(object == null)
            throw new NullPointerException();

        //현재 사이즈보다 큰 인덱스가 들어오면 에러 처리
        if(index > size)
            throw new StackOverflowError();

        //해당 인덱스의 값부터 뒤로 한 칸씩 민 후
        for(int i=size; i>= index; i--){
            elementData[i+1] = elementData[i];
        }

        //그 자리에 object를 넣고
        elementData[index] = object;
        //사이즈 ++
        size ++;

        return true;
    }

    public boolean addFirst(Object object){
        // null 값을 넣으면  에러처리
        if(object == null)
            throw new NullPointerException();

        return add(0, object);
    }

    public boolean addLast(Object object){
        // null 값을 넣으면  에러처리
        if(object == null)
            throw new NullPointerException();

        elementData[size] = object;
        size ++;

        return true;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        // ArrayList의 값들을 stream을 통해 String으로 변환
        sb.append(Arrays.stream(elementData).filter(i -> i != null).map(String::valueOf).collect(joining(", ")));
        sb.append("]");
        return sb.toString();
    }

    public Object remove(int index){
        Object removedData = elementData[index];

        for(int i=index; i<size; i++){
            elementData[i] = elementData[i+1];
        }

        size--;
        elementData[size] = null;

        return removedData;
    }

    public Object removeFirst(){
        return remove(0);
    }

    public Object removeLast(){
        return remove(size-1);
    }

    public int size(){
        return size;
    }

    public Object get(int index){
        return elementData[index];
    }

    public int indexOf(Object object){
        for(int i=0;i<size;i++){
            if(elementData[i].equals(object))
                return i;
        }
        return -1;
    }

    public ListIterator listIterator(){
        return new ListIterator();
    }

    public class ListIterator{
        private int nextIdx = 0;

        public boolean hasNext(){
            return nextIdx < size;
        }

        public Object next(){
            return elementData[nextIdx++];
        }

        public Object previous(){
            return elementData[--nextIdx];
        }

        public boolean hasPrevious(){
            return nextIdx > 0;
        }

        public void add(Object object){
            ArrayList.this.add(nextIdx++, object);
        }

        public void remove(){
            ArrayList.this.remove(nextIdx - 1);
            nextIdx --;
        }
    }
}
