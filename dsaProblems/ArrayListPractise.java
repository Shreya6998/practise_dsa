package dsaProblems;
import java.util.*;

public class ArrayListPractise {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		al.add("Shreya");
//		System.out.println(al.toString());
//		System.out.println(al.toArray());
		al.add(0, "Reet");
//		System.out.println(al);
		LinkedList<String> ll = new LinkedList<>();
		ll.add("Java");
		ll.add(0, "Python");
		ll.addAll(1, al);
		ll.addFirst("First");
		ll.addLast("Last");
//		for (String str : ll)  
//            System.out.print(str + " ");
		HashMap<String, Integer> map = new HashMap<>();
		map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);
        int size = map.size();
        System.out.println(size);
//        if (map.containsKey("vishal")) {
//        	 
//            // Mapping
//            Integer a = map.get("vishal");
// 
//            // Printing value for the corresponding key
//            System.out.println("value for key"
//                               + " \"vishal\" is: " + a);
//        }
//        for (Map.Entry<String, Integer> e : map.entrySet())
//        System.out.println("Key: " + e.getKey()
//                           + " Value: " + e.getValue());
//        for(String k : map.keySet())
//        	System.out.println("Key :" +k);
//        
//        for(Integer v : map.values())
//        	System.out.println("Value :" +v);
//        
        HashMap<String, Integer> map1 = new HashMap<>();
		map1.put("Nishal", 40);
        map1.put("Rachin", 50);
        map1.put("Saibhav", 60);
        
        map.putAll(map1);
        
        System.out.println(map);
        
        map.entrySet().stream().forEach(entry->{
        	System.out.println("Key :"+entry.getKey());
        	System.out.println("Value :"+entry.getValue());
        });
	}

}
