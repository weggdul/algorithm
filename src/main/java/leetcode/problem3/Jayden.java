package leetcode.problem3;

import java.util.HashSet;
import java.util.Set;

public class Jayden {

    public static void main(String[] args) {
        String[] arrInput = {"abcabcbb", "bbbbb", "pwwkew"};
        int[] arrResult = {3, 1, 3};

        for (int i = 0; i < arrInput.length; i++) {
            if (arrResult[i] != lengthOfLongestSubstring(arrInput[i])) {
                throw new RuntimeException("틀렸습니다.");
            } else {
                System.out.println(arrInput[i] + " " + arrResult[i]);
            }
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();

        int result = 0;
        int i = 0, j = 0;

        while (i < s.length() && j < s.length()) {
            Character character = s.charAt(j);
            if (characterSet.contains(character)) {
                // 앞에서 부터 순서대로 삭제
                characterSet.remove(s.charAt(i++));
            } else {
                characterSet.add(s.charAt(j++));
                // j와 i 인덱스 차이를 이용해서 길이 계산
                result = Math.max(result, j - i);
            }
        }
        return result;
    }

}
