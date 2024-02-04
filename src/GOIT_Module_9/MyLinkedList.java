package GOIT_Module_9;

public class MyLinkedList <T>{
    MyNode<T> head;
    MyNode<T> tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T value) {
        MyNode<T> newNode = new MyNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void remove(int index) {

        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        MyNode<T> myNode = head;
        for (int i = 0; i < index; i++) {
            myNode = myNode.next;
        }

        if (myNode.previous != null) {
            myNode.previous.next = myNode.next;
        } else {
            head = myNode.next;
        }
        if (myNode.next != null) {
            myNode.next.previous = myNode.previous;
        }
        tail = myNode.previous;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public int size() {
        int count = 0;
        MyNode<T> myNode = head;
        while (myNode != null) {
            count++;
            myNode = myNode.next;
        }
        return count;
    }

    public Object get(int index) {

        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        MyNode<T> myNode = head;
        for (int i = 0; i < index; i++) {
            myNode = myNode.next;
        }
        return myNode.value;
    }

    public static class MyNode<T> {
        T value;
        MyNode<T> next;
        MyNode<T> previous;

        public MyNode(T value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }
}