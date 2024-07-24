package Chess;

import java.util.Objects;

public class Pawn {

    private String[][] board;
    private int currentRow;
    private int currentColumn;
    private boolean isFirstMovement;
    private boolean isCapitalLetter;

    public Pawn(String[][] board) {
        this.board = board;
        this.isFirstMovement = false;
        this.isCapitalLetter = false;
    }

    public boolean advance() {
        boolean advanced = false;

        if (isCapitalLetter) {
            if (board[currentRow+1][currentColumn].isBlank()) {
                board[currentRow+1][currentColumn] = board[currentRow][currentColumn];
                board[currentRow][currentColumn] = " ";
                currentRow++;

                advanced = true;
            }
        } else {
            if (board[currentRow-1][currentColumn].isBlank()) {
                board[currentRow-1][currentColumn] = board[currentRow][currentColumn];
                board[currentRow][currentColumn] = " ";
                currentRow--;

                advanced = true;
            }
        }

        return advanced;
    }

    public boolean advanceTwoSquares() {
        boolean advanced = false;

        if (this.isFirstMovement) {
            if (isCapitalLetter) {
                if (board[currentRow + 1][currentColumn].isBlank() && board[currentRow + 2][currentColumn].isBlank()) {
                    board[currentRow + 2][currentColumn] = board[currentRow][currentColumn];
                    board[currentRow][currentColumn] = " ";
                    currentRow = currentRow + 2;

                    advanced = true;
                }
            } else {
                if (board[currentRow - 1][currentColumn].isBlank() && board[currentRow - 2][currentColumn].isBlank()) {
                    board[currentRow - 2][currentColumn] = board[currentRow][currentColumn];
                    board[currentRow][currentColumn] = " ";
                    currentRow = currentRow - 2;

                    advanced = true;
                }
            }
        }

        return advanced;
    }

    public boolean capture(int targetRow, int targetColumn) {
        boolean captured = false;
        boolean targetIsNotBlank = !board[targetRow][targetColumn].isBlank();

        if (isCapitalLetter) {
            if (targetRow == currentRow + 1 && (targetColumn == currentColumn - 1 || targetColumn == currentColumn + 1)) {
                if (targetIsNotBlank) {
                    board[targetRow][targetColumn] = board[currentRow][currentColumn];
                    board[currentRow][currentColumn] = " ";
                    currentRow = targetRow;
                    currentColumn = targetColumn;

                    captured = true;
                }
            }
        } else {
            if (targetRow == currentRow - 1 && (targetColumn == currentColumn - 1 || targetColumn == currentColumn + 1)) {
                if (targetIsNotBlank) {
                    board[targetRow][targetColumn] = board[currentRow][currentColumn];
                    board[currentRow][currentColumn] = " ";
                    currentRow = targetRow;
                    currentColumn = targetColumn;

                    captured = true;
                }
            }
        }

        return captured;
    }

    public void setCapitalLetter(String letter) {
        if (letter.equals("p")) {
            this.isCapitalLetter = false;
        } else if (letter.equals("P")) {
            this.isCapitalLetter = true;
        }
    }

    public void setCurrentPosition(int row, int column) {
        this.currentRow = row;
        this.currentColumn = column;

        if (Objects.equals(board[currentRow][currentColumn], "P") && currentRow == 1) {
            this.isFirstMovement = true;
        }

        if (Objects.equals(board[currentRow][currentColumn], "p") && currentRow == 6) {
            this.isFirstMovement = true;
        }
    }

}
