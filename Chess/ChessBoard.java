package Chess;

import java.util.Scanner;

public class ChessBoard {

    static int chosenNumber;
    static int targetRow;
    static int targetColumn;

    public static void main(String[] args) {

        String[][] board = {
                {"R","N","B","Q","K","B","N","R"},
                {"P","P","P","P","P","P","P","P"},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {"p","p","p","p","p","p","p","p"},
                {"r","n","b","q","k","b","n","r"}
        };

        Scanner input = new Scanner(System.in);

        int player = 1;

        Pawn pawn = new Pawn(board);
        Bishop bishop = new Bishop(board);
        Knight knight = new Knight(board);
        Rook rook = new Rook(board);
        King king = new King(board);
        Queen queen = new Queen(board);

        do {
            printBoard(board);

            System.out.println("( p/P ) para Peão\n( b/B ) para Bispo\n" +
                    "( n/N ) para Cavalo\n( r/R ) para Torre\n( q/Q ) para Rainha\n( k/K ) para Rei\n");
            System.out.printf("Digite qual PEÇA jogador %d irá jogar: ", player);
            String chosenPiece = input.nextLine();

            System.out.println("\nDigite a posição atual da peça:");
            System.out.print("Linha: ");
            int row = Integer.parseInt(input.nextLine());
            System.out.print("Coluna: ");
            int column = Integer.parseInt(input.nextLine());

            switch (chosenPiece) {
                case "p", "P" -> {
                    pawn.setCapitalLetter(chosenPiece);
                    pawn.setCurrentPosition(row, column);

                    System.out.print("\n1. para Avançar\n2. para Avançar 2 casas\n3. para Capturar peça\nDigite: ");
                    chosenNumber = Integer.parseInt(input.nextLine());

                    switch (chosenNumber) {
                        case 1 -> pawn.advance();
                        case 2 -> pawn.advanceTwoSquares();
                        case 3 -> {
                            System.out.print("Linha do target: ");
                            int targetRow = Integer.parseInt(input.nextLine());
                            System.out.print("Coluna do target: ");
                            int targetColumn = Integer.parseInt(input.nextLine());
                            pawn.capture(targetRow, targetColumn);
                        }
                    }
                }
                case "b", "B" -> {
                    bishop.setCapitalLetter(chosenPiece);
                    bishop.setCurrentPosition(row, column);
                    printTargetPosition(input);
                    bishop.capture(targetRow, targetColumn);
                    switch (chosenNumber) {
                        case 1 -> bishop.move(targetRow, targetColumn);
                        case 2 -> bishop.capture(targetRow, targetColumn);
                    }
                }
                case "n", "N" -> {
                    knight.setCurrentPosition(row, column);
                    printTargetPosition(input);
                    bishop.capture(targetRow, targetColumn);
                    switch (chosenNumber) {
                        case 1 -> knight.move(targetRow, targetColumn);
                        case 2 -> knight.capture(targetRow, targetColumn);
                    }
                }
                case "r", "R" -> {
                    rook.setCurrentPosition(row, column);
                    printTargetPosition(input);
                    rook.capture(targetRow, targetColumn);
                    switch (chosenNumber) {
                        case 1 -> rook.move(targetRow, targetColumn);
                        case 2 -> rook.capture(targetRow, targetColumn);
                    }
                }
                case "k", "K" -> {
                    king.setCurrentPosition(row, column);
                    printTargetPosition(input);
                    king.capture(targetRow, targetColumn);
                    switch (chosenNumber) {
                        case 1 -> king.move(targetRow, targetColumn);
                        case 2 -> king.capture(targetRow, targetColumn);
                    }
                }
                case "q", "Q" -> {
                    queen.setCurrentPosition(row, column);
                    printTargetPosition(input);
                    queen.capture(targetRow, targetColumn);
                    switch (chosenNumber) {
                        case 1 -> queen.move(targetRow, targetColumn);
                        case 2 -> queen.capture(targetRow, targetColumn);
                    }
                }
            }

            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }


        } while (true);

    }

    private static void printTargetPosition(Scanner input) {
        System.out.print("\n1. para Mover\n2. para Capturar peça\nDigite: ");
        chosenNumber = Integer.parseInt(input.nextLine());

        System.out.print("Linha do target: ");
        targetRow = Integer.parseInt(input.nextLine());
        System.out.print("Coluna do target: ");
        targetColumn = Integer.parseInt(input.nextLine());
    }

    public static void printBoard(String[][] board) {
        System.out.println("\n       TABULEIRO");
        for (int i = 0; i < board.length; i++) {
            System.out.printf("%d  ", i);
        }
        System.out.println("\n------------------------");
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+"  ");
            }
            System.out.println(" |   " + i);
        }
        System.out.println("------------------------");
    }
}