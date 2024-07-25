package dia03;

import javax.swing.*;

public class Retangulo {

    private double lado1;
    private double lado2;
    private double area;
    private double perimetro;

    public Retangulo() {}

    public Retangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public void calcularArea() {
        area = lado1 * lado2;
    }

    public void calcularPerimetro() {
        perimetro = (lado1 * 2) + (lado2 * 2);
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public static void main(String[] args) {
        double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite uma ALTURA para o Retangulo: "));
        double base = Double.parseDouble(JOptionPane.showInputDialog("Digite uma BASE para o Retangulo: "));

        Retangulo retangulo = new Retangulo(altura, base);

        retangulo.calcularArea();
        double area = retangulo.getArea();

        JOptionPane.showMessageDialog(null, "O Retangulo com altura de " + altura + " e base de " + base + " tem AREA de: " + area);

        retangulo.calcularPerimetro();
        double perimetro = retangulo.getPerimetro();

        JOptionPane.showMessageDialog(null, "O Retangulo com altura de " + altura + " e base de " + base + " tem PERIMETRO de: " + perimetro);
    }
}
