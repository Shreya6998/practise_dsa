package Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertToInt {
    public static  void main(String[] args) {
//        System.out.println(myAtoi2("-123"));
//        System.out.println(myAtoi2(" -12f3"));
//        System.out.println(myAtoi2("   +0025f390fgjhg  "));
//        System.out.println(myAtoi2("    +g12f3"));
//        System.out.println(myAtoi2("-g12f3"));
//        System.out.println(myAtoi2("       -"));
//        System.out.println(myAtoi2(" 1231231231311133"));
//        System.out.println(myAtoi2("-999999999999"));
        System.out.println(myAtoi2("21474836460"));
    }

    //Basic
    static int myAtoi(String s) {
        long converted = 0L;
        boolean isNegative = false;
        // Trim white spaces
        s = s.trim();

        //Check if number has a sign
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            isNegative = ((s.charAt(0)) == '-');
            s = s.substring(1);
        }

        //Check if a non-digit character exists
        Pattern p = Pattern.compile("\\D");
        Matcher m = p.matcher(s);
        if(m.find()){
            s = s.substring(0,m.start());
        }

        for(int i = 0;i<s.length();i++) {
            int digit = s.charAt(i) - '0';
            converted = (converted * 10L) + (long) digit;
            if(converted > Integer.MAX_VALUE) {
                converted = Integer.MAX_VALUE;
                break;
            }
        }
        return isNegative? (int)converted*-1:(int)converted;
    }

    //Improved
//    static int myAtoi2(String s) {
//        int i = 0, n = s.length();
//        int sign = 1;
//        long result = 0;
//
//        // 1. Skip leading whitespaces
//        while (i < n && s.charAt(i) == ' ') {
//            i++;
//        }
//
//        // 2. Check sign
//        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
//            sign = (s.charAt(i) == '-') ? -1 : 1;
//            i++;
//        }
//
//        // 3. Parse digits
//        while (i < n && Character.isDigit(s.charAt(i))) {
//            int digit = s.charAt(i) - '0';
//
//            // 4. Overflow check BEFORE multiplying
//            if (result > (Integer.MAX_VALUE - digit) / 10) {
//                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            }
//
//            result = result * 10 + digit;
//            i++;
//        }
//
//        return (int) (sign * result);
//    }

    static int myAtoi2(String s) {
        int sign = 1;
        long converted = 0;
        int i = 0;
        int n = s.length();

        //Skip whitespaces
        while(i<n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        //Check if number has a sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-')?-1:1;
            i++;
        }

        //Iterate through the rest
        for(;i<n;i++) {
            //If digit, process it
            if(Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';
                //Check converted
                if(converted > (2147483647L - (long) digit) / 10L) {
                    return (sign==-1)? -2147483648: 2147483647;
                }

                //Update converted
                converted = converted*10L + (long) digit;
            }
            // If non-digit, break loop
            else {
                break;
            }
        }

        return (int) (sign*converted);

    }
}
