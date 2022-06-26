# HashMap in java

Java HashMap is a hash table from Java's Map interface. Its like a collection of key-value pairs. It maps keys to values. It means you can get value by the keys.
A HashMap cannot contain duplicate keys.
HashMap have 4 types:

* HashMap (ordinary)
* Hashtable
* SynchronizedMap
* ConcurrentHashMap

## HashMap
The ordinary HashMap is NOT Thread-Safe, It can have one null key and multiple null values.
And we can impleemnt a HashMap like example below:

```Java
HashMap<String, Integer> Hashmap = new HashMap<>();
```

## ConcurrentHashMap
The ConcurrentHashMap is Thread-Safe, Fast Performance and null key and values are not allowed.
We can impleemnt a ConcurrentHashMap like example below:

```Java
ConcurrentHashMap<String, Integer> ConcurrentHashMap = new ConcurrentHashMap<>();
```

## Example
you can see the concept of it by example below:

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Map {
    public static void main(String[] args) {


        HashMap<String, Integer> Hashmap = new HashMap<>(); //Username ID

        Hashmap.put("User01",1);
        Hashmap.put("User02",2);
        Hashmap.put("User03",3);
        Hashmap.put("User04",4);
        Hashmap.put("User05",5);
        Hashmap.put("User06",6);

        System.out.println("Result of Hashmap before iterator: " + Hashmap);

        Iterator<String> _iterator_HashMap = Hashmap.keySet().iterator();

        while (_iterator_HashMap.hasNext()){
            String key = _iterator_HashMap.next();
            if (key.equals("User05")) {
                Hashmap.put("newUser", 5);
                break; // We need to add break to Hash map work The HashMap not Thread safe and Can have one null key and multiple null values
            }
        }

        System.out.println("Result of Hashmap after iterating: " + Hashmap);
        
        ConcurrentHashMap<String, Integer> ConcurrentHashMap = new ConcurrentHashMap<>(); //Username ID

        ConcurrentHashMap.put("User01",1);
        ConcurrentHashMap.put("User02",2);
        ConcurrentHashMap.put("User03",3);
        ConcurrentHashMap.put("User04",4);
        ConcurrentHashMap.put("User05",5);
        ConcurrentHashMap.put("User06",6);

        System.out.println("Result of ConcurrentHashmap before iterating: " + ConcurrentHashMap);
        Iterator<String> _iterator_ConcurrentHashMap = ConcurrentHashMap.keySet().iterator();

        while (_iterator_ConcurrentHashMap.hasNext()){
            String key = _iterator_ConcurrentHashMap.next();
            if (key.equals("User05")) ConcurrentHashMap.put("newUser", 5);
        }

        System.out.println("Result of ConcurrentHashmap after iterating: " + ConcurrentHashMap);
    }
}
```

## Difference between HashMap and ConcurrentHashMap

* HashMap is non-Synchronized in nature i.e. HashMap is not Thread-safe whereas ConcurrentHashMap is Thread-safe in nature.
* HashMap performance is relatively high because it is non-synchronized in nature and any number of threads can perform simultaneously. But ConcurrentHashMap performance is low sometimes because sometimes Threads are required to wait on ConcurrentHashMap.
* While one thread is Iterating the HashMap object, if other thread try to add/modify the contents of Object then we will get Run-time exception saying ConcurrentModificationException.Whereas In ConcurrentHashMap we wont get any exception while performing any modification at the time of Iteration.

