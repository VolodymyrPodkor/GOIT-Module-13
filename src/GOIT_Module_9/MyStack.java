package GOIT_Module_9;

public class MyStack <T> {
    MyNode2<T> head;
    MyNode2<T> tail;
    int size;

    public MyStack(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void push(T value) {

        MyNode2<T> node2 = new MyNode2<>(value);
        if(head == null){
            head = node2;
            tail = node2;
        }
        else {
            tail.next = node2;
            node2.previous = tail;
            tail = node2;
        }
        size++;
    }

    public void remove(int index) {
       if(index < 0 || index >= size){
           throw new ArrayIndexOutOfBoundsException();
       }
       MyNode2<T> node2 = head;
        for (int i = 0; i < index; i++) {
            node2 = node2.next;
        }
        if(node2.previous == null){
            head = node2.next;
        }
        else {
            node2.previous.next = node2.next;
        }
        if(node2.next == null){
            tail = node2.previous;
        }
        size--;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public T peek() {
        if (head == null) {
            System.out.println("Стек пустий");
            return null;
        }
        return head.value;
    }

    public T pop(){
        if(head == null){
            System.out.println("Стек пустий");
            return null;
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public static class MyNode2<T>{
        T value;
        MyNode2<T> next;
        MyNode2<T> previous;

        public MyNode2(T value){
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }
}
