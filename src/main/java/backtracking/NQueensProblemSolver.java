package backtracking;

public class NQueensProblemSolver {

    private int[][] board;
    private int n;

    public NQueensProblemSolver(int n){
        this.n = n;
        board = new int[n][n];
    }

    public static void main(String[] args) {
        NQueensProblemSolver nQueensProblemSolver = new NQueensProblemSolver(4);
        nQueensProblemSolver.solve();
    }

    public int[][] solve(){
        if (setQueens(0)){
            printQueens();
            return board;
        } else {
            System.out.println("There is no solution...");
            return null;
        }
    }

    private void printQueens() {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 1){
                    System.out.print(" * ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    private boolean setQueens(int rowIndex){
        if (rowIndex == n){
            return true;
        }

        for (int i = 0; i < n; i++){
            if(isValid(rowIndex,i)){
                board[rowIndex][i] = 1;
                if (setQueens(rowIndex+1)){
                    return true;
                }
                board[rowIndex][i] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int rowIndex, int i) {
        //check the row above
        for(int j = 0; j < rowIndex; j++){
            if(board[j][i] == 1){
                return false;
            }
        }
        //check the row under
        for(int j = rowIndex+1; j < n; j++){
            if (board[j][i] == 1){
                return false;
            }
        }
        //check the column on the left
        for(int j = 0; j < i; j++){
            if (board[rowIndex][j] == 1){
                return false;
            }
        }
        //check the column on the right
        for(int j = i+1; j < n; j++){
            if (board[rowIndex][j] == 1){
                return false;
            }
        }

        //check the diagonal
        for(int j = 1; rowIndex-j >= 0 && i-j >= 0; j++){
            if (board[rowIndex-j][i-j] == 1){
                return false;
            }
        }
        for(int j = 1; rowIndex-j >= 0 && i+j < n; j++){
            if (board[rowIndex-j][i+j] == 1){
                return false;
            }
        }
        for(int j = 1; rowIndex+j < n && i-j >= 0; j++){
            if (board[rowIndex+j][i-j] == 1){
                return false;
            }
        }
        for(int j = 1; rowIndex+j < n && i+j < n; j++){
            if (board[rowIndex+j][i+j] == 1){
                return false;
            }
        }

        return true;
    }
}
