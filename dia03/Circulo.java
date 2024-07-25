package dia03;

import javax.swing.*;

public class Circulo {

    private double raio;
    private double area;
    private double perimetro;

    public Circulo() {}

    public Circulo(double raio) {
        this.raio = raio;
    }

    public void calcularArea() {
        area = Math.PI * Math.pow(raio, 2);
    }

    public void calcularPerimetro() {
        perimetro = 2 * Math.PI * raio;
    }

    public double getRaio() {
        return raio;
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    // metodo Main
    public static void main(String[] args) {
        double raio = Double.parseDouble(JOptionPane.showInputDialog("Digite um RAIO para o circulo: "));

        Circulo circulo = new Circulo(raio);

        circulo.calcularArea();
        double area = circulo.getArea();

        JOptionPane.showMessageDialog(null, "O circulo com raio de " + raio + " tem area de AREA de: " + area);

        circulo.calcularPerimetro();
        double perimetro = circulo.getPerimetro();

        JOptionPane.showMessageDialog(null, "O circulo com raio de " + raio + " tem area de PERIMETRO de: " + perimetro);
    }

}


