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
			String sql = "INSERT INTO filme (titulo, preco, distribuidora, poster, duracao, ano_lancamento, genero, classificacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			conn = conexao.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, filme.getTitulo());
			ps.setDouble(2, filme.getPreco());
			ps.setString(3, filme.getDistribuidora());
			ps.setString(4, filme.getPoster());
			ps.setInt(5, filme.getDuracao());
			ps.setInt(6, filme.getAno_lancamento());
			ps.setString(7, filme.getGenero());
			ps.setString(8, filme.getClassificao());
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
			String sql = "SELECT * FROM filme ORDER BY id ASC";
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
	
	public ArrayList<Filme> SelectId(int valorBusca) {
		Connection conn = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		try {
			String sql = "SELECT * FROM filme WHERE id = ? ORDER BY id ASC";
			conn = conexao.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, valorBusca);
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
	
	public ArrayList<Filme> SelectTitulo(String valorBusca) {
		Connection conn = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		try {
			String sql = "SELECT * FROM filme WHERE titulo LIKE ? ORDER BY id ASC";
			conn = conexao.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + valorBusca + "%");
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
	
	public boolean UpdateId(Filme filme, int id) {
		Connection conn = null;
		try {
			String sql = "UPDATE filme SET titulo=?, preco=?, distribuidora=?, poster=?, duracao=?, genero=?, classificacao=?, ano_lancamento=? WHERE id=?";
			conn = conexao.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, filme.getTitulo());
			ps.setDouble(2, filme.getPreco());
			ps.setString(3, filme.getDistribuidora());
			ps.setString(4, filme.getPoster());
			ps.setInt(5, filme.getDuracao());
			ps.setString(6, filme.getGenero());
			ps.setString(7, filme.getClassificao());
			ps.setInt(8, filme.getAno_lancamento());
			ps.setInt(9, id);
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
			String sql = "DELETE FROM filme WHERE id = ?";
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
