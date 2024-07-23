import java.util.Scanner;

public class BoxOffice {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int SEAT_PRICE_CLASS_A = 50;
        int SEAT_PRICE_CLASS_B = 30;
        int SEAT_PRICE_CLASS_C = 20;

        int qtyClassA, qtyClassB, qtyClassC, totalTicketsSold = 0;

        System.out.println("===== Bilheteria =====");
        System.out.println("Temos 3 categorias de assentos");
        System.out.println();

        System.out.print("Digite quantos bilhetes venderam CLASSE A: ");
        qtyClassA = input.nextInt();

        System.out.print("Digite quantos bilhetes venderam CLASSE B: ");
        qtyClassB = input.nextInt();

        System.out.print("Digite quantos bilhetes venderam CLASSE C: ");
        qtyClassC = input.nextInt();

        int revenueClassA = qtyClassA * SEAT_PRICE_CLASS_A;
        int revenueClassB = qtyClassB * SEAT_PRICE_CLASS_B;
        int revenueClassC = qtyClassC * SEAT_PRICE_CLASS_C;

        totalTicketsSold = revenueClassA + revenueClassB + revenueClassC;

        System.out.println();
        System.out.println("Valor da renda dos bilhetes vendidos:");
        System.out.printf("Classe A: %d\n", (revenueClassA));
        System.out.printf("Classe B: %d\n", (revenueClassB));
        System.out.printf("Classe C: %d\n", (revenueClassC));

        System.out.printf("Total da renda: %d", totalTicketsSold);
    }

}
