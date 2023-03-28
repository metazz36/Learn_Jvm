package src.com.atguigu.java2;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
        for (int i = 0; i < 10000000; i++) {
            hashmap.put(i, "glsx");
        }

        long bs = Calendar.getInstance().getTimeInMillis();
        Iterator iterator = hashmap.keySet().iterator();
        while (iterator.hasNext()) {
            hashmap.get(iterator.next());
        }
        System.out.print("keyset:");
        System.out.println(Calendar.getInstance().getTimeInMillis() - bs);
        listHashMap();
    }

    public static void listHashMap() {
        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
        for (int i = 0; i < 10000000; i++) {
            hashmap.put(i, "glsx");
        }
        long bs = Calendar.getInstance().getTimeInMillis();
        Iterator it = hashmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getValue();
        }
        System.out.print("entryset:");
        System.out.println(Calendar.getInstance().getTimeInMillis() - bs);
    }
}
