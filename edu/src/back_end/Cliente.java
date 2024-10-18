package back_end;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Cliente {
    //atributos
    private Map<Integer, Conta> clienteMap;

    //construtor

    public Cliente() {
        this.clienteMap = new HashMap<>();
    }

    public void adicionarContaCorrente (Integer cpf, String nome){
        clienteMap.put(cpf, new ContaCorrente(nome));
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Nova conta corrente", JOptionPane.INFORMATION_MESSAGE);
    }

    public void adicionarContaPoupanca (Integer cpf, String nome){
        clienteMap.put(cpf, new ContaPoupanca(nome));
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Nova conta poupança", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean verificarCliente (Integer cpf) {
        if (!clienteMap.isEmpty()) {
            if (clienteMap.containsKey(cpf)){
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Insira um CPF válido!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public Conta buscarContaPeloNumero (int numeroDestino){
        Conta contaEncontrada = null;
        for (Conta c : clienteMap.values()) {
            if (c.getNumero() == numeroDestino){
                contaEncontrada = c;
                break;
            }
        }
        return contaEncontrada;
    }

    public Conta capturarDadosPeloCPF (Integer cpf) {
        return clienteMap.get(cpf);
    }
}
