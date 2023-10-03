package easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle/">Task on leetcode</a>
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(List.of(1));
        if (numRows == 1) {
            return result;
        }
        result.add(List.of(1, 1));
        numRows = numRows - 2;
        while (numRows > 0) {
            List<Integer> lastRow = result.get(result.size() - 1);
            List<Integer> curRow = new ArrayList<>(lastRow.size() + 2);
            curRow.add(1);
            for (int i = 0; i < lastRow.size() - 1; i++) {
                curRow.add(lastRow.get(i) + lastRow.get(i + 1));
            }
            curRow.add(1);
            result.add(curRow);
            numRows--;
        }
        return result;
    }

    @Test
    void testSolution() {
        PascalTriangle solution = new PascalTriangle();

        assertThat(solution.generate(1))
            .isEqualTo(List.of(
                List.of(1)
            ));

        assertThat(solution.generate(2))
            .isEqualTo(List.of(
                List.of(1),
                List.of(1, 1)
            ));

        assertThat(solution.generate(5))
            .isEqualTo(
                List.of(
                    List.of(1),
                    List.of(1, 1),
                    List.of(1, 2, 1),
                    List.of(1, 3, 3, 1),
                    List.of(1, 4, 6, 4, 1)
                )
            );
    }

}
