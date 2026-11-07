package modelo;

public class Filme {
	private int id;
	private String titulo;
	private double preco;
	private String distribuidora;
	private String poster;
	private int duracao;
	private int ano_lancamento;
	private String genero;
	private String classificao;
	
	public Filme() {}
	public Filme(String titulo, double preco, String distribuidora, String poster, int duracao, int ano_lancamento, String genero,
			String classificao) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.distribuidora = distribuidora;
		this.poster = poster;
		this.duracao = duracao;
		this.ano_lancamento = ano_lancamento;
		this.genero = genero;
		this.classificao = classificao;
	}
	public Filme(int id, String titulo, double preco, String distribuidora, String poster, int duracao, int ano_lancamento, String genero,
			String classificao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.preco = preco;
		this.distribuidora = distribuidora;
		this.poster = poster;
		this.duracao = duracao;
		this.ano_lancamento = ano_lancamento;
		this.genero = genero;
		this.classificao = classificao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public int getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getClassificao() {
		return classificao;
	}

	public void setClassificao(String classificao) {
		this.classificao = classificao;
	}
	
}