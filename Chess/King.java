package Chess;

public class King {
    private String[][] board;
    private int currentRow;
    private int currentColumn;

    public King(String[][] board) {
        this.board = board;
    }

    public void setCurrentPosition(int row, int column) {
        this.currentRow = row;
        this.currentColumn = column;
    }

    public boolean move(int targetRow, int targetColumn) {
        if (isValidMove(targetRow, targetColumn)) {
            board[targetRow][targetColumn] = board[currentRow][currentColumn];
            board[currentRow][currentColumn] = " ";
            currentRow = targetRow;
            currentColumn = targetColumn;
            return true;
        }
        return false;
    }

    public boolean capture(int targetRow, int targetColumn) {
        if (isValidMove(targetRow, targetColumn) && !board[targetRow][targetColumn].isBlank()) {
            board[targetRow][targetColumn] = board[currentRow][currentColumn];
            board[currentRow][currentColumn] = " ";
            currentRow = targetRow;
            currentColumn = targetColumn;
            return true;
        }
        return false;
    }

    private boolean isValidMove(int targetRow, int targetColumn) {
        int rowDiff = Math.abs(targetRow - currentRow);
        int colDiff = Math.abs(targetColumn - currentColumn);
        return (rowDiff <= 1 && colDiff <= 1);
    }
}

