package GOIT_Module_9;

public class CollectionMain {
    public static void main(String[] args) {
         MyArrayList myArrayList = new MyArrayList();
         myArrayList.add("Volodymyr");
         myArrayList.add("Maksym");
         myArrayList.add("Mark");
        System.out.println("myArrayList.get(2) індекс  = " + myArrayList.get(2));
        System.out.println("myArrayList.size до видалення = " + myArrayList.size());
        myArrayList.remove(1);
        System.out.println("myArrayList.size після видалення = " + myArrayList.size());
        myArrayList.clear();
        System.out.println("myArrayList.size після очистки: " + myArrayList.size());
        System.out.println("____________________________________________________");

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Vlad");
        myLinkedList.add("Oleg");
        myLinkedList.add("Anatoliy");
        myLinkedList.add("Iryna");
        myLinkedList.add("Andriy");
        System.out.println("myLinkedList.get(3) індекс = " + myLinkedList.get(3));
        System.out.println("myLinkedList.size до видалення = " + myLinkedList.size());
        myLinkedList.remove(1);
        System.out.println("myLinkedList.size після видалення = " + myLinkedList.size());
        myLinkedList.clear();
        System.out.println("myLinkedList.size після очистки = " + myLinkedList.size());
        System.out.println("_____________________________________________________");

        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("Evgeniy");
        myQueue.add("Stanislav");
        myQueue.add("Elton");
        myQueue.add("Mariya");
        System.out.println("myQueue.peek() = перший елемент черги " + myQueue.peek());
        System.out.println("myQueue.size = до видалення " + myQueue.size);
        System.out.println("myQueue.poll() = елемент " + myQueue.poll() + " був повернутий та видалений з колекції");
        System.out.println("myQueue.size = після видалення першого елемента " + myQueue.size);
        System.out.println("myQueue.clear() = Очищаєм чергу");
        myQueue.clear();
        System.out.println("myQueue.size = після очистки черги " + myQueue.size());
        System.out.println("_____________________________________________________");

        MyStack<String> myStack = new MyStack<>();
        myStack.push("Oleg");
        myStack.push("Oleksandr");
        myStack.push("Kateryna");
        myStack.push("Dmytro");
        System.out.println("myStack.size до видалення = " + myStack.size());
        System.out.println("myStack.remove(1) = видаляємо елемент стеку по індексу 1 (Oleksandr)");
        myStack.remove(1);
        System.out.println("myStack.size після видалення = " + myStack.size());
        System.out.println("myStack.peek() = перший елемент стеку " + myStack.peek());
        System.out.println("myStack.pop() = елемент " + myStack.pop() + " був повернутий та видалений з колекції");
        System.out.println("myStack.size() = після видалення першого елементу " + myStack.size());
        System.out.println("myStack.clear() = очищаєм стек");
        myStack.clear();
        System.out.println("myStack.size() = після очистки стеку " + myStack.size());
        System.out.println("_____________________________________________________");

        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("Maks", 10);
        myHashMap.put("Mark", 6);
        myHashMap.put("Iryna", 31);
        myHashMap.put("Volodymyr", 33);
        myHashMap.put("Tanya", 37);
        System.out.println("myHashMap.size() = до видалення " + myHashMap.size());
        System.out.println("Видаляємо значення по ключу (\"Maks\")");
        myHashMap.remove("Maks");
        System.out.println("myHashMap.size() = після видалення " + myHashMap.size());
        System.out.println("Значення по ключу (\"Volodymyr\") = " + myHashMap.get("Volodymyr"));
        System.out.println("Очищаєм корзину");
        myHashMap.clear();
        System.out.println("myHashMap.size() = після очистки " + myHashMap.size());
    }
}
