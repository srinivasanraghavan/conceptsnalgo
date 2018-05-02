package com.insanelygreat.arrays;

import com.insanelygreat.List;

import java.util.Arrays;

public class ArrayListAlgo {


    public static int[] maxSubArrayBrute() {
        int[] A = {1, 8, 4, -4, 7, -8};
        int n = A.length;
        int maxSum = 0;
        int maxStartIndex = 0;
        int maxEndIndex = 0;

        // Brute Force
        for (int i = 0; i < n; i++) {

            int sum = 0;
            for (int j = 1; j < n; j++) {
                sum += A[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxStartIndex = i;
                    maxEndIndex = j;
                }

            }
        }
        return Arrays.copyOfRange(A, maxStartIndex, maxEndIndex);
    }

    /**
     * Kandande Algorithm
     * For example, with the array [-1, 4, 2, -1],
     * the logic might be written out as follows:
     * <p>
     * Set a maxSoFar and a maxEndingHere, both equal to the first element of the array to start (maxSoFar = -1, maxEndingHere = -1)
     * looking at the subarray [-1, 4],
     * the maximum is either current element or is the sum of the current element plus the previous maximum (-1 + 4 = 3)
     * Since 4 > 3, the current max is 4,
     * and since 4 > -1, we can update the global max as well
     * Now, we are able to "start" with 4, even though we are still on our first loop of the array
     * With the value of the next index (2), the maximum is either 2 or is the sum of the current element plus the previous maximum (4 + 2 = 6)F
     * <p>
     * <p>
     * Fist paas
     * <p>
     * maxSoFar= maxEndingHere= -1
     * max(-1,-1+-1)
     * max(-1,-2)
     * <p>
     * maxEndingHere = -1
     * <p>
     * max(-1,-1)
     * <p>
     * maxSoFar =-1
     * <p>
     * Second
     * <p>
     * maxSoEnding = max(4,3) =4
     * <p>
     * maxSoFar =(-1,3) =4
     * <p>
     * <p>
     * Third
     * <p>
     * maxSoEnding = max( 2, 6) =6
     * <p>
     * maxSoFar = max(4,6) =6
     * <p>
     * <p>
     * Fourth
     * <p>
     * maxSoEnding = max(-1, 6) =6
     * <p>
     * maxSoFar= max( 6, 6) = 6
     *
     * @return
     */
    public static int maxSubArrayDynamic() {

        int[] A = {-1, 4, 2, -1};

        int maxEndingHere = A[0];
        int maxSoFar = A[0];

        for (int a : A) {

            maxEndingHere = Integer.max(a, maxEndingHere + a);
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;

    }


    /**
     * Method 1
     * <p>
     * <p>
     * Find the total is math n(n+1)/2
     *
     * @return
     */
    public static int findMissingNumber() {
        int[] A = {1, 2, 3, 4, 5, 9, 10};
        int n = A.length;

        int total = ((n + 1) * (n + 2)) / 2;

        for (int i = 0; i < n; i++) {

            total -= A[i];
        }

        return total;

    }


    /**
     * Find missing number xor way
     * 1) XOR all the array elements, let the result of XOR be X1.
     * 2) XOR all numbers from 1 to n, let XOR be X2.
     * 3) XOR of X1 and X2 gives the missing number.
     *
     * @return
     */
    public static int findMissingNumberxor() {


        // later

        return 1;
    }


    public static boolean isHavingDuplicates(String str) {

        boolean[] bs = new boolean[256];

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            if (bs[c]) {
                return false;

            } else {
                bs[c] = true;
            }

        }
        return true;

    }

    /**
     * Write an algorithm to rotate an array
     */

    public void rotateAnArray() {

        char[] word = {'a', 'b', 'c', 'd'};


    }

    /**
     * Very important has some easy sol in c look in java
     *
     * @param string
     */
    public void permute(String string) {

    }

    public void permuteBacktrack(char[] array, int i, int n) {

    }

    private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static char[] removeDuplictatesWithBuffer(String str) {

        boolean[] bs = new boolean[256];
        char[] chars = str.toCharArray();
        bs[chars[0]] = true;
        int tail = 1;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (!bs[c]) {
                chars[tail] = c;
                ++tail;
                bs[c] = true;

            }

        }
        chars[tail] = 0;
        return chars;

    }

    public static boolean checkPalindrome(String str) {

        int length = str.length();
        int middle = length / 2;

        boolean flag = false;
        for (int i = 0; i < middle; i++) {

            if (str.charAt(i) == str.charAt((length - 1) - i)) {

                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;

    }

    static void printArr(char s[], int i, int j) {
        while (i <= j)
            System.out.print(s[i++]);
        System.out.println();
    }

    public static void palindromes(char s[]) {
        int i, j, L, H;
        L = 0;
        H = s.length - 1;
        for (i = L; i <= H; i++) {
            // odd palindromes with i at center
            for (j = 1; i - j >= L && i + j <= H && s[i - j] == s[i + j]; j++)
                ;
            if (j > 1) {
                printArr(s, i - j + 1, i + j - 1);
            }
            // even palindromes, no-center
            for (j = 0; i - j >= L && i + j + 1 <= H
                    && s[i - j] == s[i + j + 1]; j++)
                ;
            if (j > 0)
                printArr(s, i - j + 1, i + j);
        }
    }

    public void checkAnagrams(String str1, String str2) {

    }

    public void removeduplicatesWithoutSpace(char[] str) {
        // if(str == null) {
        // return;
        // }
        // int length = str.length;
        // else if (length<2){
        //
        // }

    }

}
