import java.util.Scanner;

public class JogoDaVelha {
		
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String[][] tabuleiro = { 
						{" "," "," "},
						{" "," "," "},
						{" "," "," "}
		};

		int indiceLinha = 0;
		int indiceColuna = 0;
		int numeroJogador = 1;

		String circulo = "〇";
		String xis = "X";

		boolean partidaEmAndamento = true;
		int contadorJogadas = 0;

		do {		
			imprimirTabuleiro(tabuleiro);

			boolean posicaoOcupada;

			do {
				System.out.printf("Jogador %d, digite sua posição:\n", numeroJogador);
				System.out.print("Linha: ");
				indiceLinha = input.nextInt();

				System.out.print("Coluna: ");
				indiceColuna = input.nextInt();

				posicaoOcupada = !tabuleiro[indiceLinha][indiceColuna].isBlank();

				System.out.println();
			} while (posicaoOcupada);

			if (numeroJogador == 1) {
				tabuleiro[indiceLinha][indiceColuna] = circulo;
				numeroJogador = 2;
			} else {
				tabuleiro[indiceLinha][indiceColuna] = xis;
				numeroJogador = 1;
			}
			
			if (contadorJogadas > 4) {
				partidaEmAndamento = !verificarVencedor(tabuleiro);
			}

			contadorJogadas++;

			if (contadorJogadas == 9) {
				System.out.println("O jogo deu EMPATE!");
				partidaEmAndamento = false;
			}

		} while (partidaEmAndamento);
	}

	private static void imprimirTabuleiro(String[][] tabuleiro) {
		System.out.print("\n\n 0   1    2\n\n");
		for (int posicao1 = 0; posicao1 < 3; posicao1++) {
			for (int posicao2 = 0; posicao2 < 3; posicao2++) {
				System.out.print(" " + tabuleiro[posicao1][posicao2]);
				if (posicao2 < 2) {
					System.out.print(" | ");
				}
				if (posicao2 == 2) {
					System.out.print("  " + posicao1);
				}
			}
			if (posicao1 < 2) {
				System.out.print("\n------------");
			}
			System.out.println("\n");
		}
	}

	public static boolean verificarVencedor(String[][] tabuleiro) {
		for (int i = 0; i < 3; i++) {
			if (verificarLinha(tabuleiro, i) || verificarColuna(tabuleiro, i)) {
				return true;
			}
		}

		return verificarDiagonalPrincipal(tabuleiro) || verificarDiagonalSecundaria(tabuleiro);
	}

	private static boolean verificarLinha(String[][] tabuleiro, int linha) {
		return !tabuleiro[linha][0].isBlank() &&
				tabuleiro[linha][0].equals(tabuleiro[linha][1]) &&
				tabuleiro[linha][1].equals(tabuleiro[linha][2]);
	}

	private static boolean verificarColuna(String[][] tabuleiro, int coluna) {
		return !tabuleiro[0][coluna].isBlank() &&
				tabuleiro[0][coluna].equals(tabuleiro[1][coluna]) &&
				tabuleiro[1][coluna].equals(tabuleiro[2][coluna]);
	}

	private static boolean verificarDiagonalPrincipal(String[][] tabuleiro) {
		return !tabuleiro[0][0].isBlank() &&
				tabuleiro[0][0].equals(tabuleiro[1][1]) &&
				tabuleiro[1][1].equals(tabuleiro[2][2]);
	}

	private static boolean verificarDiagonalSecundaria(String[][] tabuleiro) {
		return !tabuleiro[0][2].isBlank() &&
				tabuleiro[0][2].equals(tabuleiro[1][1]) &&
				tabuleiro[1][1].equals(tabuleiro[2][0]);
	}

}
