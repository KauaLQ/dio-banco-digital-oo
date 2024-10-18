package back_end;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    private List<String> transacoes;

    private String nome;

    public Conta(String nome) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.nome = nome;
        this.transacoes = new ArrayList<>();
    }

    //getters
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public int getAgencia() {
        return agencia;
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor && valor > 0) {
            saldo -= valor;
            String novaTransacao = "Saída:.............. -" + valor;
            transacoes.add(novaTransacao);
        }
        else {
            JOptionPane.showMessageDialog(null, "Este valor não está\ndisponível para saque!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        String novaTransacao = "Entrada:.......... +" + valor;
        transacoes.add(novaTransacao);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            JOptionPane.showMessageDialog(null, "Transferência realizada para " + contaDestino.nome + "\n" + "Número da Conta: " + contaDestino.numero + "\n" + "Valor: R$" + valor, "Comprovante", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Este valor não está\ndisponível para transferência!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void imprimirExtrato() {
        if (!transacoes.isEmpty()){
            String transacoesFormatas = String.join("\n", transacoes); // concatenação dos elementos do ArrayList para melhor visualização
            JOptionPane.showMessageDialog(null, "Titular: " + this.nome + " | " + "Conta: " + this.numero + " | " + "Saldo: R$" + this.saldo + "\n" + "--------------------------------------------" + "\n" + transacoesFormatas, "Trasações", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Nenhuma transação realizada até o momeento.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "\ntransacoes: " + transacoes +
                "\n";
    }
}
