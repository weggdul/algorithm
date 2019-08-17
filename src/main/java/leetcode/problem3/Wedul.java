package leetcode.problem3;

import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * algorithm
 *
 * @author wedul
 * @since 2019-08-17
 **/
public class Wedul {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();

    System.out.println(lengthOfLongestSubstring(input));
  }

  public static int lengthOfLongestSubstring(String s) {
    int maxSize = 0;
    List<Character> characterList = new ArrayList<>();

    for (char alpha : s.toCharArray()) {
      if (characterList.contains(alpha)) {
        if (characterList.size() > maxSize) maxSize = characterList.size();

        char ch = characterList.remove(0);
        while (ch != alpha) {
          ch = characterList.remove(0);
        }

        characterList.add(alpha);
      } else if (!characterList.contains(alpha)) {
        characterList.add(alpha);
      }
    }

    return maxSize > characterList.size() ? maxSize : characterList.size();
  }

}
