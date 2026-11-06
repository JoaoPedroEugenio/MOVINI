package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import modelo.Filme;

public class FilmeDAO {
	private Conexao conexao = new Conexao();
	
	public boolean Insert(Filme filme) {
		Connection conn = null;
		try {
			String sql = "INSERT INTO filme (id, titulo, preco, distribuidora, poster, duracao, ano_lancamento, genero, classificao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = conexao.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filme.getId());
			ps.setString(2, filme.getTitulo());
			ps.setDouble(3, filme.getPreco());
			ps.setString(4, filme.getDistribuidora());
			ps.setString(5, filme.getPoster());
			ps.setInt(6, filme.getDuracao());
			ps.setString(7, filme.getGenero());
			ps.setString(8, filme.getClassificao());
			ps.setInt(9, filme.getAno_lancamento());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			conexao.close(conn);
		}
	}
	
	public ArrayList<Filme> SelectGeral() {
		Connection conn = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		try {
			String sql = "SELECT * FROM filme";
			conn = conexao.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Filme filme = new Filme();
				filme.setId(rs.getInt("id"));
				filme.setTitulo(rs.getString("titulo"));
				filme.setPreco(rs.getDouble("preco"));
				filme.setDistribuidora(rs.getString("distribuidora"));
				filme.setPoster(rs.getString("poster"));
				filme.setDuracao(rs.getInt("duracao"));
				filme.setAno_lancamento(rs.getInt("ano_lancamento"));
				filme.setClassificao(rs.getString("classificacao"));
				filme.setGenero(rs.getString("genero"));
				filmes.add(filme);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			conexao.close(conn);
		}
		return filmes;
	}
	public boolean Update(Filme filme) {
		Connection conn = null;
		try {
			String sql = "UPDATE filme (id, titulo, preco, distribuidora, poster, duracao, genero, classificao, ano_lancamento) SET (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = conexao.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filme.getId());
			ps.setString(2, filme.getTitulo());
			ps.setDouble(3, filme.getPreco());
			ps.setString(4, filme.getDistribuidora());
			ps.setString(5, filme.getPoster());
			ps.setInt(6, filme.getDuracao());
			ps.setString(7, filme.getGenero());
			ps.setString(8, filme.getClassificao());
			ps.setInt(9, filme.getAno_lancamento());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			conexao.close(conn);
		}
	}
	public boolean DeleteId(int id) {
		Connection conn = null;
		try {
			String sql = "DELETE filme WHERE id = ?";
			conn = conexao.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			conexao.close(conn);
		}
	}
	
}
