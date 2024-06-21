package view.livros;

import model.Livro;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PainelLivro extends JPanel{
    private final EcraLivros ecraPai;
    private Livro livro;
    private final JLabel lblId;
    private final JLabel lblTitulo;
    private final JLabel lblAutores;
    private final JLabel lblGenero;
    private final JLabel lblEstado;
    private final JLabel lblRequisitadoReservado;
    private final JButton btnDetalhes;



    public PainelLivro(EcraLivros ecraPai, Livro livro){
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackBorder);

        this.ecraPai = ecraPai;
        this.livro = livro;

        lblId = new JLabel();
        lblTitulo = new JLabel();
        lblAutores = new JLabel();
        lblGenero = new JLabel();
        lblEstado = new JLabel();
        lblRequisitadoReservado = new JLabel();
        btnDetalhes = new JButton("Detalhes");

        preencherDetalhesLivro();

        desenharPainel(livro);

        btnDetalhes.addActionListener(e -> btnDetalhesActionPerformed(e, livro));

    }

    void setBackGroundVerde() {
        setBackground(new Color(204, 255, 204));
    }

    void setBackGroundVermelho() {
        setBackground(new Color(255, 204, 204));
    }

    public void preencherDetalhesLivro() {
        lblId.setText("ID: " + livro.getId());
        lblTitulo.setText("Nome: " + livro.getTitulo());
        lblAutores.setText("Autores: " + livro.getAutoresString());
        lblGenero.setText("Género: " + livro.getGenero() + "; Subgénero: " + livro.getSubgenero() );
        StringBuilder estado = new StringBuilder();
        estado.append("Estado: ");
        if (livro.getEstado()) {
            estado.append("Ativo");
            setBackGroundVerde();
        }else {
            estado.append("Inativo");
            setBackGroundVermelho();
        }
        lblEstado.setText(estado.toString());
        StringBuilder emprestadoReservado = new StringBuilder();
        emprestadoReservado.append("Emprestado: ");
        if (livro.isEmprestado()) {
            emprestadoReservado.append("Sim");
        }else {
            emprestadoReservado.append("Não");
        }
        if(livro.isReservado()){
            emprestadoReservado.append("; Reservado: Sim");
        }else {
            emprestadoReservado.append("; Reservado: Não");
        }
        lblRequisitadoReservado.setText(emprestadoReservado.toString());

    }

    private void desenharPainel(Livro livro) {
        setLayout(new GridLayout(7, 1)); // Adjust layout as needed
        add(lblId);
        add(lblTitulo);
        add(lblAutores);
        add(lblGenero);
        add(lblEstado);
        add(lblRequisitadoReservado);
        add(btnDetalhes);
    }

    private void btnDetalhesActionPerformed(ActionEvent actionEvent, Livro livro) {
        EcraDetalhesLivro ecraDetalhesLivro = new EcraDetalhesLivro(ecraPai, this, livro);
    }

    JLabel getLblEstado(){
        return lblEstado;
    }


}
