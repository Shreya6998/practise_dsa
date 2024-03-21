package dsaProblems;
//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PrimeFactorial{
    public static void main(String args[]) throws IOException{
//        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//        
//        int t = Integer.parseInt(read.readLine());
//        
//        while(t-- > 0){
//            int n = Integer.parseInt(read.readLine());
//            
//            printPrimeFactorization(n);
//            
//            System.out.println();
//        }
//    	createString(5,2,"zzaaabcssstzaaaaaaaaaa");
    	int[] apple = {9,8,8,2,3,1,6};
    	int[] capacity = {10,1,4,10,8,5};
    	int res = minimumBoxes(apple, capacity);
    	System.out.println(res);
    }
    
    
// } Driver Code Ends
//User function Template for Java

// This function should print the prime factorization
// of the number n
// The new line is given by the driver's code.
public static void printPrimeFactorization(int n){
//	System.out.println("In");
    // code here
    if(isPrime(n)){
//    	System.out.println("Is Prime");
        System.out.print(n+" ");
        return;
    }
//    System.out.println("Isn't Prime");
    for(int i=2; i<100; i++){
        if(!isPrime(i)){
//        	System.out.println("Isn't Prime"+i);
            continue;
        }
//        System.out.println("Is Prime"+i);
        while(n > 1){
            if(n%i!=0)
            	break;
//               System.out.println("Is divisible"+i);
            System.out.print(i+" ");
            n = n/i;            
        }
    }   
}

public static boolean isPrime(int n){
//	System.out.println("In prime");
    if(n==1) {
        return false;
    }
    
    if(n==2 || n==3){
        return true;
    }
    
    if(n%2==0||n%3==0){
        return false;
    }
    
    for(int i=5; i*i<=n ; i+=6){
        if(n%i==0)
          return false;
    }
    return true;
}

public static int countDistinct(ArrayList<Integer> numbers) {
	int distinct = (int)numbers.stream().distinct().count();
	return distinct;
}

public static int sumUsingStreams(int []arr)
{
	return 0;
    //Your code here
//    //use stream.sum()
//    List<Integer> list = arr.asList();
//    int sum = (int)list.stream().reduce(0, Integer::sum);
//    return sum;
}

public static String createString(int n, int k, String s) {
    
    char[] sorted = s.toCharArray();
    Arrays.sort(sorted);
    StringBuilder sb = new StringBuilder(new String(sorted));
    sb.reverse();
//    String s1 = new String(sb);
    Map<Character,Integer> count = new HashMap<>();
     System.out.println(sb.length()+" "+s.length());
    for(int i=0; i<sb.length() ;i++){
        System.out.print(sb+" ");
        char c = sb.charAt(i);
        int occurance = count.getOrDefault((Character)c,0);
        System.out.print(c+" "+occurance+" ");
        occurance++;
        if(occurance>k){
            for(int j = i+1; j<sb.length() ; j++){
            	System.out.print(sb.charAt(j));
                if(sb.charAt(j)!=c){
                	System.out.print("in1");
                	char temp = sb.charAt(j);
                    sb.setCharAt(j,c);
                    sb.setCharAt(i,temp);
                    occurance = 0;
                    break;
                }
            }
            if(occurance !=0){
            	System.out.print("in2");
                sb.delete(i,sb.length());
            }
        }
        count.put((Character)c,occurance);
         System.out.print(count+" "+occurance+" ");
        System.out.println(sb+" ");

    }

    return new String(sb);
    
}

public static int minimumBoxes(int[] apple, int[] capacity) {
	int total = Arrays.stream(apple).sum();
	int boxSum = 0;
	int count = 0;
	capacity = Arrays.stream(capacity).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
	int i;
	for(i=capacity.length-1; i>=0; i--) {
		boxSum += capacity[i];
		count++;
		if(boxSum >= total) {
			break;
		}
	}
	return count;
}


//{ Driver Code Starts.

}
// } Driver Code Ends