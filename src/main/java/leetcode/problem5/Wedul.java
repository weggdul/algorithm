package leetcode.problem5;

/**
 * algorithm
 *
 * @author wedul
 * @since 2019-10-04
 **/
public class Wedul {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("aaabaaaa"));
        System.out.println(longestPalindrome("tattarrattat"));
    }

    public static String longestPalindrome(String s) {
        String ret = "";

        for (int i = 0; i < s.length(); i++) {
            ret = setPalindrome(ret, palindrome(s, ret, i, i + 1));
            ret = setPalindrome(ret, palindrome(s, ret, i - 1, i));
            ret = setPalindrome(ret, palindrome(s, ret, i - 1, i + 1));
        }

        return ret;
    }

    private static String setPalindrome(String oldPalindrome, String newPalindrome) {
        if (oldPalindrome.length() >= newPalindrome.length()) {
            return oldPalindrome;
        }

        return newPalindrome;
    }

    private static boolean isPalindromeValidation(String inputStr, int startIndex, int endIndex) {
        if ((endIndex - startIndex) % 2 == 0) {
            while (startIndex != endIndex) {
                if (inputStr.charAt(startIndex) != inputStr.charAt(endIndex)) {
                    return false;
                }
                startIndex++;
                endIndex--;
            }
        } else {
            while (startIndex < endIndex) {
                if (inputStr.charAt(startIndex) != inputStr.charAt(endIndex)) {
                    return false;
                }
                startIndex++;
                endIndex--;
            }
        }

        return true;
    }

    private static String palindrome(String inputStr, String currPalindrome, int startIndex, int endIndex) {
        if (currPalindrome.equals(inputStr)) return currPalindrome;

        if (startIndex < 0 && inputStr.length() <= endIndex) {
            return currPalindrome;
        } else if (startIndex < 0) {
            startIndex = 0;
        } else if (inputStr.length() <= endIndex) {
            endIndex = inputStr.length() - 1;
        }

        if (isPalindromeValidation(inputStr, startIndex, endIndex)) {
            return palindrome(inputStr, inputStr.substring(startIndex, endIndex + 1), startIndex - 1, endIndex + 1);
        }

        return currPalindrome;
    }

}