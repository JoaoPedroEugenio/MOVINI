package tela;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaConfirmacao extends JDialog {
	private static final long serialVersionUID = 1L;
	final private Color COR_FUNDO_BOTAO = new Color(86, 126, 187);
	final private Color COR_TEXTO_BOTAO = new Color(238, 243, 249);
	final private Color COR_FUNDO_BOTAO_SAIR = new Color(43, 76, 126);
	final private Color COR_TEXTO_TITULO = new Color(31, 31, 32);
	final private Color COR_FUNDO_TELA = new Color(220, 224, 230);
	private boolean decisao = false;
	
	public TelaConfirmacao(JFrame pai) {
		super(pai, "Confirmação", true);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(245, 173);
		getContentPane().setBackground(COR_FUNDO_TELA);
		this.setLocationRelativeTo(pai); //Inicia centralizado na tela
		init();
		setVisible(true);
	}
	private void init() {
		JLabel mensagem = new JLabel();
		mensagem.setText("Tem certeza?");
		mensagem.setFont(new Font("sansserif", 1, 20));
		mensagem.setBounds(47, 15, 185, 30);
		mensagem.setForeground(COR_TEXTO_TITULO);
		add(mensagem);
		
		JButton sim = new JButton();
		sim.setText("Sim");
		sim.setFont(new Font("SansSerif", 1, 20));
		sim.setBackground(COR_FUNDO_BOTAO);
		sim.setForeground(COR_TEXTO_BOTAO);
		sim.setBounds(20, 70, 85, 35);
		add(sim);
		sim.addActionListener(e -> {
			decisao = true;
			dispose();
		});
		
		JButton nao = new JButton();
		nao.setText("Não");
		nao.setFont(new Font("SansSerif", 1, 20));
		nao.setBackground(COR_FUNDO_BOTAO_SAIR);
		nao.setForeground(COR_TEXTO_BOTAO);
		nao.setBounds(sim.getX()+sim.getWidth()+20, sim.getY(), sim.getWidth(), sim.getHeight());
		add(nao);
		nao.addActionListener(e -> {
			decisao = false;
			dispose();
		});
	}
	public boolean getDecisao() {
		return decisao;
	}
}
