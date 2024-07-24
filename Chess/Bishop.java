package Chess;

public class Bishop {

    private String[][] board;
    private int currentRow;
    private int currentColumn;
    private boolean isCapitalLetter;

    public Bishop(String[][] board) {
        this.board = board;
        this.isCapitalLetter = false;
    }

    public boolean move(int targetRow, int targetColumn) {
        boolean moved = false;

        if (Math.abs(targetRow - currentRow) == Math.abs(targetColumn - currentColumn)) {
            if (isPathClear(targetRow, targetColumn)) {
                board[targetRow][targetColumn] = board[currentRow][currentColumn];
                board[currentRow][currentColumn] = " ";
                currentRow = targetRow;
                currentColumn = targetColumn;
                moved = true;
            }
        }

        return moved;
    }

    public boolean capture(int targetRow, int targetColumn) {
        boolean captured = false;

        if (Math.abs(targetRow - currentRow) == Math.abs(targetColumn - currentColumn) && !board[targetRow][targetColumn].isBlank()) {
            if (isPathClear(targetRow, targetColumn)) {
                board[targetRow][targetColumn] = board[currentRow][currentColumn];
                board[currentRow][currentColumn] = " ";
                currentRow = targetRow;
                currentColumn = targetColumn;
                captured = true;
            }
        }

        return captured;
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

    public void setCapitalLetter(String letter) {
        if (letter.equals("b")) {
            this.isCapitalLetter = false;
        } else if (letter.equals("B")) {
            this.isCapitalLetter = true;
        }
    }

    public void setCurrentPosition(int row, int column) {
        this.currentRow = row;
        this.currentColumn = column;
    }

}
