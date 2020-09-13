package leetcode.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Wedul {

    public static void main(String[] args) {
        assertThat(convert("PAYPALISHIRING", 3)).isEqualTo("PAHNAPLSIIGYIR");
        assertThat(convert("PAYPALISHIRING", 4)).isEqualTo("PINALSIGYAHRPI");
        assertThat(convert("AB", 1)).isEqualTo("AB");
    }

    private static String convert(String s, int numRows) {
        List<Bucket> buckets = new ArrayList<>();
        int currCursor = 0;
        boolean isNegative = false;

        if (isOneRow(numRows)) {
            return s;
        }

        // initialIze
        IntStream.range(0, numRows).forEach(d -> buckets.add(new Bucket()));

        for (int i = 0; i < s.length(); i++) {
            buckets.get(currCursor).append(s.charAt(i));

            isNegative = isNegative(currCursor, numRows, isNegative);

            if (isNegative) {
                currCursor--;
            } else {
                currCursor++;
            }
        }

        return printStr(buckets);
    }

    private static boolean isOneRow(int numRows) {
        return numRows == 1;
    }

    private static String printStr(List<Bucket> buckets) {
        return buckets.stream().map(Bucket::getStr).collect(Collectors.joining(""));
    }

    private static boolean isNegative(int currCursor, int numRows, boolean isCurrenNegative) {;
        if (currCursor == 0) {
            return false;
        } else if (currCursor == (numRows - 1)) {
            return true;
        }

        return isCurrenNegative;
    }

    private static class Bucket {
        private String str = "";

        public void setStr(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }

        public void append(Character character){
            this.str += character;
        }
    }

}
