package back_end;

public interface IConta {
    void sacar(double valor);

    void depositar(double valor);

    void imprimirExtrato();

    void transferir(double valor, Conta contaDestino);
}
