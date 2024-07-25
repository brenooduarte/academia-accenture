package dia03.banco;

import java.util.Date;

public class Extrato {

    private double valor;
    private Date data;

    public Extrato(double valor) {
        this.valor = valor;
        this.data = new Date();
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }
}
