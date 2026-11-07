package tela;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaErro extends JFrame {
	private static final long serialVersionUID = 1L;
	final private Color COR_FUNDO_BOTAO = new Color(86, 126, 187);
	final private Color COR_TEXTO_BOTAO = new Color(238, 243, 249);
	final private Color COR_TEXTO_TITULO = new Color(31, 31, 32);
	final private Color COR_FUNDO_TELA = new Color(220, 224, 230);
	private String msg;
	
	public TelaErro(JFrame pai, String msg) {
		this.msg = msg;
		setTitle("Erro");
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(320, 190);
		getContentPane().setBackground(COR_FUNDO_TELA);
		this.setLocationRelativeTo(pai); 
		init();
		setVisible(true);
	}
	private void init() {
		JLabel titulo = new JLabel();
		titulo.setText("Algo deu errado");
		titulo.setFont(new Font("SansSerif", 1, 18));
		titulo.setBounds(0, 12, 304, 25);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setForeground(COR_TEXTO_TITULO);
		add(titulo);
		
		JLabel mensagem = new JLabel();
		mensagem.setText("<html><center>" + msg + "</center></html>");
		mensagem.setFont(new Font("SansSerif", 0, 14));
		mensagem.setBounds(20, 42, 264, 60);
		mensagem.setHorizontalAlignment(JLabel.CENTER);
		mensagem.setVerticalAlignment(JLabel.TOP);
		mensagem.setForeground(COR_TEXTO_TITULO);
		add(mensagem);
		
		JButton ok = new JButton();
		ok.setText("Ok");
		ok.setFont(new Font("SansSerif", 1, 20));
		ok.setBackground(COR_FUNDO_BOTAO);
		ok.setForeground(COR_TEXTO_BOTAO);
		ok.setBounds(110, 110, 85, 35);
		add(ok);
		ok.addActionListener(e -> {
			dispose();
		});
	}
}
