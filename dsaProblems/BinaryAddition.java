public class BinaryAddition {
    public static void main(String[] args) {
        String result = addBinary("1101","111");
        System.out.println(result);
    }
    public static String addBinary(String s1, String s2) {
        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        int n1 = 0; int n2 = 0; int carry = 0;
        int sum; String res = "";
        while (i1 >= 0 || i2 >= 0) {
            if(i1 >= 0) {
                n1 = (s1.charAt(i1) - '0');
            }
            if(i2 >= 0) {
                n2 = (s2.charAt(i2) - '0');
            }
            sum = n1 + n2 + (carry);
            if (sum == 2) {
                carry = 1;
                res = "0"+res;
            } else if (sum == 3) {
                carry = 1;
                res = "1"+res;
            } else {
                carry = 0;
                res = sum+res;
            }
            n1 = n2 = 0;
            i1--; i2--;
        }
        if(carry==1) {
            res = "1"+res;
        }
        return Integer.valueOf(res).toString();
    }
}
