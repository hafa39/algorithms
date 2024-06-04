package sort;

import backtracking.NQueensProblemSolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BackTrackingTest {

    @Test
    public void testNQueensProblemSolver() {
        NQueensProblemSolver nQueensProblemSolver = new NQueensProblemSolver(4);
        int[][] solve = nQueensProblemSolver.solve();
        // go through the board and check if there is only one queen in each row and column
        for (int i = 0; i < solve.length; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < solve.length; j++) {
                rowSum += solve[i][j];
                colSum += solve[j][i];
            }
            Assertions.assertEquals(1, rowSum);
            Assertions.assertEquals(1, colSum);
        }

        // check diagonals
        for (int i = 0; i < solve.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < solve.length - i; j++) {
                sum1 += solve[j][j + i];
                sum2 += solve[j + i][j];
            }
            Assertions.assertTrue(sum1 <= 1);
            Assertions.assertTrue(sum2 <= 1);
        }

        for (int i = 1; i < solve.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < solve.length - i; j++) {
                sum1 += solve[j + i][j];
                sum2 += solve[j][j + i];
            }
            Assertions.assertTrue(sum1 <= 1);
            Assertions.assertTrue(sum2 <= 1);
        }

    }
}
