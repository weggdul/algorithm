package leetcode.problem8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class Wedul {
    public static void main(String args[]) {
        assertThat(myAtoi("4193 with words")).isEqualTo(4193);
        assertThat(myAtoi("words and 987")).isEqualTo(0);
        assertThat(myAtoi("-91283472332")).isEqualTo(-2147483648);
        assertThat(myAtoi("+1")).isEqualTo(1);
        assertThat(myAtoi("+-2")).isEqualTo(0);
        assertThat(myAtoi("0-1")).isEqualTo(0);
        assertThat(myAtoi("3.14159")).isEqualTo(3);
        assertThat(myAtoi("  -0012a42")).isEqualTo(-12);
        assertThat(myAtoi("-5-")).isEqualTo(-5);
    }

    // 예제를 잘 주던가 문제를 정확히 주던지 ...    
    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0 || !isNumber(str.charAt(0))) {
            return 0;
        }

        Matcher matcher = getNumber(str);
        if (!matcher.find()) {
            return 0;
        }

        String input = matcher.group();
        boolean isNegative = false;

        if (isSymbol(input.charAt(0))) {
            if (input.length() == 1) {
                return 0;
            }

            isNegative = isNegative(input.charAt(0));
        }

        try {
            return  (int) Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    private static Matcher getNumber(String str) {
        Pattern pattern = Pattern.compile("([-+])?[0-9]?\\.?\\d*");
        return pattern.matcher(str);
    }


    private static boolean isNumber(char ch) {
        return isPositive(ch) || isNegative(ch) || Character.isDigit(ch);
    }

    private static boolean isPositive(char ch) {
        return '+' == ch;
    }

    private static boolean isNegative(char ch) {
        return '-' == ch;
    }

    private static boolean isSymbol(char ch) {
        return isPositive(ch) || isNegative(ch);
    }


}
