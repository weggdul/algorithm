package leetcode.problem10;

import static org.assertj.core.api.Assertions.assertThat;

public class Wedul {
    public static void main(String[] args) {
        assertThat(isMatch("a", ".*..a*")).isFalse();
        assertThat(isMatch("a", ".*.")).isTrue();
        assertThat(isMatch("aa", "a")).isFalse();
        assertThat(isMatch("aa", "a*")).isTrue();
        assertThat(isMatch("ab", ".*")).isTrue();
        assertThat(isMatch("aab", "c*a*b")).isTrue();
        assertThat(isMatch("mississippi", "mis*is*p*.")).isFalse();
        assertThat(isMatch("mississippi", "mis*is*ip*.")).isTrue();
        assertThat(isMatch("abcd", "d*")).isFalse();
        assertThat(isMatch("ab", ".*c")).isFalse();
        assertThat(isMatch("aaa", "aaaa")).isFalse();
        assertThat(isMatch("aa", "a*")).isTrue();
        assertThat(isMatch("aaa", "a*a")).isTrue();
        assertThat(isMatch("aaa", "ab*a")).isFalse();
        assertThat(isMatch("aaa", "ab*a*c*a")).isTrue();
        assertThat(isMatch("a", "ab*")).isTrue();
        assertThat(isMatch("a", ".*")).isTrue();
        assertThat(isMatch("ab", ".*..")).isTrue();
    }

    public static boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        char sChar, pChar;
        dp[0][0] = true;

        for(int i = 2 ; i <= p.length() ; i++) {
            if(p.charAt(i - 1) == '*' && dp[0][i-2]) dp[0][i] = true;
        }

        for(int i = 1 ; i <= s.length(); i++) {
            sChar = s.charAt(i-1);
            for(int j = 1 ; j <= p.length() ; j++) {
                pChar = p.charAt(j-1);

                // 문자가 같을 경우나 .일 경우에는 이전 문자의 성공 여부에 따라 결정
                if(sChar == pChar || pChar == '.') dp[i][j] = dp[i-1][j-1];
                else if(pChar == '*') {
                    // *가 시작된 패턴의 문자가 지금 인풋 char와 같거나 .일 경우
                    if(sChar == p.charAt(j-2) || p.charAt(j-2) == '.') dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    // 같지 않을 경우 이전결과에 종
                    else dp[i][j] = dp[i][j-2];
                }
            }
        }

        return dp[s.length()][p.length()];
    }

}
