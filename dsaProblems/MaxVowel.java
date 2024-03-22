package dsaProblems;

import java.util.Scanner;

public class MaxVowel {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		String in = sc.next();
//		sc.close();
		System.out.println(maxVowels("ghtdfoutriaeraewazfdrfaa",3));
	}
	
    static int maxVowels(String s, int k) {
        
    	int len = s.length();
        int maxCount = 0;
//      //Naive Approach
//        for(int i = k; i<=len; i++){
//            int count = 0;
//            for(int j = i-k; j<i; j++){
//                if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u'){
//                    count++;
//                }
//            }
//            if(count > maxCount){
//                maxCount = count;
//            }
//        }
        //Count vowels in first window
        for(int i=0; i<k ; i++) {
        	if (isVowel(s.charAt(i))){
              maxCount++;
          }
        }
        int count = maxCount;
        for(int i=k; i<len; i++) {
        	if(isVowel(s.charAt(i-k))) {
        		count--;
        	}
        	if(isVowel(s.charAt(i))) {
        		count++;
        	}
        	if(count > maxCount){
        		maxCount = count;
        	}
        }
        
        return maxCount;
    }

	static boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
}
