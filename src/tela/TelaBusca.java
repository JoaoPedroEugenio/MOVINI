package tela;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dao.FilmeDAO;
import modelo.Filme;

@SuppressWarnings("serial")
public class TelaBusca extends JFrame {
    final private Color COR_FUNDO_BOTAO = new Color(86, 126, 187);
    final private Color COR_FUNDO_BOTAO_SAIR = new Color(43, 76, 126);
    final private Color COR_TEXTO_LABEL = new Color(31, 31, 32);
    final private Color COR_TEXTO_BOTAO = new Color(238, 243, 249);
    final private Color COR_FUNDO_TELA = new Color(220, 224, 230);
    JScrollPane scroll = new JScrollPane();
    private FilmeDAO filmeDAO = new FilmeDAO();
    private JTextField txtId;

    public TelaBusca() {
        this(new FilmeDAO().SelectGeral());
    }

    public TelaBusca(ArrayList<Filme> filmes) {
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(790, 660);
        getContentPane().setBackground(COR_FUNDO_TELA);
        setLocationRelativeTo(null);
        init();
        mostrarFilmes(filmes);
        setVisible(true);
    }

    private void init() {
        JLabel lblTitulo = new JLabel();
        lblTitulo.setText("MOVINI - BUSCA");
        lblTitulo.setFont(new Font("SansSerif", 1, 26));
        lblTitulo.setForeground(COR_FUNDO_BOTAO_SAIR);
        lblTitulo.setBounds(20, 12, 735, 32);
        add(lblTitulo);

        JLabel lblLinhaTitulo = new JLabel();
        lblLinhaTitulo.setBackground(COR_FUNDO_BOTAO);
        lblLinhaTitulo.setOpaque(true);
        lblLinhaTitulo.setBounds(20, 48, 735, 2);
        add(lblLinhaTitulo);

        JLabel lblBusca = new JLabel();
        lblBusca.setText("Título:");
        lblBusca.setFont(new Font("SansSerif", 1, 16));
        lblBusca.setForeground(COR_TEXTO_LABEL);
        lblBusca.setBounds(20, 60, 75, 26);
        add(lblBusca);

        JTextField txtBusca = new JTextField();
        txtBusca.setFont(new Font("SansSerif", 0, 16));
        txtBusca.setBounds(100, 58, 460, 30);
        txtBusca.setBorder(null);
        txtBusca.setBackground(Color.WHITE);
        txtBusca.setForeground(COR_TEXTO_LABEL);
        add(txtBusca);

        JButton btnBuscar = new JButton();
        btnBuscar.setText("Buscar");
        btnBuscar.setFont(new Font("SansSerif", 1, 16));
        btnBuscar.setBackground(COR_FUNDO_BOTAO);
        btnBuscar.setForeground(COR_TEXTO_BOTAO);
        btnBuscar.setBounds(575, 58, 180, 30);
        btnBuscar.addActionListener(e -> {
            mostrarFilmes(filmeDAO.SelectTitulo(txtBusca.getText()));
        });
        add(btnBuscar);

        JLabel lblColunas = new JLabel();
        lblColunas.setText("ID  -  Poster  |  Título  |  Gênero  |  Distribuidora  |  Ano de Lançamento  |  Classificação  |  Preço  |  Duração");
        lblColunas.setFont(new Font("Serif", 0, 14));
        lblColunas.setForeground(COR_TEXTO_LABEL);
        lblColunas.setBounds(20, 98, 735, 24);
        add(lblColunas);

        scroll.setBounds(20, 126, 735, 398);
        scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );
        scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        scroll.getVerticalScrollBar().setUnitIncrement(20);
        add(scroll);

        JLabel lblId = new JLabel();
        lblId.setText("ID do filme:");
        lblId.setFont(new Font("SansSerif", 1, 16));
        lblId.setForeground(COR_TEXTO_LABEL);
        lblId.setBounds(390, 553, 100, 28);
        add(lblId);

        txtId = new JTextField();
        txtId.setFont(new Font("SansSerif", 0, 16));
        txtId.setBounds(495, 552, 65, 30);
        txtId.setBorder(null);
        txtId.setBackground(Color.WHITE);
        txtId.setForeground(COR_TEXTO_LABEL);
        add(txtId);

