package dsaProblems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NonRepeatingCharacter {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		int[] arr = {1, 2};
		int[] arr1 = {1, 2};
		
            
			String st = "geeksgeeksfor";
			String stNew = "geeksgeeksfor";
			System.out.println(st==stNew);
			String st2 = new String("geeksgeeksfor");
			String st3 = new String("geeksgeeksfor");
			System.out.println(st==st3);
			StringBuilder st1 = new StringBuilder("geeks");
			
			StringBuffer st12 = new StringBuffer("geeks");
			String s = new String (st1);
			String s1 = new String (st12);
			char[] charArray = s1.toCharArray();
//            new NonRepeatingCharacter();
//			char ans=NonRepeatingCharacter.nonrepeatingCharacter(st);
//            
//            if(ans!='$')
//            System.out.println(ans);
//            else
//            System.out.println(-1);
		
		
//		int key = 3;
//		int[] A = {5,6,7,8,9,10,1,2,3,4};
//		int n = A.length;
//		System.out.println(search(A, 0, n - 1, key));
		 
//		int[][] input = {{1,2,1,2},{2,2,2,1},{2,1,2,2},{2,1,1,1}};
//		System.out.println(distinct(input, 4));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(in.readLine());
//        while(t-- > 0){
//            int N = Integer.parseInt(in.readLine());
//            int M[][] = new int[N][N];
//            String arr[] = in.readLine().trim().split("\\s+");
//            for(int i = 0;i < N*N; i++)
//                M[i/N][i%N] = Integer.parseInt(arr[i]);
//                
//            System.out.println(distinct(M, N));
//        }

	}
	
	// Function to find the first non-repeating character in a string.
	static char nonrepeatingCharacter(String S) {
		// Your code here
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
//            System.out.println(ch);
			if (S.chars().filter(letter -> letter == ch).count() == 1)
				return ch;
		}
		return '$';

	}
	
	static int search(int A[], int l, int h, int key) {
		// l: The starting index
		// h: The ending index, you have to search the key in this range
		// Complete this function
		int position = -1;
		List<Integer> arrList = Arrays.stream(A).boxed().collect(Collectors.toList());
		System.out.println(arrList.toString());
		position = arrList.indexOf(key) + 1;
		return position;
	}
	
	static int distinct(int M[][], int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}
//		System.out.println(M.toString());
		// Creating an empty map
		Map<Integer, Integer> distinctMap = new HashMap<>(N);
		
		for (int i = 0; i < N; i++) {
			distinctMap.putIfAbsent(M[0][i], 1);
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boolean distinct = true;
				for (int k = 0; k < j; k++) {
					if(M[i][j]==M[i][k]) {
						distinct = false;
					}
				}
				if (distinct == true && distinctMap.containsKey(M[i][j])) {
					distinctMap.put(M[i][j], distinctMap.get(M[i][j]) + 1);
				}
			}
		}

		System.out.println(distinctMap.toString());
//		long count = 0;
		int count = (int)distinctMap.values().stream().filter(v -> v>=N).count();
		
//		for (int i = 0; i < N; i++) {
//			if (distinctMap.get(M[0][i]) > N) {
//				count++;
//			}
//		}

		return count;

	}
        
}


	

