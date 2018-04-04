/**
 * 
 */
package br.com.base.service;

import java.sql.SQLException;
import java.util.List;

import br.com.base.model.Contato;
import br.com.base.repository.ContatoRepository;

/**
 * @author lab04usuario06
 *
 */
public class ContatoService {

	private ContatoRepository repository;
	
	public ContatoService() throws SQLException {
		this.repository = new ContatoRepository();
	}
	
	public void salvar(Contato contato) throws SQLException {
		this.repository.salvar(contato);
	}
	
	public List<Contato> listarContato() throws SQLException{
		return this.repository.listarContatos();
	}
	
	public void removerContato(Long idContato) throws SQLException {
		this.repository.removerContato(idContato);
	}
	
	public void alterar(Contato contato) throws SQLException {
		this.repository.alterar(contato);
	}
	
	public Contato buscar(long id) throws SQLException {
		return this.repository.buscar(id);
	}

	public ContatoRepository getRepository() {
		return repository;
	}

	public void setRepository(ContatoRepository repository) {
		this.repository = repository;
	}
}
