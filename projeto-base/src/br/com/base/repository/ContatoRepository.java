package br.com.base.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.base.main.Conection;
import br.com.base.model.Contato;

public class ContatoRepository {

	private Connection conexao;
	
	public ContatoRepository() throws SQLException {
		this.conexao = Conection.getConnection();
	}
	
	public void salvar(Contato contato) throws SQLException {
		
		this.conexao = Conection.getConnection();
		
		String sql = "INSERT INTO contato (nome,email,telefone) VALUES (?,?,?)";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getTelefone());
		
		stmt.execute();
		
		stmt.close();
	}
	
	public List<Contato> listarContatos() throws SQLException{
		
		this.conexao = Conection.getConnection();
		
		List<Contato> contatos = new ArrayList<>();
		String sql = "SELECT * FROM contato ";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		ResultSet res = stmt.executeQuery();
		while(res.next()) {
			
			Contato contato = new Contato();
			contato.setId(res.getLong("id"));
			contato.setNome(res.getString("nome"));
			contato.setEmail(res.getString("email"));
			contato.setTelefone(res.getString("telefone"));
			
			contatos.add(contato);
		}
		
		res.close();
		stmt.close();
		this.conexao.close();
		
		return contatos;
		
	}
	
	public void removerContato(Long Id) throws SQLException{
		
		this.conexao = Conection.getConnection();
		
		String sql = "DELETE FROM contato WHERE ID = ? ";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		stmt.setLong(1, Id);
		stmt.execute();
		stmt.close();
		this.conexao.close();
	}
	
	public boolean alterar(Contato contato) throws SQLException {
		
		this.conexao = Conection.getConnection();
		
		String update = "UPDATE contato SET nome = ?, email = ?, telefone = ? "
				+ " WHERE id = ? ";
		
		PreparedStatement state = this.conexao.prepareStatement(update);
		
		state.setString(1, contato.getNome());
		state.setString(2, contato.getEmail());
		state.setString(3, contato.getTelefone());
		state.setLong(4, contato.getId());
		
		boolean atualizado = state.executeUpdate() > 0;
		state.close();
		
		return atualizado;
	}
	public Contato buscar (Long id) throws SQLException{
		
		this.conexao = Conection.getConnection();
		
		Contato contato = new Contato();
		String sql = "SELECT * FROM contato WHERE id = ? ";
		
		PreparedStatement state = this.conexao.prepareStatement(sql);
		state.setLong(1, id);
		
		ResultSet result = state.executeQuery();
		while(result.next()) {
			
			contato.setId(result.getLong("id"));
			contato.setNome(result.getString("nome"));
			contato.setEmail(result.getString("email"));
			contato.setTelefone(result.getString("telefone"));
		}
		
		state.close();
		result.close();
		this.conexao.close();
		
		return contato;
	}

}
