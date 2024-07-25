package dia03.chess;

import javax.swing.*;

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

        int player = 1;

        Pawn pawn = new Pawn(board);
        Bishop bishop = new Bishop(board);
        Knight knight = new Knight(board);
        Rook rook = new Rook(board);
        King king = new King(board);
        Queen queen = new Queen(board);

        do {
            printBoard(board);

            String chosenPiece = JOptionPane.showInputDialog(
                String.format("""
                        ( p/P ) para Peão
                        ( b/B ) para Bispo
                        ( n/N ) para Cavalo
                        ( r/R ) para Torre
                        ( q/Q ) para Rainha
                        ( k/K ) para Rei
                        
                        Digite qual PEÇA jogador %d irá jogar:""", player)
            );

            int row = Integer.parseInt(
                JOptionPane.showInputDialog("""
                        Digite a posição ATUAL da peça:
                        
                        Linha:""")
            );
            int column = Integer.parseInt(
                JOptionPane.showInputDialog("""
                        Digite a posição ATUAL da peça:
                        
                        Coluna:""")
            );

            switch (chosenPiece) {
                case "p", "P" -> {
                    pawn.setCapitalLetter(chosenPiece);
                    pawn.setCurrentPosition(row, column);

                    chosenNumber = Integer.parseInt(
                        JOptionPane.showInputDialog("""
                                1. para Avançar
                                2. para Avançar 2 casas
                                3. para Capturar peça
                                
                                Digite:""")
                    );

                    switch (chosenNumber) {
                        case 1 -> pawn.advance();
                        case 2 -> pawn.advanceTwoSquares();
                        case 3 -> {
                            targetRow = Integer.parseInt(
                                JOptionPane.showInputDialog("""
                                        Digite a posição DESTINO da peça:
                                        
                                        Linha:""")
                            );

                            targetColumn = Integer.parseInt(
                                JOptionPane.showInputDialog("""
                                        Digite a posição DESTINO da peça:
                                        
                                        Coluna:""")
                            );

                            pawn.capture(targetRow, targetColumn);
                        }
                    }
                }
                case "b", "B" -> {
                    bishop.setCapitalLetter(chosenPiece);
                    bishop.setCurrentPosition(row, column);

                    printTargetPosition();

                    switch (chosenNumber) {
                        case 1 -> bishop.move(targetRow, targetColumn);
                        case 2 -> bishop.capture(targetRow, targetColumn);
                    }
                }
                case "n", "N" -> {
                    knight.setCurrentPosition(row, column);

                    printTargetPosition();

                    switch (chosenNumber) {
                        case 1 -> knight.move(targetRow, targetColumn);
                        case 2 -> knight.capture(targetRow, targetColumn);
                    }
                }
                case "r", "R" -> {
                    rook.setCurrentPosition(row, column);

                    printTargetPosition();

                    switch (chosenNumber) {
                        case 1 -> rook.move(targetRow, targetColumn);
                        case 2 -> rook.capture(targetRow, targetColumn);
                    }
                }
                case "k", "K" -> {
                    king.setCurrentPosition(row, column);

                    printTargetPosition();

                    switch (chosenNumber) {
                        case 1 -> king.move(targetRow, targetColumn);
                        case 2 -> king.capture(targetRow, targetColumn);
                    }
                }
                case "q", "Q" -> {
                    queen.setCurrentPosition(row, column);

                    printTargetPosition();

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

    private static void printTargetPosition() {
        chosenNumber = Integer.parseInt(
            JOptionPane.showInputDialog("""
                    1. para Avançar
                    2. para Capturar peça
                    
                    Digite:""")
        );

        targetRow = Integer.parseInt(
            JOptionPane.showInputDialog("""
                    Digite a posição de DESTINO da peça:
                    
                    Linha:""")
        );

        targetColumn = Integer.parseInt(
            JOptionPane.showInputDialog("""
                    Digite a posição de DESTINO da peça:
                    
                    Coluna:""")
        );
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