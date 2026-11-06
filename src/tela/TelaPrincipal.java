package tela;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
    final private Color COR_FUNDO_BOTAO = new Color(86, 126, 187);
    final private Color COR_TEXTO_BOTAO = new Color(238, 243, 249);
    final private Color COR_FUNDO_BOTAO_SAIR = new Color(43, 76, 126);
    final private Color COR_TEXTO_TITULO = new Color(31, 31, 32);
    final private Color COR_FUNDO_TELA = new Color(220, 224, 230);

    public TelaPrincipal() {
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(670, 560);
        getContentPane().setBackground(COR_FUNDO_TELA);
        setLocationRelativeTo(null);
        init();
        setVisible(true);
    }

    private void init() {
        JLabel lblTitulo = new JLabel();
        lblTitulo.setText("MOVINI");
        lblTitulo.setFont(new Font("SansSerif", 1, 64));
        lblTitulo.setForeground(COR_TEXTO_TITULO);
        lblTitulo.setBounds(82, 5, 250, 80);
        add(lblTitulo);

        JLabel lblLinhaTitulo = new JLabel();
        lblLinhaTitulo.setBackground(COR_FUNDO_BOTAO);
        lblLinhaTitulo.setOpaque(true);
        lblLinhaTitulo.setBounds(lblTitulo.getX(), lblTitulo.getHeight() + lblTitulo.getY() - 11,
                lblTitulo.getWidth(), 2);
        add(lblLinhaTitulo);

        JLabel lblSubtitulo = new JLabel();
        lblSubtitulo.setText("Catálogo e cadastro de filmes");
        lblSubtitulo.setFont(new Font("Arial", 0, 20));
        lblSubtitulo.setBounds(lblTitulo.getX() + 30, lblTitulo.getY() + lblTitulo.getHeight() - 5,
                275, 25);
        add(lblSubtitulo);

        JLabel lblLinhaSubtitulo = new JLabel();
        lblLinhaSubtitulo.setBackground(COR_FUNDO_BOTAO);
        lblLinhaSubtitulo.setOpaque(true);
        lblLinhaSubtitulo.setBounds(lblSubtitulo.getX(),
                lblSubtitulo.getHeight() + lblSubtitulo.getY() - 2, lblSubtitulo.getWidth(), 2);
        add(lblLinhaSubtitulo);

        JButton btnCatalogo = new JButton();
        btnCatalogo.setText("Catálogo");
        btnCatalogo.setFont(new Font("SansSerif", 1, 40));
        btnCatalogo.setBackground(COR_FUNDO_BOTAO);
        btnCatalogo.setForeground(COR_TEXTO_BOTAO);
        btnCatalogo.setBounds(lblTitulo.getX(), 170, 490, 60);
        btnCatalogo.addActionListener(e -> {
            new TelaCatalogo();
            dispose();
        });
        add(btnCatalogo);

        JButton btnCadastro = new JButton();
        btnCadastro.setText("Cadastro");
        btnCadastro.setFont(new Font("SansSerif", 1, 40));
        btnCadastro.setBackground(COR_FUNDO_BOTAO);
        btnCadastro.setForeground(COR_TEXTO_BOTAO);
        btnCadastro.setBounds(btnCatalogo.getX(), btnCatalogo.getY() + btnCatalogo.getHeight() + 25,
                220, 60);
        btnCadastro.addActionListener(e -> {
            new TelaCadastro();
            dispose();
        });
        add(btnCadastro);

        JButton btnEditar = new JButton();
        btnEditar.setText("Editar");
        btnEditar.setFont(new Font("SansSerif", 1, 40));
        btnEditar.setBackground(COR_FUNDO_BOTAO);
        btnEditar.setForeground(COR_TEXTO_BOTAO);
        btnEditar.setBounds(btnCadastro.getX() + btnCadastro.getWidth() + 50,
                btnCadastro.getY(), 220, 60);
        btnEditar.addActionListener(e -> {
            new TelaEditar();
            dispose();
        });
        add(btnEditar);

        JButton btnSair = new JButton();
        btnSair.setText("Sair");
        btnSair.setFont(new Font("SansSerif", 1, 40));
        btnSair.setBackground(COR_FUNDO_BOTAO_SAIR);
        btnSair.setForeground(COR_TEXTO_BOTAO);
        btnSair.setBounds(216, btnCadastro.getY() + btnCadastro.getHeight() + 55, 220, 60);
        btnSair.addActionListener(e -> {
            TelaConfirmacao confirmacao = new TelaConfirmacao(this);
            if (confirmacao.getDecisao()) {
                dispose();
                System.exit(0);
            }
        });
        add(btnSair);
    }
}
