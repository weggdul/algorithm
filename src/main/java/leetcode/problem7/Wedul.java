package leetcode.problem7;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Wedul {

    public static void main(String[] args) {
        assertThat(reverse(123)).isEqualTo(321);
        assertThat(reverse(-123)).isEqualTo(-321);
        assertThat(reverse(120)).isEqualTo(21);
        assertThat(reverse(Integer.MAX_VALUE + 1)).isEqualTo(0);
        assertThat(reverse(Integer.MIN_VALUE - 1)).isEqualTo(0);
    }

    public static int reverse(int x) {
        List<Character> array = String.valueOf(x).chars().mapToObj(e -> (char)e ).collect(Collectors.toList());
        boolean isMinus = x < 0;

        if (isMinus) {
            array = array.subList(1, array.size());
        }

        Collections.reverse(array);

        try {
            int reversVal = Integer.parseInt(array.stream().map(e->e.toString()).reduce((acc, e) -> acc  + e).get());

            if (isMinus) {
                return -1 * reversVal;
            }

            return reversVal;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
