package tela;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame{
	final private Color COR_FUNDO_BOTAO = new Color(86, 126, 187);
	final private Color COR_TEXTO_BOTAO = new Color(238, 243, 249);
	final private Color COR_FUNDO_BOTAO_SAIR = new Color(43, 76, 126);
	final private Color COR_TEXTO_TITULO = new Color(31, 31, 32);
	final private Color COR_FUNDO_TELA = new Color(220, 224, 230);
	final private Color COR_PAINEL_CABECALHO = new Color(167, 176, 190, 45);
	
	public TelaPrincipal() {
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(586, 520);
		getContentPane().setBackground(COR_FUNDO_TELA); //Fundo da tela
		this.setLocationRelativeTo(null); //Inicia centralizado na tela
		init();
		JPanel painelInvisivel = new JPanel();
		painelInvisivel.setPreferredSize(new Dimension(1, 800)); // Altura virtual para a barra aparecer		
		setVisible(true);
	}
	private void init() {
		
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("MOVINI");
		lblTitulo.setFont(new Font("SansSerif", 1, 64));
		lblTitulo.setForeground(COR_TEXTO_TITULO);
		lblTitulo.setBounds(40, 5, 250, 80);
		add(lblTitulo);
		
		JLabel lblLinhaTitulo = new JLabel();
		lblLinhaTitulo.setBackground(COR_FUNDO_BOTAO);
		lblLinhaTitulo.setOpaque(true);
		lblLinhaTitulo.setBounds(lblTitulo.getX(), lblTitulo.getHeight()+lblTitulo.getY()-11, lblTitulo.getWidth(), 2);
		add(lblLinhaTitulo);

		JLabel lblSubtitulo = new JLabel();
		lblSubtitulo.setText("Catálogo e cadastro de filmes");
		lblSubtitulo.setFont(new Font("arial", 0, 20));
		lblSubtitulo.setBounds(lblTitulo.getX()+30, lblTitulo.getY()+lblTitulo.getHeight()-5, 275, 25);
		add(lblSubtitulo);
		
		JLabel lblLinhaSubitulo = new JLabel();
		lblLinhaSubitulo.setBackground(COR_FUNDO_BOTAO);
		lblLinhaSubitulo.setOpaque(true);
		lblLinhaSubitulo.setBounds(lblSubtitulo.getX(), lblSubtitulo.getHeight()+lblSubtitulo.getY()-2, lblSubtitulo.getWidth(), 2);
		add(lblLinhaSubitulo);
		
		JLabel lblCabecalho = new JLabel();
		lblCabecalho.setOpaque(true);
		lblCabecalho.setBackground(COR_PAINEL_CABECALHO);
		lblCabecalho.setBounds(20, 10, 340, 100);
		add(lblCabecalho);
		
		JButton btnCatalogo = new JButton();
		btnCatalogo.setText("Catálogo");
		btnCatalogo.setFont(new Font("SansSerif", 1, 40));
		btnCatalogo.setBackground(COR_FUNDO_BOTAO);
		btnCatalogo.setForeground(COR_TEXTO_BOTAO);
		btnCatalogo.setBounds(40, 170, 490, 60);
		add(btnCatalogo);

		JButton btnCadastro = new JButton();
		btnCadastro.setText("Cadastro");
		btnCadastro.setFont(new Font("SansSerif", 1, 40));
		btnCadastro.setBackground(COR_FUNDO_BOTAO);
		btnCadastro.setForeground(COR_TEXTO_BOTAO);
		btnCadastro.setBounds(btnCatalogo.getX(), btnCatalogo.getY()+btnCatalogo.getHeight()+25, 220, 60);
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
		btnEditar.setBounds(btnCadastro.getX()+btnCadastro.getWidth()+50, btnCadastro.getY(), 220, 60);
		add(btnEditar);

		JButton btnSair = new JButton();
		btnSair.setText("Sair");
		btnSair.setFont(new Font("SansSerif", 1, 40));
		btnSair.setBackground(COR_FUNDO_BOTAO_SAIR);
		btnSair.setForeground(COR_TEXTO_BOTAO);
		btnSair.setBounds(175, btnCadastro.getY()+btnCadastro.getHeight()+55, 220, 60);
		btnSair.addActionListener(e -> {
			dispose();
			System.exit(0);
		});
		add(btnSair);
		
	}
}
