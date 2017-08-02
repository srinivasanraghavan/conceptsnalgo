package com.insanelygreat.arrays;

import com.insanelygreat.List;

public class ArrayListAlgo {

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

        char[] word={'a','b','c','d'};



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
