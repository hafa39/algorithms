package backtracking;

public class SudokuSolver {

    private int[][] board;
    private int boardSize ;

    private int sqrtBoardSize;

    public SudokuSolver(int[][] board){
        if (board[0].length != board.length) throw new IllegalArgumentException("Board should be square");
        if (Math.sqrt(board.length) % 1 != 0) throw new IllegalArgumentException("Board should have a square number of rows and columns");
        sqrtBoardSize = (int) Math.sqrt(board.length);
        this.board = board;
        this.boardSize = board.length;
    }

    public static void main(String[] args) {
        //create a 9x9 board
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 0, 0, 1, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        SudokuSolver sudokuSolver = new SudokuSolver(board);
        if (sudokuSolver.solve(0,0)){
            sudokuSolver.printBoard();
        } else {
            System.out.println("There is no solution...");
        }

    }

    private void printBoard() {
        //draw the board with separation quadrants
        for (int i = 0; i < boardSize; i++){
            if (i % sqrtBoardSize == 0 && i != 0){
                for (int j = 0; j < boardSize; j++){
                    System.out.print("- ");
                }
                System.out.println();
            }
            for (int j = 0; j < boardSize; j++){
                if (j % sqrtBoardSize == 0 && j != 0){
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public boolean solve(int row,int col){
        if(row == boardSize - 1 && col == boardSize){
            return true;
        }
        if(col == boardSize){
            row++;
            col = 0;
        }
        if(board[row][col] != 0){
            return solve(row,col+1);
        }
        for(int number = 1; number <= boardSize; number++){
            if(isValid(row,col,number)){
                board[row][col] = number;
                if(solve(row,col+1)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int number) {
        //check the row
        for (int i = 0; i < boardSize; i++){
            if (board[row][i] == number){
                return false;
            }
        }
        //check the column
        for (int i = 0; i < boardSize; i++){
            if (board[i][col] == number){
                return false;
            }
        }
        //check the quadrant
        int sqrtBoardSize = (int) Math.sqrt(boardSize);
        int boxRow = row - row % sqrtBoardSize;
        int boxCol = col - col % sqrtBoardSize;
        for (int i = boxRow; i < boxRow + sqrtBoardSize; i++){
            for (int j = boxCol; j < boxCol + sqrtBoardSize; j++){
                if (board[i][j] == number){
                    return false;
                }
            }
        }
        return true;
    }
}
