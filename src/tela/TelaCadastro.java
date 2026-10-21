package tela;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TelaCadastro extends JFrame{
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
		setSize(586, 520);
		getContentPane().setBackground(COR_FUNDO_TELA);
		this.setLocationRelativeTo(null); //Inicia centralizado na tela
		init();
		setVisible(true);
	}
	private void init() {
		
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("MOVINI - CADASTRO");
		lblTitulo.setFont(new Font("SansSerif", 1, 24));
		lblTitulo.setForeground(COR_TEXTO_TITULO);
		lblTitulo.setBounds(10, 8, 550, 30);
		add(lblTitulo);
		
		JLabel lblLinhaTitulo = new JLabel();
		lblLinhaTitulo.setBackground(COR_FUNDO_BOTAO);
		lblLinhaTitulo.setOpaque(true);
		lblLinhaTitulo.setBounds(lblTitulo.getX(), lblTitulo.getHeight()+lblTitulo.getY()-2, lblTitulo.getWidth(), 2);
		add(lblLinhaTitulo);
		
		JLabel lblCabecalho = new JLabel();
		lblCabecalho.setOpaque(true);
		lblCabecalho.setBackground(COR_PAINEL_CABECALHO);
		lblCabecalho.setBounds(0, 0, getWidth(), lblLinhaTitulo.getY()+lblLinhaTitulo.getHeight()+5);
		add(lblCabecalho);
		
		JLabel lblNome = new JLabel();
		lblNome.setText("Nome:");
		lblNome.setFont(new Font("sansserif", 1, 20));
		lblNome.setBounds(lblTitulo.getX()+5, 70, 120, 30);
		lblNome.setForeground(COR_TEXTO_LABEL);
		add(lblNome);
		
		JTextField txtNome = new JTextField();
		txtNome.setFont(new Font("sansserif", 0, 20));
		txtNome.setBounds(160, lblNome.getY(), 400, 30);
		txtNome.setBorder(null);
		txtNome.setForeground(COR_TEXTO_LABEL);
		add(txtNome);
		
		JLabel lblPreco = new JLabel();
		lblPreco.setText("Preço:");
		lblPreco.setFont(new Font("sansserif", 1, 20));
		lblPreco.setBounds(lblTitulo.getX()+5, lblNome.getY()+lblNome.getHeight()+20, 120, 30);
		lblPreco.setForeground(COR_TEXTO_LABEL);
		add(lblPreco);
		
		JTextField txtPreco = new JTextField();
		txtPreco.setFont(new Font("sansserif", 0, 20));
		txtPreco.setBounds(160, lblPreco.getY(), 400, 30);
		txtPreco.setBorder(null);
		txtPreco.setForeground(COR_TEXTO_LABEL);
		add(txtPreco);
		
		JLabel lblDistribuidora = new JLabel();
		lblDistribuidora.setText("Distribuidora:");
		lblDistribuidora.setFont(new Font("sansserif", 1, 20));
		lblDistribuidora.setBounds(lblTitulo.getX()+5, lblPreco.getY()+lblPreco.getHeight()+20, 140, 30);
		lblDistribuidora.setForeground(COR_TEXTO_LABEL);
		add(lblDistribuidora);
		
		JTextField txtDistribuidora = new JTextField();
		txtDistribuidora.setFont(new Font("sansserif", 0, 20));
		txtDistribuidora.setBounds(160, lblDistribuidora.getY(), 400, 30);
		txtDistribuidora.setBorder(null);
		txtDistribuidora.setForeground(COR_TEXTO_LABEL);
		add(txtDistribuidora);
		
		JLabel lblPoster = new JLabel();
		lblPoster.setText("Poster (URL):");
		lblPoster.setFont(new Font("sansserif", 1, 20));
		lblPoster.setBounds(lblTitulo.getX()+5, lblDistribuidora.getY()+lblDistribuidora.getHeight()+20, 140, 30);
		lblPoster.setForeground(COR_TEXTO_LABEL);
		add(lblPoster);
		
		JTextField txtPoster = new JTextField();
		txtPoster.setFont(new Font("sansserif", 0, 20));
		txtPoster.setBounds(160, lblPoster.getY(), 400, 30);
		txtPoster.setBorder(null);
		txtPoster.setForeground(COR_TEXTO_LABEL);
		add(txtPoster);
		
		JLabel lblDuracao = new JLabel();
		lblDuracao.setText("Duração (Min):");
		lblDuracao.setFont(new Font("sansserif", 1, 20));
		lblDuracao.setBounds(lblTitulo.getX()+5, lblPoster.getY()+lblPoster.getHeight()+20, 140, 30);
		lblDuracao.setForeground(COR_TEXTO_LABEL);
		add(lblDuracao);
		
		JTextField txtDuracao = new JTextField();
		txtDuracao.setFont(new Font("sansserif", 0, 20));
		txtDuracao.setBounds(160, lblDuracao.getY(), 400, 30);
		txtDuracao.setBorder(null);
		txtDuracao.setForeground(COR_TEXTO_LABEL);
		add(txtDuracao);
		
		JLabel lblGenero = new JLabel();
		lblGenero.setText("Duração (Min):");
		lblGenero.setFont(new Font("sansserif", 1, 20));
		lblGenero.setBounds(lblTitulo.getX()+5, lblDuracao.getY()+lblDuracao.getHeight()+20, 140, 30);
		lblGenero.setForeground(COR_TEXTO_LABEL);
		add(lblGenero);
		
		String[] generos = {"Selecione o gênero", "Ação", "Animação", "Aventura", "Comédia", "Documentário", "Drama", "Fantasia", "Faroeste", "Ficção Científica", "Guerra", "Musical", "Romance", "Suspense", "Terror"};
		JComboBox<String> boxGenero = new JComboBox<String>(generos);
		boxGenero.setFont(new Font("sansserif", 0, 20));
		boxGenero.setBounds(160, lblGenero.getY(), 400, 30);
		boxGenero.setBorder(null);
		boxGenero.setForeground(COR_TEXTO_LABEL);
		add(boxGenero);
		
		

		JButton btnVoltar = new JButton();
		btnVoltar.setText("Voltar");
		btnVoltar.setFont(new Font("SansSerif", 1, 24));
		btnVoltar.setBackground(COR_FUNDO_BOTAO);
		btnVoltar.setForeground(COR_TEXTO_BOTAO);
		btnVoltar.setBounds(15, lblGenero.getY()+lblGenero.getHeight()+40, 160, 60);
		btnVoltar.addActionListener(e -> {
			new TelaPrincipal();
			dispose();
		});
		add(btnVoltar);
		
		JButton btnLimpar = new JButton();
		btnLimpar.setText("Limpar");
		btnLimpar.setFont(new Font("SansSerif", 1, 24));
		btnLimpar.setBackground(COR_FUNDO_BOTAO);
		btnLimpar.setForeground(COR_TEXTO_BOTAO);
		btnLimpar.setBounds(btnVoltar.getX()+btnVoltar.getWidth()+30, btnVoltar.getY(), 160, 60);
		btnLimpar.addActionListener(e -> {
			txtNome.setText("");
			txtPreco.setText("");
			txtPoster.setText("");
			txtDuracao.setText("");
			txtDistribuidora.setText("");
			boxGenero.setSelectedItem(generos[0]);
		});
		add(btnLimpar);

		JButton btnSalvar = new JButton();
		btnSalvar.setText("Salvar");
		btnSalvar.setFont(new Font("SansSerif", 1, 24));
		btnSalvar.setBackground(COR_FUNDO_BOTAO_SAIR);
		btnSalvar.setForeground(COR_TEXTO_BOTAO);
		btnSalvar.setBounds(btnLimpar.getX()+btnLimpar.getWidth()+30, btnLimpar.getY(), 160, 60);
		add(btnSalvar);
		
	}
}
