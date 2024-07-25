package dia03.banco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ContaCorrente {

    private long numero;
    private Cliente cliente;
    private double saldo;
    private Date data;
    private List<Extrato> transacoes;

    public ContaCorrente() {
        numero = new Random().nextLong();
        saldo = 0.0;
        data = new Date();
        transacoes = new ArrayList<>();
    }

    public void depositar(double valor) {
        saldo += valor;
        registrarTransacao(valor);
    }

    public boolean sacar(double valor) {
        boolean transacaoRealizada = false;

        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            transacaoRealizada = true;
            registrarTransacao(-valor);
        }
        return transacaoRealizada;
    }

    public void exibirExtrato() {
        System.out.println();

        System.out.println("Extrato da Conta:");
        System.out.println("Número: " + numero);

        for (Extrato extrato : transacoes) {
            System.out.printf("Valor: R$%.2f ( Data: %s )%n", extrato.getValor(), extrato.getData());
        }

        System.out.println();
    }

    public boolean transferir(ContaCorrente contaDestino, double valor) {
        boolean transacaoRealizada = false;

        if (sacar(valor)) {
            contaDestino.depositar(valor);
            transacaoRealizada = true;
            registrarTransacao(-valor);
        }
        return transacaoRealizada;
    }

    private void registrarTransacao(double valor) {
        Extrato extrato = new Extrato(valor);
        transacoes.add(extrato);
    }

    public long getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = new Cliente(cliente.getNome(), cliente.getSobrenome(), cliente.getCpf());
    }

    public double getSaldo() {
        return saldo;
    }

    public Date getData() {
        return data;
    }

}
