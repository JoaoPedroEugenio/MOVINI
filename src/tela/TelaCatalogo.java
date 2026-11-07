package tela;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import dao.FilmeDAO;
import modelo.Filme;

@SuppressWarnings("serial")
public class TelaCatalogo extends JFrame {
    final private Color COR_FUNDO_BOTAO = new Color(86, 126, 187);
    final private Color COR_TEXTO_LABEL = new Color(31, 31, 32);
    final private Color COR_TEXTO_BOTAO = new Color(238, 243, 249);
    final private Color COR_FUNDO_TELA = new Color(220, 224, 230);
    JScrollPane scroll = new JScrollPane();
    private FilmeDAO filmeDAO = new FilmeDAO();

    public TelaCatalogo() {
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(790, 660);
        getContentPane().setBackground(COR_FUNDO_TELA);
        setLocationRelativeTo(null);
        init();
        setVisible(true);
    }

    private void init() {
        JLabel lblTitulo = new JLabel();
        lblTitulo.setText("MOVINI - CATÁLOGO");
        lblTitulo.setFont(new Font("Serif", 1, 26));
        lblTitulo.setForeground(COR_TEXTO_LABEL);
        lblTitulo.setBounds(20, 12, 720, 32);
        add(lblTitulo);

        JLabel lblLinhaTitulo = new JLabel();
        lblLinhaTitulo.setBackground(COR_FUNDO_BOTAO);
        lblLinhaTitulo.setOpaque(true);
        lblLinhaTitulo.setBounds(20, 48, 735, 2);
        add(lblLinhaTitulo);

        JLabel lblColunas = new JLabel();
        lblColunas.setText("ID  -  Poster  |  Título  |  Gênero  |  Distribuidora  |  Ano de Lançamento  |  Classificação  |  Preço  |  Duração");
        lblColunas.setFont(new Font("Serif", 0, 14));
        lblColunas.setForeground(COR_TEXTO_LABEL);
        lblColunas.setBounds(20, 58, 740, 24);
        add(lblColunas);
        
        
        JLabel lblArea = new JLabel();
        lblArea.setLayout(null);
        lblArea.setOpaque(true);
        lblArea.setBackground(COR_FUNDO_TELA);
        
        int contador = 0;

        for (Filme filme : filmeDAO.SelectGeral()) {

            int posicaoY = contador * 150;

            JLabel lblId = new JLabel(filme.getId() + " -");
            lblId.setFont(new Font("Serif", 1, 16));
            lblId.setForeground(COR_TEXTO_LABEL);
            lblId.setBounds(8, posicaoY + 45, 35, 25);
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
        lblArea.setPreferredSize(new Dimension(715, Math.max(410, altura)));
        scroll.setBounds(20, 100, 735, 410);
        scroll.setViewportView(lblArea);
        scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );
        scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        scroll.getVerticalScrollBar().setUnitIncrement(20);
        add(scroll);
        
        JButton btnVoltar = new JButton();
        btnVoltar.setText("Voltar");
        btnVoltar.setFont(new Font("Serif", 1, 18));
        btnVoltar.setBackground(COR_FUNDO_BOTAO);
        btnVoltar.setForeground(COR_TEXTO_BOTAO);
        btnVoltar.setBounds(455, 535, 190, 45);
        btnVoltar.addActionListener(e -> {
            new TelaPrincipal();
            dispose();
        });
        add(btnVoltar);
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
