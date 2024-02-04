package GOIT_Module_9;

public class MyQueue <T> {
    MyNode1<T> head;
    MyNode1<T> tail;
    int size;

    public MyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public void add(T value) {

        MyNode1<T> myNode1 = new MyNode1<T>(value);
        if (head == null) {
            head = myNode1;
            tail = myNode1;
        } else {
            tail.next = myNode1;
            myNode1.previous = tail;
            tail = myNode1;
        }
        size++;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (head == null) {
            System.out.println("Черга пуста");
            return null;
        }
        return head.value;
    }

    public T poll() {
        if (head == null) {
            System.out.println("Черга пуста");
            return null;
        }
        T value = head.value;

        head = head.next;
        size--;

        return value;
    }

   public static class MyNode1<T> {
        T value;
        MyNode1<T> next;
        MyNode1<T> previous;

        public MyNode1(T value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }
}
