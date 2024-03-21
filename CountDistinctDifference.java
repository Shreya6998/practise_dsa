package dsaProblems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountDistinctDifference {

	public static void main(String[] args) throws IOException {
//		Input
//		451 2
//		66 140 104 24 148 101 18 104 117 10 132 117 109 135 38 136 72 104 112 62 40 65 71 116 44 144 99 13 60 145 27 131 100 78 56 64 62 59 78 62 120 104 72 107 93 4 4 13 66 141 140 9 147 124 24 9 130 25 148 42 12 63 39 77 9 70 11 85 6 38 129 43 96 119 75 141 4 115 93 76 80 54 93 90 28 136 97 105 52 51 16 131 105 64 106 103 19 11 38 22 141 126 13 128 109 130 145 27 111 17 104 81 108 10 37 8 95 72 147 73 56 65 83 42 134 108 117 86 124 131 110 101 22 96 83 72 129 40 133 63 102 78 58 43 106 12 31 107 131 47 50 16 4 106 111 48 68 81 149 10 111 70 37 108 55 114 128 5 144 81 66 83 6 52 71 146 20 37 64 116 69 135 147 64 63 114 119 70 100 25 14 104 76 134 20 47 38 46 31 37 93 75 90 57 118 103 107 8 126 121 55 105 60 145 3 104 44 5 143 19 83 35 35 14 132 115 60 28 138 59 147 31 66 81 31 136 87 73 14 108 140 98 18 68 42 112 53 104 63 61 148 80 127 98 71 52 52 52 23 119 114 39 127 144 26 95 85 8 76 114 103 43 6 87 117 30 56 109 52 46 21 51 109 24 116 73 53 64 122 44 129 45 49 143 107 137 55 136 123 58 5 15 24 36 117 108 70 38 111 60 145 120 71 121 82 54 126 77 25 114 1 111 120 38 56 31 37 126 5 119 43 100 131 66 123 9 25 19 136 2 114 116 110 38 7 125 103 19 12 29 57 4 94 80 120 124 114 138 63 23 68 51 58 140 60 54 96 116 52 146 120 96 42 120 16 88 46 126 37 83 64 46 51 118 85 17 78 16 36 10 81 51 143 27 20 27 147 93 121 8 67 52 52 34 92 79 49 27 135 144 53 16 90 93 14 136 101 76 80 46 27 125 139 132 24 141 79 41 79 15 11 34 15 138 72 135 74 65 130 88 79 144 90 29 92 67 23 40 80 98 107
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine().trim();
        String[] S1 = s1.split(" ");
        String s2 = br.readLine().trim();
        String[] S2 = s2.split(" ");
        int n, k;
        n = Integer.parseInt(S1[0]);
        k = Integer.parseInt(S1[1]);
        int[] nums = new int[n];
        for(int i = 0; i < S2.length; i++)
            nums[i] = Integer.parseInt(S2[i]);
        int ans = TotalPairs(nums, k);
        System.out.println(ans);  
	}
	static int TotalPairs(int[] nums, int k)
    {
        // Code here
        int count = 0;
        Set<Integer> seen = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length ; i++){
            int n = map.getOrDefault(nums[i],0);
            map.put(nums[i],n+1);
        }
        
        for(int i=0; i<nums.length ; i++){
            int complement = nums[i]+k;
            if(!seen.contains(nums[i]) && map.containsKey(complement)) {                
                if(nums[i] == complement && map.get(complement)==1) {
                    continue;
                }
            	count++;
            	seen.add(nums[i]);
            }
        }
        
        return count;
    }

}
