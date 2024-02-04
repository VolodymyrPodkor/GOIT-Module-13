package GOIT_Module_9;

public class MyArrayList {

private static final int DEFAULT_CAPACITY = 10;

private  Object[] array;

private int size;

public MyArrayList(){
    this.array = new Object[DEFAULT_CAPACITY];
    this.size = 0;
}

public void add(Object input){
    if(size >= array.length){
        int Capacity =  (int) (array.length * 1.5);
        Object[] newArray = new Object[Capacity];

        for (int i = 0; i < size; i++) {
              newArray[i] = array[i];
        }
        array = newArray;
    }
    array[size] = input;
    size++;
}

public void remove(int index){
    if(index < 0 || index >= size){
        throw  new ArrayIndexOutOfBoundsException();
    }
    for (int i = index; i < size -1; i++){
        array[i] = array[i + 1];
    }
    size--;
    array[size] = null;
}

public void clear(){
    for (int i = 0; i < size; i++) {
        array[i] = null;
    }
    size = 0;
}

public int size(){
    return size;
}

public Object get(int index){
    if(index < 0 || index >= size){
        throw  new ArrayIndexOutOfBoundsException();
    }
    else {
        return  array[index];
    }
}
}