        JButton btnEditar = new JButton();
        btnEditar.setText("Editar");
        btnEditar.setFont(new Font("SansSerif", 1, 18));
        btnEditar.setBackground(COR_FUNDO_BOTAO);
        btnEditar.setForeground(COR_TEXTO_BOTAO);
        btnEditar.setBounds(575, 545, 180, 45);
        btnEditar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                ArrayList<Filme> resultado = filmeDAO.SelectId(id);
                if (resultado.isEmpty()) {
                    new TelaErro(this, "Nenhum filme encontrado com o ID informado.");
                } else {
                    new TelaEditar(resultado.get(0));
                    dispose();
                }
            } catch (NumberFormatException ex) {
                new TelaErro(this, "O ID deve ser um número inteiro.");
            }
        });
        add(btnEditar);

        JButton btnVoltar = new JButton();
        btnVoltar.setText("Voltar");
        btnVoltar.setFont(new Font("SansSerif", 1, 18));
        btnVoltar.setBackground(COR_FUNDO_BOTAO_SAIR);
        btnVoltar.setForeground(COR_TEXTO_BOTAO);
        btnVoltar.setBounds(20, 545, 180, 45);
        btnVoltar.addActionListener(e -> {
            new TelaPrincipal();
            dispose();
        });
        add(btnVoltar);
    }

    private void mostrarFilmes(ArrayList<Filme> filmes) {
        JLabel lblArea = new JLabel();
        lblArea.setLayout(null);
        lblArea.setOpaque(true);
        lblArea.setBackground(COR_FUNDO_TELA);

        int contador = 0;

        for (Filme filme : filmes) {

            int posicaoY = contador * 150;

            JLabel lblId = new JLabel(filme.getId() + " -");
            lblId.setFont(new Font("Serif", 1, 16));
            lblId.setForeground(COR_TEXTO_LABEL);
            lblId.setBounds(8, posicaoY + 45, 40, 25);
            lblArea.add(lblId);

            JLabel lblPoster = new JLabel();
            lblPoster.setBounds(45, posicaoY + 10, 88, 125);
            lblPoster.setText("Carregando...");
            lblPoster.setFont(new Font("Serif", 0, 10));
            lblPoster.setHorizontalAlignment(JLabel.CENTER);
            carregarPoster(filme.getPoster(), lblPoster);
            lblArea.add(lblPoster);

            JLabel lblFilmeLinha1 = new JLabel("Título: " + filme.getTitulo());
            lblFilmeLinha1.setFont(new Font("Serif", 0, 18));
            lblFilmeLinha1.setForeground(COR_TEXTO_LABEL);
            lblFilmeLinha1.setBounds(150, posicaoY + 10, 570, 25);
            lblArea.add(lblFilmeLinha1);

            JLabel lblFilmeLinha2 = new JLabel("Gênero: " + filme.getGenero()
                    + " | Ano de Lançamento: " + filme.getAno_lancamento());
            lblFilmeLinha2.setFont(new Font("Serif", 0, 18));
            lblFilmeLinha2.setForeground(COR_TEXTO_LABEL);
            lblFilmeLinha2.setBounds(150, posicaoY + 36, 570, 25);
            lblArea.add(lblFilmeLinha2);

            JLabel lblFilmeLinha3 = new JLabel("Distribuidora: " + filme.getDistribuidora()
                    + " | Classificação: " + filme.getClassificao());
            lblFilmeLinha3.setFont(new Font("Serif", 0, 18));
            lblFilmeLinha3.setForeground(COR_TEXTO_LABEL);
            lblFilmeLinha3.setBounds(150, posicaoY + 62, 570, 25);
            lblArea.add(lblFilmeLinha3);

            JLabel lblFilmeLinha4 = new JLabel("Preço: " + String.format("%.2f", filme.getPreco())
                    + " | Duração (min): " + filme.getDuracao());
            lblFilmeLinha4.setFont(new Font("Serif", 0, 18));
            lblFilmeLinha4.setForeground(COR_TEXTO_LABEL);
            lblFilmeLinha4.setBounds(150, posicaoY + 88, 570, 25);
            lblArea.add(lblFilmeLinha4);

            JLabel lblLinhaColunas = new JLabel();
            lblLinhaColunas.setBackground(COR_FUNDO_BOTAO);
            lblLinhaColunas.setOpaque(true);
            lblLinhaColunas.setBounds(0, posicaoY, 710, 2);
            lblArea.add(lblLinhaColunas);

            contador++;
        }

        int altura = contador * 150;
        lblArea.setPreferredSize(new Dimension(715, Math.max(398, altura)));
        scroll.setViewportView(lblArea);
    }

    private void carregarPoster(String caminho, JLabel label) {
        new Thread(() -> {
            try {
                ImageIcon imagem = new ImageIcon(new URL(caminho));

                Image redimensionada = imagem.getImage()
                        .getScaledInstance(88, 125, Image.SCALE_SMOOTH);

                javax.swing.SwingUtilities.invokeLater(() ->
                    label.setIcon(new ImageIcon(redimensionada))
                );

            } catch (Exception e) {
            	URL urlErro = getClass().getResource("/recursos/Erro404.png");

            	if (urlErro != null) {
            	    ImageIcon erro = new ImageIcon(urlErro);

            	    Image redimensionada = erro.getImage()
            	            .getScaledInstance(88, 125, Image.SCALE_SMOOTH);

            	    javax.swing.SwingUtilities.invokeLater(() -> {
            	        label.setText("");
            	        label.setIcon(new ImageIcon(redimensionada));
            	    });
            	}
            }
        }).start();
    }
}
