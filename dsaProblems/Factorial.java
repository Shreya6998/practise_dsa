package dsaProblems;
import java.util.Arrays;

public class Factorial {

    public static void main(String[] args) {
        long l1 = 1000000005L;
        // First case
        System.out.println(genFibNum(3L, 1L, 2L, 6, 7));
        // Second Case
        System.out.println(genFibNum(l1, l1, l1, l1, l1));

    }

    static long genFibNum(Long a, Long b, Long c, long n, long m) {
        long fib = calcFib((long) a, (long) b, (long) c, n, m);
        return fib;
    }

    private static long calcFib(long a, long b, long c, long n, long m) {
        if (n == 1 || n == 2)
            return 1;
        long[][] idMat = {{a, b, c}, {1, 0, 0}, {0, 0, 1}};
        long[][] baseMat = {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}};
        long[][] finalMat = multiply(exponent(idMat, n - 2, m), baseMat, m);
        return finalMat[0][0];
    }

    private static long[][] multiply(long[][] mat1, long[][] mat2, long mod) {
        long[][] res = new long[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                res[r][c] = 0;
                for (int k = 0; k < 3; k++) {
                    res[r][c] += mat1[r][k] * mat2[k][c] % mod;
                    res[r][c] %= mod; // Apply modulo operation to prevent overflow
                }
            }
        }

        return res;
    }

    private static long[][] exponent(long[][] mat, long power, long mod) {
        if (power == 0) {
            long[][] base = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
            return base;
        }
        if (power == 1) {
            return mat;
        }

        long[][] temp = exponent(mat, power / 2, mod);
        if (power % 2 == 0)
            return multiply(temp, temp, mod);
        else
            return multiply(mat, multiply(temp, temp, mod), mod);

    }	
//	private static long multiplyMod(long a, long b) {
//        long res = 0;
//        while (b > 0) {
//            if ((b & 1) == 1) {
//                res += a;
//                if (res >= 1000000007L) { // Check for overflow
//                    res -= 1000000007L;
//                }
//            }
//            a <<= 1;
//            if (a >= 1000000007L) { // Check for overflow
//                a -= 1000000007L;
//            }
//            b >>= 1;
//        }
//        return res;
//    }
}
