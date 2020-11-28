package leetcode.problem9;

import static org.assertj.core.api.Assertions.assertThat;

public class Wedul {
    public static void main(String[] args) {
        assertThat(isPalindrome(121)).isTrue();
        assertThat(isPalindrome(-121)).isFalse();
        assertThat(isPalindrome(10)).isFalse();
        assertThat(isPalindrome(-101)).isFalse();
    }

    public static boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}
