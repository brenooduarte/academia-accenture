package dia03.banco;

public class PrincipalContaCorrente {
    public static void main(String[] args) {
        Cliente clienteBreno = new Cliente("Breno", "Duarte", "000.120.561-89");
        ContaCorrente conta1 = new ContaCorrente();
        conta1.setCliente(clienteBreno);

        conta1.depositar(1000);
        System.out.println(conta1.getCliente().getNome() + " DEPOSITOU: R$" + conta1.getSaldo());

        conta1.sacar(300);
        System.out.println(conta1.getCliente().getNome() + " SACOU: R$" + conta1.getSaldo());

        conta1.exibirExtrato();

        Cliente clienteThiago = new Cliente("Thiago", "Duarte", "070.868.655-89");
        ContaCorrente conta2 = new ContaCorrente();
        conta2.setCliente(clienteThiago);

        conta2.depositar(300);
        System.out.println(conta2.getCliente().getNome() + " DEPOSITOU: R$" + conta2.getSaldo());

        conta2.transferir(conta1, 300);
        System.out.println(conta2.getCliente().getNome() +
                " fez TRANSFERENCIA para " + conta1.getCliente().getNome() +
                " de R$" + conta2.getSaldo());

        conta2.exibirExtrato();

    }
}
