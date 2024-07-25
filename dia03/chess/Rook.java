package dia03.chess;

public class Rook {
    private String[][] board;
    private int currentRow;
    private int currentColumn;

    public Rook(String[][] board) {
        this.board = board;
    }

    public void setCurrentPosition(int row, int column) {
        this.currentRow = row;
        this.currentColumn = column;
    }

    public boolean move(int targetRow, int targetColumn) {
        if (isValidMove(targetRow, targetColumn) && isPathClear(targetRow, targetColumn)) {
            board[targetRow][targetColumn] = board[currentRow][currentColumn];
            board[currentRow][currentColumn] = " ";
            currentRow = targetRow;
            currentColumn = targetColumn;
            return true;
        }
        return false;
    }

    public boolean capture(int targetRow, int targetColumn) {
        if (isValidMove(targetRow, targetColumn) && isPathClear(targetRow, targetColumn) && !board[targetRow][targetColumn].isBlank()) {
            board[targetRow][targetColumn] = board[currentRow][currentColumn];
            board[currentRow][currentColumn] = " ";
            currentRow = targetRow;
            currentColumn = targetColumn;
            return true;
        }
        return false;
    }

    private boolean isValidMove(int targetRow, int targetColumn) {
        return targetRow == currentRow || targetColumn == currentColumn;
    }

    private boolean isPathClear(int targetRow, int targetColumn) {
        int rowDirection = Integer.compare(targetRow, currentRow);
        int colDirection = Integer.compare(targetColumn, currentColumn);

        int row = currentRow + rowDirection;
        int col = currentColumn + colDirection;

        while (row != targetRow || col != targetColumn) {
            if (!board[row][col].isBlank()) {
                return false;
            }
            row += rowDirection;
            col += colDirection;
        }

        return true;
    }
}
