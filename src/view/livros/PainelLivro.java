package view.livros;

import model.Fornecedor;
import model.Livro;
import view.fornecedores.EcraDetalhesFornecedor;
import view.fornecedores.EcraFornecedores;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PainelLivro extends JPanel{
    private final EcraLivros ecraPai;

    public PainelLivro(EcraLivros ecraPai, Livro livro){
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackBorder);

        if (!livro.getEstado()) {
            setBackground(new Color(255, 204, 204));
        } else {
            setBackground(new Color(204, 255, 204));
        }

        this.ecraPai = ecraPai;

        JLabel lblId = new JLabel("ID: " + livro.getId());
        JLabel lblTitulo = new JLabel("Nome: " + livro.getTitulo());

        StringBuilder autores = new StringBuilder();
        autores.append("Autores: ");
        for (String autor : livro.getAutores()) {
            autores.append(autor).append(", ");
        }

        JLabel lblAutores = new JLabel(autores.toString());
        JLabel lblGenero = new JLabel("Género: " + livro.getGenero() + ", Subgénero: " + livro.getSubgenero() );

        StringBuilder estado = new StringBuilder();
        estado.append("Estado: ");
        if (livro.getEstado()) {
            estado.append("Ativo");
        }else {
            estado.append("Inativo");
        }
        JLabel lblEstado = new JLabel(estado.toString());

        JButton btnDetalhes = new JButton("Detalhes");
        btnDetalhes.addActionListener(e -> btnDetalhesActionPerformed(e, livro));


        setLayout(new GridLayout(6, 1)); // Adjust layout as needed
        add(lblId);
        add(lblTitulo);
        add(lblAutores);
        add(lblGenero);
        add(lblEstado);
        add(btnDetalhes);

    }

    private void btnDetalhesActionPerformed(ActionEvent actionEvent, Livro livro) {
        EcraDetalhesLivro ecraDetalhesLivro = new EcraDetalhesLivro(ecraPai, livro);
    }
}
