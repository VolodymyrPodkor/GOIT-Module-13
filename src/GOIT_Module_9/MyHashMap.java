package GOIT_Module_9;

public class MyHashMap <K,V> {
    public static final int DEFAULT_SIZE = 8;
    private Entry<K, V> [] entries = new Entry[DEFAULT_SIZE];
    private int size;

    public void put(K key, V value){

        int index = getBucketIndex(key);
        Entry<K, V> entry = new Entry<>(key, value);

        if(entries[index] == null){
            entries[index] = entry;
        }
        else {
            Entry<K, V> kvEntry = entries[index];
            while (kvEntry.next != null) {
                if (kvEntry.key.equals(key)) {
                    kvEntry.value = value;
                    return;
                }
                kvEntry = kvEntry.next;
            }
            kvEntry.next = entry;
        }
        size++;
    }

    public void remove(Object key){
       if(key == null){
           return;
       }
       int index = getBucketIndex((K) key);
       Entry<K, V> entry = entries[index];
       Entry<K, V> previous = null;

       while (entry != null){
           if(entry.key.equals(key)){
               if(previous == null){
                   entries[index] = entry.next;
               }
               else {
                   previous.next = entry.next;
               }
               size--;
               return;
           }
            previous = entry;
           entry = entry.next;
       }
    }

    public  void clear(){
     size = 0;
    }

    public int size(){
        return size;
    }

    public V get(K key){

      int index = getBucketIndex(key);
      Entry<K, V> entry = entries[index];

      while (entry != null){
          if(entry.key.equals(key)){
              return entry.value;
          }
          entry = entry.next;
      }
      return  null;
    }

    private int getBucketIndex(K key){
        return Math.abs(key.hashCode() % entries.length);
    }

    public static class Entry <K, V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
