package datastructure.stack.arrayStack;

import datastructure.stack.Stack;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * 후입선출(LIFO : Last In First Out)
 * 접근은 목록의 끝(Top)에서만 진행이 됨
 * 스택이 사용되는 경우
 * 1. 운영체제 : 프로그램에서 사용되는 함수들을 스택 자료형에 저장하여 사용
 * 2. 컴파일러 : 수학 기호들을 기계어로 변환시 사용
 * 3. JVM : JVM 내에서 메소드가 실행, 종료될 때 스택 프레임을 이용하여 관리
 */
public class ArrayStack implements Stack {

    private int top;
    private int stackSize;
    private Object[] stackArr;

    //스택의 사이즈로 초기화
    public ArrayStack(int stackSize){
        top = -1;
        this.stackSize = stackSize;
        stackArr = new Object[this.stackSize];
    }
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == this.stackSize-1;
    }

    @Override
    public void push(Object item) {
        if(isFull())
            System.out.println("Stack is Full");
        else
            stackArr[++top] = item;
    }


    @Override
    public Object pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        }else {
            Object num = stackArr[top];
            stackArr[top] = null;
            top--;
            return num;
        }
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return 0;
        }else{

            return stackArr[top];
        }
    }

    @Override
    public void clear() {
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }else{
            top = -1;
            stackArr = new Object[this.stackSize];
        }
    }

    public void print(){
        if(isEmpty())
            System.out.println("Stack is Empty");
        else{
            String str = "[";
            str += Arrays.stream(stackArr)
                    .filter(i -> i!=null)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            str += "]";
            System.out.println(str);
        }
    }
}
