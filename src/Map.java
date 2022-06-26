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

        //Multiple Threads
        ConcurrentHashMap<Integer, String> Hash = new ConcurrentHashMap<>();
        new WriterThread(Hash, "Thread-1", 1).start();
        new WriterThread(Hash, "Thread-2", 2).start();

        for (int i = 1; i <= 5; i++) {
            new ReaderThread(Hash, "Multiple-Threads" + i).start();
        }
    }
}