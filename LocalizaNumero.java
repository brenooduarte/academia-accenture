import java.util.Scanner;

public class LocalizaNumero {

	public static void main(String[] args) {
		int[] vetor = {1,2,3,4,5,6,7,8,9,10};
		boolean achou = false;

		Scanner input = new Scanner(System.in);
		System.out.print("Digite um numero para pesquisar: ");
		int numero = input.nextInt();

		for (int i=0; i<10; i++) {
			if (vetor[i] == numero){
				achou = true;
		    }

			if (achou) {
				System.out.println("Achei");
				System.out.printf("Na Posição %d está localizado do numero %d.", i, vetor[i]);
				break;
			}
		}

	}

}
