package tela;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.FilmeDAO;
import modelo.Filme;

@SuppressWarnings("serial")
public class TelaEditar extends JFrame {
    private Filme filme;
    private FilmeDAO filmeDAO = new FilmeDAO();
    final private Color COR_FUNDO_BOTAO = new Color(86, 126, 187);
    final private Color COR_TEXTO_LABEL = new Color(31, 31, 32);
    final private Color COR_TEXTO_BOTAO = new Color(238, 243, 249);
    final private Color COR_FUNDO_BOTAO_SAIR = new Color(43, 76, 126);
    final private Color COR_TEXTO_TITULO = new Color(31, 31, 32);
    final private Color COR_FUNDO_TELA = new Color(220, 224, 230);
    final private Color COR_PAINEL_CABECALHO = new Color(167, 176, 190, 45);

    public TelaEditar() {
        this(null);
    }

    public TelaEditar(Filme filme) {
        this.filme = filme;
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(780, 680);
        getContentPane().setBackground(COR_FUNDO_TELA);
        setLocationRelativeTo(null);
        init();
        setVisible(true);
    }

    private void init() {
        JLabel lblCabecalho = new JLabel();
        lblCabecalho.setOpaque(true);
        lblCabecalho.setBackground(COR_PAINEL_CABECALHO);
        lblCabecalho.setBounds(0, 0, getWidth(), 50);
        add(lblCabecalho);

        JLabel lblTitulo = new JLabel();
        lblTitulo.setText("MOVINI - EDITAR");
        lblTitulo.setFont(new Font("SansSerif", 1, 24));
        lblTitulo.setForeground(COR_TEXTO_TITULO);
        lblTitulo.setBounds(15, 8, 550, 30);
        add(lblTitulo);

        JLabel lblLinhaTitulo = new JLabel();
        lblLinhaTitulo.setBackground(COR_FUNDO_BOTAO);
        lblLinhaTitulo.setOpaque(true);
        lblLinhaTitulo.setBounds(15, 43, 735, 2);
        add(lblLinhaTitulo);

        JLabel lblBusca = new JLabel();
        lblBusca.setText("Título ou ID:");
        lblBusca.setFont(new Font("SansSerif", 1, 18));
        lblBusca.setForeground(COR_TEXTO_LABEL);
        lblBusca.setBounds(25, 65, 145, 32);
        add(lblBusca);

        JTextField txtBusca = new JTextField();
        txtBusca.setFont(new Font("SansSerif", 0, 18));
        txtBusca.setBounds(190, 65, 235, 32);
        txtBusca.setBorder(null);
        txtBusca.setBackground(Color.WHITE);
        txtBusca.setForeground(COR_TEXTO_LABEL);
        add(txtBusca);

        JButton btnBuscar = new JButton();
        btnBuscar.setText("Buscar");
        btnBuscar.setFont(new Font("SansSerif", 1, 18));
        btnBuscar.setBackground(COR_FUNDO_BOTAO);
        btnBuscar.setForeground(COR_TEXTO_BOTAO);
        btnBuscar.setBounds(535, 62, 175, 38);
        btnBuscar.addActionListener(e -> {
            String busca = txtBusca.getText().trim();
            try {
                int id = Integer.parseInt(busca);
                ArrayList<Filme> resultado = filmeDAO.SelectId(id);
                if (resultado.isEmpty()) {
                    new TelaErro(this, "Nenhum filme encontrado com o ID informado.");
                } else {
                    new TelaEditar(resultado.get(0));
                    dispose();
                }
            } catch (NumberFormatException ex) {
                ArrayList<Filme> resultado = filmeDAO.SelectTitulo(busca);
                if (resultado.isEmpty()) {
                    new TelaErro(this, "Nenhum filme encontrado com esse título.");
                } else if (resultado.size() == 1) {
                    new TelaEditar(resultado.get(0));
                    dispose();
                } else {
                    new TelaBusca(resultado);
                    dispose();
                }
            }
        });
        add(btnBuscar);

        JLabel lblLinhaBusca = new JLabel();
        lblLinhaBusca.setBackground(COR_FUNDO_BOTAO);
        lblLinhaBusca.setOpaque(true);
        lblLinhaBusca.setBounds(15, 112, 735, 2);
        add(lblLinhaBusca);

        JLabel lblTituloFilme = new JLabel();
        lblTituloFilme.setText("Título:");
        lblTituloFilme.setFont(new Font("SansSerif", 1, 18));
        lblTituloFilme.setForeground(COR_TEXTO_LABEL);
        lblTituloFilme.setBounds(25, 135, 160, 32);
        add(lblTituloFilme);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setFont(new Font("SansSerif", 0, 18));
        txtTitulo.setBounds(205, lblTituloFilme.getY(), 505, 32);
        txtTitulo.setBorder(null);
        txtTitulo.setBackground(Color.WHITE);
        txtTitulo.setForeground(COR_TEXTO_LABEL);
        if (filme != null) { txtTitulo.setText(filme.getTitulo()); }
        add(txtTitulo);

        JLabel lblPreco = new JLabel();
        lblPreco.setText("Preço:");
        lblPreco.setFont(new Font("SansSerif", 1, 18));
        lblPreco.setForeground(COR_TEXTO_LABEL);
        lblPreco.setBounds(25, 180, 160, 32);
        add(lblPreco);

        JTextField txtPreco = new JTextField();
        txtPreco.setFont(new Font("SansSerif", 0, 18));
        txtPreco.setBounds(205, lblPreco.getY(), 505, 32);
        txtPreco.setBorder(null);
        txtPreco.setBackground(Color.WHITE);
        txtPreco.setForeground(COR_TEXTO_LABEL);
        if (filme != null) { txtPreco.setText(String.format("%.2f", filme.getPreco())); }
        add(txtPreco);

        JLabel lblDistribuidora = new JLabel();
        lblDistribuidora.setText("Distribuidora:");
        lblDistribuidora.setFont(new Font("SansSerif", 1, 18));
        lblDistribuidora.setForeground(COR_TEXTO_LABEL);
        lblDistribuidora.setBounds(25, 225, 160, 32);
        add(lblDistribuidora);

        JTextField txtDistribuidora = new JTextField();
        txtDistribuidora.setFont(new Font("SansSerif", 0, 18));
        txtDistribuidora.setBounds(205, lblDistribuidora.getY(), 505, 32);
        txtDistribuidora.setBorder(null);
        txtDistribuidora.setBackground(Color.WHITE);
        txtDistribuidora.setForeground(COR_TEXTO_LABEL);
        if (filme != null) { txtDistribuidora.setText(filme.getDistribuidora()); }
        add(txtDistribuidora);

        JLabel lblPoster = new JLabel();
        lblPoster.setText("Poster (URL):");
        lblPoster.setFont(new Font("SansSerif", 1, 18));
        lblPoster.setForeground(COR_TEXTO_LABEL);
        lblPoster.setBounds(25, 270, 160, 32);
        add(lblPoster);

        JTextField txtPoster = new JTextField();
        txtPoster.setFont(new Font("SansSerif", 0, 18));
        txtPoster.setBounds(205, lblPoster.getY(), 505, 32);
        txtPoster.setBorder(null);
        txtPoster.setBackground(Color.WHITE);
        txtPoster.setForeground(COR_TEXTO_LABEL);
        if (filme != null) { txtPoster.setText(filme.getPoster()); }
        add(txtPoster);

        JLabel lblDuracao = new JLabel();
        lblDuracao.setText("Duração (min):");
        lblDuracao.setFont(new Font("SansSerif", 1, 18));
        lblDuracao.setForeground(COR_TEXTO_LABEL);
        lblDuracao.setBounds(25, 315, 160, 32);
        add(lblDuracao);

        JTextField txtDuracao = new JTextField();
        txtDuracao.setFont(new Font("SansSerif", 0, 18));
        txtDuracao.setBounds(205, lblDuracao.getY(), 505, 32);
        txtDuracao.setBorder(null);
        txtDuracao.setBackground(Color.WHITE);
        txtDuracao.setForeground(COR_TEXTO_LABEL);
        if (filme != null) { txtDuracao.setText(String.valueOf(filme.getDuracao())); }
        add(txtDuracao);

        JLabel lblAno = new JLabel();
        lblAno.setText("Ano de Lançamento:");
        lblAno.setFont(new Font("SansSerif", 1, 18));
        lblAno.setForeground(COR_TEXTO_LABEL);
        lblAno.setBounds(25, 360, 200, 32);
        add(lblAno);

        JTextField txtAno = new JTextField();
        txtAno.setFont(new Font("SansSerif", 0, 18));
        txtAno.setBounds(225, lblAno.getY(), 485, 32);
        txtAno.setBorder(null);
        txtAno.setBackground(Color.WHITE);
        txtAno.setForeground(COR_TEXTO_LABEL);
        if (filme != null) { txtAno.setText(String.valueOf(filme.getAno_lancamento())); }
        add(txtAno);

        JLabel lblGenero = new JLabel();
        lblGenero.setText("Gênero:");
        lblGenero.setFont(new Font("SansSerif", 1, 18));
        lblGenero.setForeground(COR_TEXTO_LABEL);
        lblGenero.setBounds(25, 405, 160, 32);
        add(lblGenero);

        String[] generos = {"Selecione o gênero", "Ação", "Animação", "Aventura", "Comédia",
                "Documentário", "Drama", "Fantasia", "Faroeste", "Ficção Científica",
                "Guerra", "Musical", "Romance", "Suspense", "Terror"};
        JComboBox<String> boxGenero = new JComboBox<String>(generos);
        boxGenero.setFont(new Font("SansSerif", 0, 18));
        boxGenero.setBounds(205, lblGenero.getY(), 505, 32);
        boxGenero.setForeground(COR_TEXTO_LABEL);
        if (filme != null) { boxGenero.setSelectedItem(filme.getGenero()); }
        add(boxGenero);

        JLabel lblClassificacao = new JLabel();
        lblClassificacao.setText("Classificação:");
        lblClassificacao.setFont(new Font("SansSerif", 1, 18));
        lblClassificacao.setForeground(COR_TEXTO_LABEL);
        lblClassificacao.setBounds(25, 450, 160, 32);
        add(lblClassificacao);

        String[] classificacoes = {"Selecione a classificação", "Livre", "10+", "12+", "14+", "16+", "18+"};
        JComboBox<String> boxClassificacao = new JComboBox<String>(classificacoes);
        boxClassificacao.setFont(new Font("SansSerif", 0, 18));
        boxClassificacao.setBounds(205, lblClassificacao.getY(), 505, 32);
        boxClassificacao.setForeground(COR_TEXTO_LABEL);
        if (filme != null) { boxClassificacao.setSelectedItem(filme.getClassificao()); }
        add(boxClassificacao);

        
        JButton btnVoltar = new JButton();
        btnVoltar.setText("Voltar");
        btnVoltar.setFont(new Font("SansSerif", 1, 22));
        btnVoltar.setBackground(COR_FUNDO_BOTAO_SAIR);
        btnVoltar.setForeground(COR_TEXTO_BOTAO);
        btnVoltar.setBounds(45, 525, 165, 45);
        btnVoltar.addActionListener(e -> {
        	TelaConfirmacao confirmacao = new TelaConfirmacao(this);
            if (confirmacao.getDecisao()) {
                new TelaPrincipal();
                dispose();
            }
        });
        add(btnVoltar);
        
        JButton btnExcluir = new JButton();
        btnExcluir.setText("Excluir");
        btnExcluir.setFont(new Font("SansSerif", 1, 22));
        btnExcluir.setBackground(COR_FUNDO_BOTAO);
        btnExcluir.setForeground(COR_TEXTO_BOTAO);
        btnExcluir.setBounds(300, btnVoltar.getY(), 165, 45);
        btnExcluir.setEnabled(filme != null);
        btnExcluir.addActionListener(e -> {
        	TelaConfirmacao confirmacao = new TelaConfirmacao(this);
            if (confirmacao.getDecisao()) {
            	if (filme != null) {
            		if (filmeDAO.DeleteId(this.filme.getId())) {
            			new TelaSucesso(this, "Filme deletado com sucesso!");
            			dispose();
            			new TelaEditar();
            		} else {
            			new TelaErro(this, "Não foi possível deletar o filme no banco de dados.");
            		}
            	}
            }
        });
        add(btnExcluir);

        JButton btnAtualizar = new JButton();
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setFont(new Font("SansSerif", 1, 22));
        btnAtualizar.setBackground(COR_FUNDO_BOTAO);
        btnAtualizar.setForeground(COR_TEXTO_BOTAO);
        btnAtualizar.setBounds(555, btnVoltar.getY(), 165, 45);
        btnAtualizar.setEnabled(filme != null);
        btnAtualizar.addActionListener(e -> {
        	TelaConfirmacao confirmacao = new TelaConfirmacao(this);
            if (confirmacao.getDecisao()) {
            	Filme filme = atualizarFilme(txtTitulo, txtPreco, txtDistribuidora, txtPoster, txtDuracao, txtAno, boxGenero, boxClassificacao);
            	if (filme != null) {
            		if (filmeDAO.UpdateId(filme, this.filme.getId())) {
            			new TelaSucesso(this, "Filme atualizado com sucesso!");      
            		} else {
            			new TelaErro(this, "Não foi possível atualizar o filme no banco de dados.");
            		}
            	}
            }
        });
        add(btnAtualizar);
    }
    private Filme atualizarFilme(JTextField txtTitulo, JTextField txtPreco, JTextField txtDistribuidora, JTextField txtPoster, JTextField txtDuracao, JTextField txtAno, JComboBox<String> boxGenero, JComboBox<String> boxClassificacao) {
    	Filme filme = null;
    	try {
    		String titulo = txtTitulo.getText();
    		String distribuidora = txtDistribuidora.getText();
    		String poster = txtPoster.getText();
    		String genero = boxGenero.getItemAt(boxGenero.getSelectedIndex());
    		String classificacao = boxClassificacao.getItemAt(boxClassificacao.getSelectedIndex());
    		if(titulo.isBlank()) {
    			throw new RuntimeException("O campo Título não foi preenchido.");
    		}
    		if(distribuidora.isBlank()) {
    			throw new RuntimeException("O campo Distribuidora não foi preenchido.");
    		}
    		if(boxGenero.getSelectedIndex()==0) {
    			throw new RuntimeException("Nenhum gênero foi selecionado.");
    		}
    		if(boxClassificacao.getSelectedIndex()==0) {
    			throw new RuntimeException("Nenhuma classificação foi selecionada.");
    		}
    		if(poster.isBlank()) {
    			poster = "/recursos/Erro404.png";
    		}
    		Double preco = null;
    		Integer duracao = null;
    		Integer ano = null;
    		try { preco = Double.parseDouble(txtPreco.getText().replace(",", ".")); }
    		catch (NumberFormatException e) { throw new RuntimeException("O campo Preço deve ser um número."); }
    		preco = Math.round(preco * 100.0) / 100.0;
    		try { duracao = Integer.parseInt(txtDuracao.getText()); }
    		catch (NumberFormatException e) { throw new RuntimeException("O campo Duração deve ser um número inteiro."); }
    		try { ano = Integer.parseInt(txtAno.getText()); }
    		catch (NumberFormatException e) { throw new RuntimeException("O campo Ano de Lançamento deve ser um número inteiro."); }
    		if(preco<0) {
    			throw new RuntimeException("O Preço não pode ser negativo.");
    		}
    		if(duracao<0) {
    			throw new RuntimeException("A Duração não pode ser negativa.");
    		}
        	filme = new Filme(titulo, preco, distribuidora, poster, duracao, ano, genero, classificacao);
    	} catch(Exception e) {
    		new TelaErro(this, e.getMessage());
    	}
    	return filme;
    }
}
