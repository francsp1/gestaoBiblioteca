package view.encomenda;

import model.Encomenda;
import view.common.Painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PainelEncomenda extends Painel{
    private final Encomenda encomenda;
    private final JLabel lblId;
    private final JLabel lblLivro;
    private final JLabel lblFornecedor;
    private final JLabel lblISBN;
    private final JLabel lblUnidades;
    private final JLabel lblEstado;
    private final JButton btnDetalhes;

    public PainelEncomenda(EcraEncomendas ecraPai,Encomenda encomenda){
        super(ecraPai);

        this.encomenda = encomenda;

        lblId = new JLabel();
        lblLivro = new JLabel();
        lblFornecedor = new JLabel();
        lblISBN = new JLabel();
        lblUnidades = new JLabel();
        lblEstado = new JLabel();
        btnDetalhes = new JButton();

        preencherDetalhesEncomenda();

        desenharPainel();

        btnDetalhes.addActionListener(e -> btnDetalhesActionPerformed(e, this ,encomenda));

    }

    public void preencherDetalhesEncomenda() {
        lblId.setText("ID: " + encomenda.getId());
        lblLivro.setText("Nome: " + encomenda.getLivro());
        lblFornecedor.setText("Distribuidora: " + encomenda.getFornecedor());
        lblISBN.setText("Contacto: "+ encomenda.getIsbn());
        lblUnidades.setText("Contacto: "+ encomenda.getN_unidades());
        StringBuilder estado = new StringBuilder();
        estado.append("Estado: ");
        if (encomenda.getEstado()) {
            estado.append("Ativo");
            setBackGroundVerde();
        }else {
            estado.append("Inativo");
            setBackGroundVermelho();
        }
        lblEstado.setText(estado.toString());
        btnDetalhes.setText("Detalhes");
    }

    private void desenharPainel() {
        setLayout(new GridLayout(7, 1)); // Adjust layout as needed
        add(lblId);
        add(lblLivro);
        add(lblFornecedor);
        add(lblISBN);
        add(lblUnidades);
        add(lblEstado);
        add(btnDetalhes);
    }

    private void btnDetalhesActionPerformed(ActionEvent actionEvent, PainelEncomenda painelEncomenda, Encomenda encomenda) {
        EcraEncomendas ecraPai = (EcraEncomendas) this.ecraPai;
        new EcraDetalhesEncomenda(ecraPai, painelEncomenda, encomenda);
    }
}

