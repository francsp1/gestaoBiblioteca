package view.encomenda;

import model.DadosAplicacao;
import model.Encomenda;
import model.Fornecedor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraAdicionarEncomenda extends JFrame{

    private static final String ERRO_1 = "Inserir todos os dados da encomenda";
    private static final String ERRO_2 = "Inserir o Livro.";
    private static final String ERRO_3 = "Inserir o Fornecedor";
    private static final String ERRO_4 = "Inserir o ISBN";
    private static final String ERRO_5 = "Inserir as Unidades";


    private final EcraEncomendas ecraPai;
    private JTextField textFieldLivro;
    private JTextField textFieldFornecedor;
    private JTextField textFieldISBN;
    private JTextField textFieldUnidades;
    private JButton criarEncomendaButton;
    private JButton sairButton;
    private JLabel lblID;



    public EcraAdicionarEncomenda(EcraEncomendas ecraPai) {
        super("Detalhes do Encomenda");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();

        this.ecraPai = ecraPai;

        sairButton.addActionListener(this::sairButtonActionPerformed);
        criarEncomendaButton.addActionListener(this::criarEncomendaButtonActionPerformed);


        setLocationRelativeTo(null);
        setVisible(true);
    }


    //funcoes
    private void inserirDadosEncomenda(Encomenda encomenda) {
        encomenda.setLivro(textFieldLivro.getText());
        encomenda.setFornecedor(textFieldFornecedor.getText());
        encomenda.setIsbn(textFieldISBN.getText());
        encomenda.setN_unidades(Integer.parseInt(textFieldUnidades.getText()));
    }


    private boolean validarDadosEncomenda() {
        if (textFieldLivro.getText().trim().isEmpty() && textFieldFornecedor.getText().trim().isEmpty() &&
                textFieldISBN.getText().trim().isEmpty() && textFieldUnidades.getText().trim().isEmpty()) {
            mostrarErro(ERRO_1);
            return false;
        } else if (textFieldLivro.getText().trim().isEmpty()) {
            mostrarErro(ERRO_2);
            return false;
        } else if (textFieldFornecedor.getText().trim().isEmpty()) {
            mostrarErro(ERRO_3);
            return false;
        } else if (textFieldISBN.getText().trim().isEmpty()) {
            mostrarErro(ERRO_4);
            return false;
        } else if (textFieldUnidades.getText().trim().isEmpty()) {
            mostrarErro(ERRO_5);
            return false;
        }

        return true;
    }


    private void mostrarErro(String erro) {
        JOptionPane.showMessageDialog(this, erro);
    }

    //buttons
    private void sairButtonActionPerformed(ActionEvent actionEvent) {
        dispose();
    }

    private void criarEncomendaButtonActionPerformed(ActionEvent actionEvent) {
        if (validarDadosEncomenda()) {
            DadosAplicacao.INSTANCIA.adicionarEncomenda(new Encomenda(textFieldLivro.getText(), textFieldFornecedor.getText(),
                    textFieldISBN.getText(), Integer.valueOf(textFieldUnidades.getText()) ));

            dispose();

            ecraPai.preencherEncomendas();
        }
    }


}
