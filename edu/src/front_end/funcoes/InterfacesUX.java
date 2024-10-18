package front_end.funcoes;
import back_end.Cliente;
import back_end.Conta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InterfacesUX {
    ImageIcon logo_dio = new ImageIcon("C:\\BootCampJava\\JavaBasico\\dio-banco-digital-oo\\edu\\src\\img\\logo_dio.jpg");
    ImageIcon logo_deposito = new ImageIcon("C:\\BootCampJava\\JavaBasico\\dio-banco-digital-oo\\edu\\src\\img\\logo_deposito.png");
    ImageIcon logo_saque = new ImageIcon("C:\\BootCampJava\\JavaBasico\\dio-banco-digital-oo\\edu\\src\\img\\logo_saque.png");
    ImageIcon logo_pix = new ImageIcon("C:\\BootCampJava\\JavaBasico\\dio-banco-digital-oo\\edu\\src\\img\\logo_pix.png");
    ImageIcon logo_extrato = new ImageIcon("C:\\BootCampJava\\JavaBasico\\dio-banco-digital-oo\\edu\\src\\img\\logo_extrato.png");
    Conta dadosConta;
    Cliente cliente = new Cliente();
    Color corHexadecimal = Color.decode("#6495ED");
    Color corBotoes = Color.decode("#B3CEFF");

    public void sacarValor () {
        JDialog dialog = new JDialog();
        dialog.setTitle("Saque seu dinheiro agora!");
        dialog.setSize(250, 100);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);  // Centraliza a janela
        dialog.getContentPane().setBackground(corHexadecimal); // Mudança da cor de fundo para azul
        dialog.setIconImage(logo_dio.getImage());

        JLabel textoValor = new JLabel("Valor (R$): ");
        textoValor.setForeground(Color.WHITE);

        JTextField campoValor = new JTextField("0.00");

        JButton sacarBtt = new JButton("Sacar");
        JButton cancelaBtt = new JButton("Cancelar");

        JPanel panelGBC = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panelGBC.setBackground(corHexadecimal);

        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Expande horizontalmente
        panelGBC.add(textoValor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        panelGBC.add(campoValor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.anchor = GridBagConstraints.LINE_END; // Alinhar à direita
        panelGBC.add(sacarBtt, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.anchor = GridBagConstraints.LINE_START; // Alinhar à esquerda
        panelGBC.add(cancelaBtt, gbc);

        dialog.add(panelGBC);
        dialog.setVisible(true);

        sacarBtt.addActionListener(l -> {
            try {
                double valorSaque = Double.parseDouble(campoValor.getText());
                dadosConta.sacar(valorSaque);
                if (dadosConta.getSaldo() >= valorSaque && valorSaque > 0) {
                    JOptionPane.showMessageDialog(null, "Saque de " + valorSaque + " realizado com sucesso!", "Informe", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                    usarConta();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelaBtt.addActionListener(l -> {
            dialog.dispose();
            usarConta();
        });
    }

    public void depositarValor () {
        JDialog dialog = new JDialog();
        dialog.setTitle("Deposite seu dinheiro!");
        dialog.setSize(250, 100);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);  // Centraliza a janela
        dialog.getContentPane().setBackground(corHexadecimal); // Mudança da cor de fundo para azul
        dialog.setIconImage(logo_dio.getImage());

        JLabel textoValor = new JLabel("Valor (R$): ");
        textoValor.setForeground(Color.WHITE);

        JTextField campoValor = new JTextField("0.00");

        JButton depositarBtt = new JButton("Depositar");
        JButton cancelaBtt = new JButton("Cancelar");

        JPanel panelGBC = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panelGBC.setBackground(corHexadecimal);

        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Expande horizontalmente
        panelGBC.add(textoValor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        panelGBC.add(campoValor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.anchor = GridBagConstraints.LINE_END; // Alinhar à direita
        panelGBC.add(depositarBtt, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.anchor = GridBagConstraints.LINE_START; // Alinhar à esquerda
        panelGBC.add(cancelaBtt, gbc);

        dialog.add(panelGBC);
        dialog.setVisible(true);

        depositarBtt.addActionListener(l -> {
            try {
                double valorDeposito = Double.parseDouble(campoValor.getText());
                dadosConta.depositar(valorDeposito);
                JOptionPane.showMessageDialog(null, "Deposito de " + valorDeposito + " realizado com sucesso!", "Informe", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
                usarConta();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira apenas números!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelaBtt.addActionListener(l -> {
            dialog.dispose();
            usarConta();
        });
    }

    public void transferirValor () {
        JDialog dialog = new JDialog();
        dialog.setTitle("Área Pix");
        dialog.setSize(250, 150);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);  // Centraliza a janela
        dialog.getContentPane().setBackground(corHexadecimal); // Mudança da cor de fundo para azul
        dialog.setIconImage(logo_dio.getImage());

        JLabel textoValor = new JLabel("Valor (R$): ");
        textoValor.setForeground(Color.WHITE);

        JTextField campoValor = new JTextField("0.00");

        JLabel textoNumeroBanco = new JLabel("Conta Destino: ");
        textoNumeroBanco.setForeground(Color.WHITE);

        JTextField campoNumeroBanco = new JTextField();

        JButton transferirBtt = new JButton("Transferir");
        JButton cancelaBtt = new JButton("Cancelar");

        JPanel panelGBC = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panelGBC.setBackground(corHexadecimal);

        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Expande horizontalmente
        panelGBC.add(textoValor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        panelGBC.add(campoValor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Expande horizontalmente
        panelGBC.add(textoNumeroBanco, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        panelGBC.add(campoNumeroBanco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.anchor = GridBagConstraints.LINE_END; // Alinhar à direita
        panelGBC.add(transferirBtt, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.anchor = GridBagConstraints.LINE_START; // Alinhar à esquerda
        panelGBC.add(cancelaBtt, gbc);

        dialog.add(panelGBC);
        dialog.setVisible(true);

        transferirBtt.addActionListener(l -> {
            try {
                double valorPix = Double.parseDouble(campoValor.getText());
                int numeroConta = Integer.parseInt(campoNumeroBanco.getText());
                Conta novaConta = cliente.buscarContaPeloNumero(numeroConta);

                if (novaConta != null) {
                    int novaContaNumero = novaConta.getNumero();
                    String novaContaNome = novaConta.getNome();

                    JDialog dialogConfirm = new JDialog();
                    dialogConfirm.setTitle("Confirmação do Pix");
                    dialogConfirm.setSize(300, 125);
                    dialogConfirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialogConfirm.setLocationRelativeTo(null);  // Centraliza a janela
                    dialogConfirm.setLayout(new BorderLayout());  // Define o layout do JDialog
                    dialogConfirm.getContentPane().setBackground(corHexadecimal); // Mudança da cor de fundo para azul
                    dialogConfirm.setIconImage(logo_dio.getImage());

                    JLabel pergunta = new JLabel("Deseja continuar a transferência?", SwingConstants.CENTER);
                    pergunta.setForeground(Color.WHITE);  // Mudança da cor do texto para branco
                    dialogConfirm.add(pergunta);

                    JLabel destinatario = new JLabel("Destinatário: " + novaContaNome);
                    destinatario.setForeground(Color.WHITE);

                    JLabel conta = new JLabel("Conta: " + novaContaNumero);
                    conta.setForeground(Color.WHITE);

                    JPanel panelLabels = new JPanel();
                    panelLabels.setLayout(new FlowLayout());
                    panelLabels.setBackground(corHexadecimal);
                    panelLabels.add(destinatario);
                    panelLabels.add(conta);

                    JButton continuarBtt = new JButton("Sim");
                    JButton voltarBtt = new JButton("Não");

                    JPanel painelBotoes = new JPanel();
                    painelBotoes.setLayout(new FlowLayout());
                    painelBotoes.setBackground(corHexadecimal);
                    painelBotoes.add(continuarBtt);
                    painelBotoes.add(voltarBtt);

                    // Adiciona o painel de botões ao JDialog na parte inferior
                    dialogConfirm.add(panelLabels, BorderLayout.NORTH);
                    dialogConfirm.add(painelBotoes, BorderLayout.SOUTH);
                    dialogConfirm.setVisible(true);

                    continuarBtt.addActionListener(l2 -> {
                        dadosConta.transferir(valorPix, novaConta);
                        dialogConfirm.dispose();
                        dialog.dispose();
                        usarConta();
                    });
                    voltarBtt.addActionListener(l3 -> dialogConfirm.dispose());
                } else {
                    JOptionPane.showMessageDialog(null, "Este número de conta não existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira apenas números!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelaBtt.addActionListener(l -> {
            dialog.dispose();
            usarConta();
        });
    }

    public void usarConta (){
        int agenciaConta = dadosConta.getAgencia();
        int numeroConta = dadosConta.getNumero();
        double saldoConta = dadosConta.getSaldo();
        String nomeConta = dadosConta.getNome();

        String saldoContaText = String.valueOf(saldoConta);
        int tamanhoSaldoConta = saldoContaText.length();

        JDialog dialog = new JDialog();
        dialog.setTitle("Banco DIO | Agência " + agenciaConta);
        dialog.setSize(250, 220);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);  // Centraliza a janela
        dialog.setLayout(new BorderLayout());  // Define o layout do JDialog
        dialog.getContentPane().setBackground(corHexadecimal); // Mudança da cor de fundo para azul
        dialog.setIconImage(logo_dio.getImage());

        JLabel saudacao = new JLabel("Olá, " + nomeConta + "!");
        saudacao.setForeground(Color.WHITE);
        JLabel numero = new JLabel("Número da conta: " + numeroConta);
        numero.setForeground(Color.WHITE);

        JPasswordField campoSaldo = new JPasswordField("R$ " + saldoContaText, tamanhoSaldoConta + 1);
        campoSaldo.setBackground(corHexadecimal);
        campoSaldo.setForeground(Color.WHITE);
        campoSaldo.setEnabled(false);

        // Criando o JCheckBox para mostrar ou ocultar a senha
        JCheckBox mostrarSaldo = new JCheckBox("Mostrar saldo");
        mostrarSaldo.setBackground(corHexadecimal);
        mostrarSaldo.setForeground(Color.WHITE);

        JButton sacarBtt = new JButton("Saque", logo_saque);
        sacarBtt.setVerticalTextPosition(SwingConstants.BOTTOM);
        sacarBtt.setHorizontalTextPosition(SwingConstants.CENTER);
        sacarBtt.setBackground(corBotoes);

        JButton depositarBtt = new JButton("Depósito", logo_deposito);
        depositarBtt.setVerticalTextPosition(SwingConstants.BOTTOM);
        depositarBtt.setHorizontalTextPosition(SwingConstants.CENTER);
        depositarBtt.setBackground(corBotoes);

        JButton pixBtt = new JButton("Pix", logo_pix);
        pixBtt.setVerticalTextPosition(SwingConstants.BOTTOM);
        pixBtt.setHorizontalTextPosition(SwingConstants.CENTER);
        pixBtt.setBackground(corBotoes);

        JButton extratoBtt = new JButton("Extrato", logo_extrato);
        extratoBtt.setVerticalTextPosition(SwingConstants.BOTTOM);
        extratoBtt.setHorizontalTextPosition(SwingConstants.CENTER);
        extratoBtt.setBackground(corBotoes);

        JButton voltarBtt = new JButton("Início");

        JPanel panelGBC = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panelGBC.setBackground(corHexadecimal);

        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.5; // Expande horizontalmente
        gbc.anchor = GridBagConstraints.LINE_START; // Alinhar à direita
        panelGBC.add(saudacao, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.LINE_START; // Alinhar à direita
        panelGBC.add(numero, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.5; // Expande horizontalmente
        gbc.anchor = GridBagConstraints.LINE_START; // Alinhar à direita
        panelGBC.add(campoSaldo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.LINE_START; // Alinhar à direita
        panelGBC.add(mostrarSaldo, gbc);

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBotoes.setBackground(corHexadecimal);
        panelBotoes.add(sacarBtt);
        panelBotoes.add(depositarBtt);
        panelBotoes.add(pixBtt);
        panelBotoes.add(extratoBtt);

        JPanel panelInicio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInicio.setBackground(corHexadecimal);
        panelInicio.add(voltarBtt);

        // Criando um JScrollPane com rolagem horizontal
        JScrollPane scrollPane = new JScrollPane(panelBotoes);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Habilitando a barra de rolagem horizontal sempre
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Somente rolagem horizontal

        dialog.add(panelGBC, BorderLayout.NORTH);
        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.add(panelInicio, BorderLayout.SOUTH);
        dialog.setVisible(true);

        sacarBtt.addActionListener(l -> {
            dialog.dispose();
            sacarValor();
        });

        depositarBtt.addActionListener(l -> {
            dialog.dispose();
            depositarValor();
        });

        pixBtt.addActionListener(l -> {
            dialog.dispose();
            transferirValor();
        });

        extratoBtt.addActionListener(l -> dadosConta.imprimirExtrato());

        voltarBtt.addActionListener(l -> {
            dialog.dispose();
            apresentar();
        });

        mostrarSaldo.addActionListener(l -> {
            if (mostrarSaldo.isSelected()){
                campoSaldo.setEchoChar('\0'); // Mostrar a senha (desativar o caractere de eco)
            }
            else {
                campoSaldo.setEchoChar('•'); // Ocultar a senha (ativar o caractere de eco)
            }
        });
    }
    public void entrarConta (){
        JDialog dialog = new JDialog();
        dialog.setTitle("Entrar na conta");
        dialog.setSize(250, 100);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);  // Centraliza a janela
        dialog.getContentPane().setBackground(corHexadecimal); // Mudança da cor de fundo para azul
        dialog.setIconImage(logo_dio.getImage());

        JTextField campoCpf = new JTextField();
        JLabel textoCpf = new JLabel("Digite seu CPF:");

        JButton entrarBtt = new JButton("Entrar");
        JButton cancelarBtt = new JButton("Cancelar");

        JPanel panelGBC = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panelGBC.setBackground(corHexadecimal);

        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Expande horizontalmente
        panelGBC.add(textoCpf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        panelGBC.add(campoCpf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.anchor = GridBagConstraints.LINE_END; // Alinhar à direita
        panelGBC.add(entrarBtt, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.anchor = GridBagConstraints.LINE_START; // Alinhar à esquerda
        panelGBC.add(cancelarBtt, gbc);

        dialog.add(panelGBC);
        dialog.setVisible(true);

        cancelarBtt.addActionListener(l -> {
            dialog.dispose();
            apresentar();
        });

        entrarBtt.addActionListener(l -> {
            try {
                Integer cpf = Integer.valueOf(campoCpf.getText());

                if (cliente.verificarCliente(cpf)) {
                    dadosConta = cliente.capturarDadosPeloCPF(cpf);
                    dialog.dispose();
                    usarConta();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira apenas números no campo CPF!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void cadastrarConta (){
        JDialog dialogCadastro = new JDialog();
        dialogCadastro.setTitle("Crie sua conta");
        dialogCadastro.setSize(250, 175);
        dialogCadastro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialogCadastro.setLocationRelativeTo(null);  // Centraliza a janela
        dialogCadastro.getContentPane().setBackground(corHexadecimal); // Mudança da cor de fundo para azul
        dialogCadastro.setIconImage(logo_dio.getImage());

        JTextField campoNome = new JTextField();
        JLabel textoNome = new JLabel("Digite seu nome:");

        JTextField campoCpf = new JTextField();
        JLabel textoCpf = new JLabel("Digite seu CPF:");

        JRadioButton contaCorrente = new JRadioButton("C. Corrente");
        contaCorrente.setBackground(corHexadecimal);
        JRadioButton contaPoupanca = new JRadioButton("C. Poupança");
        contaPoupanca.setBackground(corHexadecimal);

        ButtonGroup grupoRadioBtt = new ButtonGroup();
        grupoRadioBtt.add(contaCorrente);
        grupoRadioBtt.add(contaPoupanca);

        JButton criarBtt = new JButton("Criar");
        JButton voltarBtt = new JButton("Voltar");

        JPanel panelGBC = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panelGBC.setBackground(corHexadecimal);

        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Expande horizontalmente
        panelGBC.add(textoNome, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        panelGBC.add(campoNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Expande horizontalmente
        panelGBC.add(textoCpf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        panelGBC.add(campoCpf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.5; // Expande horizontalmente
        panelGBC.add(contaCorrente, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.5;
        panelGBC.add(contaPoupanca, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.anchor = GridBagConstraints.LINE_END; // Alinhar à direita
        panelGBC.add(criarBtt, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1; // ocupa 1 coluna
        gbc.anchor = GridBagConstraints.LINE_START; // Alinhar à esquerda
        panelGBC.add(voltarBtt, gbc);

        dialogCadastro.add(panelGBC);
        dialogCadastro.setVisible(true);

        criarBtt.addActionListener(l -> {
            try {
                String novoNome = campoNome.getText();
                Integer novoCPF = Integer.valueOf(campoCpf.getText());
                if (contaCorrente.isSelected()) {
                    cliente.adicionarContaCorrente(novoCPF, novoNome);
                    dialogCadastro.dispose();
                    entrarConta();
                } else if (contaPoupanca.isSelected()) {
                    cliente.adicionarContaPoupanca(novoCPF, novoNome);
                    dialogCadastro.dispose();
                    entrarConta();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um tipo de conta!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira apenas números no campo CPF!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        voltarBtt.addActionListener(l -> {
            dialogCadastro.dispose();
            apresentar();
        });
    }

    public void apresentar (){
        JDialog dialog = new JDialog();
        dialog.setTitle("Banco DIO");
        dialog.setSize(300, 100);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);  // Centraliza a janela
        dialog.setLayout(new BorderLayout());  // Define o layout do JDialog
        dialog.getContentPane().setBackground(corHexadecimal); // Mudança da cor de fundo para azul
        dialog.setIconImage(logo_dio.getImage());

        // Criação de um JLabel que será atualizado
        JLabel saudacao = new JLabel("", SwingConstants.CENTER);
        saudacao.setForeground(Color.WHITE);  // Mudança da cor do texto para branco
        dialog.add(saudacao);
        dialog.setVisible(true);

        JButton entrarBtt = new JButton("Já sou cliente!");
        JButton cadastroBtt = new JButton("Sou novo aqui");

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.setBackground(corHexadecimal);
        painelBotoes.add(entrarBtt);
        painelBotoes.add(cadastroBtt);

        // Adiciona o painel de botões ao JDialog na parte inferior
        dialog.add(painelBotoes, BorderLayout.SOUTH);

        // Texto a ser exibido
        String textoCompleto = "Bem-vindo!";

        // Criação de um Timer para atualizar o JLabel
        Timer timer = new Timer(300, new ActionListener() {
            private int index = 0;  // Índice do caractere atual

            @Override
            public void actionPerformed(ActionEvent e) {
                // Atualiza o JLabel com o próximo caractere
                saudacao.setText(textoCompleto.substring(0, index + 1));
                index++;

                // Para o Timer quando o texto estiver completo
                if (index == textoCompleto.length()) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        // Inicia o Timer
        timer.start();

        entrarBtt.addActionListener(l -> {
            dialog.dispose();
            entrarConta();
        });

        cadastroBtt.addActionListener(l -> {
            dialog.dispose();
            cadastrarConta();
        });
    }
}
