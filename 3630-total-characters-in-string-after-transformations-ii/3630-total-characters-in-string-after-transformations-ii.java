import java.util.*;

public class Solution {
    static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // Convert List<Integer> to int[]
        int[] numArray = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            numArray[i] = nums.get(i);
        }

        int[][] T = getTransformationMatrix(numArray);
        int[][] poweredT = matrixPow(T, t);
        int[] count = new int[26];
        int[] lengths = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                lengths[j] = (int)((lengths[j] + 1L * count[i] * poweredT[i][j]) % MOD);
            }
        }

        int total = 0;
        for (int len : lengths) {
            total = (total + len) % MOD;
        }

        return total;
    }

    private int[][] getTransformationMatrix(int[] nums) {
        int[][] T = new int[26][26];
        for (int i = 0; i < nums.length; i++) {
            for (int step = 1; step <= nums[i]; step++) {
                T[i][(i + step) % 26]++;
            }
        }
        return T;
    }

    private int[][] getIdentityMatrix(int size) {
        int[][] I = new int[size][size];
        for (int i = 0; i < size; i++) {
            I[i][i] = 1;
        }
        return I;
    }

    private int[][] matrixMult(int[][] A, int[][] B) {
        int size = A.length;
        int[][] C = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                long sum = 0;
                for (int k = 0; k < size; k++) {
                    sum = (sum + 1L * A[i][k] * B[k][j]) % MOD;
                }
                C[i][j] = (int)sum;
            }
        }
        return C;
    }

    private int[][] matrixPow(int[][] M, int n) {
        if (n == 0) return getIdentityMatrix(M.length);
        if (n % 2 == 1) return matrixMult(M, matrixPow(M, n - 1));
        int[][] half = matrixPow(M, n / 2);
        return matrixMult(half, half);
    }
}
