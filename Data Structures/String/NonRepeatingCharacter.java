package String;

public class NonRepeatingCharacter {
    
    public static  void main(String args[]) {
        String str = "ollllllllllo";
        System.out.println(nonRepeatingChar(str));
    }

    private static int nonRepeatingChar(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
