package dsaProblems;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Library {

	public static void main(String[] args) {
		
		ArrayList<Map<String, Object>> bookList = new ArrayList<>();
		bookList.add(Map.of("id",1,"name","name1","author","a1","readcount",12));
		bookList.add(Map.of("id",2,"name","name2","author","a2","readcount",1));
		bookList.add(Map.of("id",3,"name","name3","author","a3","readcount",4));
		bookList.add(Map.of("id",4,"name","name4","author","a4","readcount",7));
		bookList.add(Map.of("id",5,"name","name5","author","a5","readcount",9));
		
		Map<String, Integer> topAuthorMap = new HashMap<>();
		for(Map book : bookList) {
			int rcount = topAuthorMap.getOrDefault(book.get("author"), 0);
			topAuthorMap.put((String)book.get("author"), rcount+(int)book.get("readcount"));
		}
		List<Map.Entry<String, Integer>> sortedList = topAuthorMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).toList();
//		System.out.println(sortedList);
		
		for(int i=0;i<Math.min(sortedList.size(), 3);i++) {
			System.out.println(sortedList.get(i).getKey());
		}
		

	}

}
