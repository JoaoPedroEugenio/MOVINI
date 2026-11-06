package tela;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TelaCadastro extends JFrame {
    final private Color COR_FUNDO_BOTAO = new Color(86, 126, 187);
    final private Color COR_TEXTO_LABEL = new Color(31, 31, 32);
    final private Color COR_TEXTO_BOTAO = new Color(238, 243, 249);
    final private Color COR_FUNDO_BOTAO_SAIR = new Color(43, 76, 126);
    final private Color COR_TEXTO_TITULO = new Color(31, 31, 32);
    final private Color COR_FUNDO_TELA = new Color(220, 224, 230);
    final private Color COR_PAINEL_CABECALHO = new Color(167, 176, 190, 45);

    public TelaCadastro() {
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(686, 560);
        getContentPane().setBackground(COR_FUNDO_TELA);
        setLocationRelativeTo(null);
        init();
        setVisible(true);
    }

    private void init() {
        JLabel lblCabecalho = new JLabel();
        lblCabecalho.setOpaque(true);
        lblCabecalho.setBackground(COR_PAINEL_CABECALHO);
        lblCabecalho.setBounds(0, 0, getWidth(), 48);
        add(lblCabecalho);

        JLabel lblTitulo = new JLabel();
        lblTitulo.setText("MOVINI - CADASTRO");
        lblTitulo.setFont(new Font("SansSerif", 1, 24));
        lblTitulo.setForeground(COR_TEXTO_TITULO);
        lblTitulo.setBounds(10, 8, 550, 30);
        add(lblTitulo);

        JLabel lblLinhaTitulo = new JLabel();
        lblLinhaTitulo.setBackground(COR_FUNDO_BOTAO);
        lblLinhaTitulo.setOpaque(true);
        lblLinhaTitulo.setBounds(lblTitulo.getX() - 4, lblTitulo.getHeight() + lblTitulo.getY() - 2, getWidth() - lblTitulo.getX() - 20, 2);
        add(lblLinhaTitulo);

        JLabel lblTituloFilme = new JLabel();
        lblTituloFilme.setText("Título:");
        lblTituloFilme.setFont(new Font("SansSerif", 1, 18));
        lblTituloFilme.setBounds(20, 70, 145, 30);
        lblTituloFilme.setForeground(COR_TEXTO_LABEL);
        add(lblTituloFilme);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setFont(new Font("SansSerif", 0, 18));
        txtTitulo.setBounds(190, lblTituloFilme.getY(), 440, 30);
        txtTitulo.setBorder(null);
        txtTitulo.setForeground(COR_TEXTO_LABEL);
        txtTitulo.setBackground(Color.WHITE);
        add(txtTitulo);

        JLabel lblPreco = new JLabel();
        lblPreco.setText("Preço:");
        lblPreco.setFont(new Font("SansSerif", 1, 18));
        lblPreco.setBounds(20, 112, 145, 30);
        lblPreco.setForeground(COR_TEXTO_LABEL);
        add(lblPreco);

        JTextField txtPreco = new JTextField();
        txtPreco.setFont(new Font("SansSerif", 0, 18));
        txtPreco.setBounds(190, lblPreco.getY(), 440, 30);
        txtPreco.setBorder(null);
        txtPreco.setForeground(COR_TEXTO_LABEL);
        txtPreco.setBackground(Color.WHITE);
        add(txtPreco);

        JLabel lblDistribuidora = new JLabel();
        lblDistribuidora.setText("Distribuidora:");
        lblDistribuidora.setFont(new Font("SansSerif", 1, 18));
        lblDistribuidora.setBounds(20, 154, 160, 30);
        lblDistribuidora.setForeground(COR_TEXTO_LABEL);
        add(lblDistribuidora);

        JTextField txtDistribuidora = new JTextField();
        txtDistribuidora.setFont(new Font("SansSerif", 0, 18));
        txtDistribuidora.setBounds(190, lblDistribuidora.getY(), 440, 30);
        txtDistribuidora.setBorder(null);
        txtDistribuidora.setForeground(COR_TEXTO_LABEL);
        txtDistribuidora.setBackground(Color.WHITE);
        add(txtDistribuidora);

        JLabel lblPoster = new JLabel();
        lblPoster.setText("Poster (URL):");
        lblPoster.setFont(new Font("SansSerif", 1, 18));
        lblPoster.setBounds(20, 196, 160, 30);
        lblPoster.setForeground(COR_TEXTO_LABEL);
        add(lblPoster);

        JTextField txtPoster = new JTextField();
        txtPoster.setFont(new Font("SansSerif", 0, 18));
        txtPoster.setBounds(190, lblPoster.getY(), 440, 30);
        txtPoster.setBorder(null);
        txtPoster.setForeground(COR_TEXTO_LABEL);
        txtPoster.setBackground(Color.WHITE);
        add(txtPoster);

        JLabel lblDuracao = new JLabel();
        lblDuracao.setText("Duração (min):");
        lblDuracao.setFont(new Font("SansSerif", 1, 18));
        lblDuracao.setBounds(20, 238, 160, 30);
        lblDuracao.setForeground(COR_TEXTO_LABEL);
        add(lblDuracao);

        JTextField txtDuracao = new JTextField();
        txtDuracao.setFont(new Font("SansSerif", 0, 18));
        txtDuracao.setBounds(190, lblDuracao.getY(), 440, 30);
        txtDuracao.setBorder(null);
        txtDuracao.setForeground(COR_TEXTO_LABEL);
        txtDuracao.setBackground(Color.WHITE);
        add(txtDuracao);

        JLabel lblAno = new JLabel();
        lblAno.setText("Ano de Lançamento:");
        lblAno.setFont(new Font("SansSerif", 1, 18));
        lblAno.setBounds(20, 280, 190, 30);
        lblAno.setForeground(COR_TEXTO_LABEL);
        add(lblAno);

        JTextField txtAno = new JTextField();
        txtAno.setFont(new Font("SansSerif", 0, 18));
        txtAno.setBounds(210, lblAno.getY(), 420, 30);
        txtAno.setBorder(null);
        txtAno.setForeground(COR_TEXTO_LABEL);
        txtAno.setBackground(Color.WHITE);
        add(txtAno);

        JLabel lblGenero = new JLabel();
        lblGenero.setText("Gênero:");
        lblGenero.setFont(new Font("SansSerif", 1, 18));
        lblGenero.setBounds(20, 322, 145, 30);
        lblGenero.setForeground(COR_TEXTO_LABEL);
        add(lblGenero);

        String[] generos = {"Selecione o gênero", "Ação", "Animação", "Aventura", "Comédia",
                "Documentário", "Drama", "Fantasia", "Faroeste", "Ficção Científica",
                "Guerra", "Musical", "Romance", "Suspense", "Terror"};
        JComboBox<String> boxGenero = new JComboBox<String>(generos);
        boxGenero.setFont(new Font("SansSerif", 0, 18));
        boxGenero.setBounds(190, lblGenero.getY(), 440, 30);
        boxGenero.setForeground(COR_TEXTO_LABEL);
        add(boxGenero);

        JLabel lblClassificacao = new JLabel();
        lblClassificacao.setText("Classificação:");
        lblClassificacao.setFont(new Font("SansSerif", 1, 18));
        lblClassificacao.setBounds(20, 364, 160, 30);
        lblClassificacao.setForeground(COR_TEXTO_LABEL);
        add(lblClassificacao);

        String[] classificacoes = {"Selecione a classificação", "Livre", "10+", "12+", "14+", "16+", "18+"};
        JComboBox<String> boxClassificacao = new JComboBox<String>(classificacoes);
        boxClassificacao.setFont(new Font("SansSerif", 0, 18));
        boxClassificacao.setBounds(190, lblClassificacao.getY(), 440, 30);
        boxClassificacao.setForeground(COR_TEXTO_LABEL);
        add(boxClassificacao);

        JButton btnVoltar = new JButton();
        btnVoltar.setText("Voltar");
        btnVoltar.setFont(new Font("SansSerif", 1, 20));
        btnVoltar.setBackground(COR_FUNDO_BOTAO_SAIR);
        btnVoltar.setForeground(COR_TEXTO_BOTAO);
        btnVoltar.setBounds(35, 430, 160, 50);
        btnVoltar.addActionListener(e -> {
        	TelaConfirmacao confirmacao = new TelaConfirmacao(this);
            if (confirmacao.getDecisao()) {
                new TelaPrincipal();
                dispose();
            }
        });
        add(btnVoltar);

        JButton btnLimpar = new JButton();
        btnLimpar.setText("Limpar");
        btnLimpar.setFont(new Font("SansSerif", 1, 20));
        btnLimpar.setBackground(COR_FUNDO_BOTAO);
        btnLimpar.setForeground(COR_TEXTO_BOTAO);
        btnLimpar.setBounds(250, btnVoltar.getY(), 160, 50);
        btnLimpar.addActionListener(e -> {
            txtTitulo.setText("");
            txtPreco.setText("");
            txtDistribuidora.setText("");
            txtPoster.setText("");
            txtDuracao.setText("");
            txtAno.setText("");
            boxGenero.setSelectedIndex(0);
            boxClassificacao.setSelectedIndex(0);
        });
        add(btnLimpar);

        JButton btnSalvar = new JButton();
        btnSalvar.setText("Salvar");
        btnSalvar.setFont(new Font("SansSerif", 1, 20));
        btnSalvar.setBackground(COR_FUNDO_BOTAO);
        btnSalvar.setForeground(COR_TEXTO_BOTAO);
        btnSalvar.setBounds(465, btnVoltar.getY(), 160, 50);
        add(btnSalvar);
    }
}
