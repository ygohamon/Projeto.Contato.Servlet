package br.com.base.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.base.model.Contato;
import br.com.base.service.ContatoService;

@WebServlet("/CadastroContatoController")
public class CadastroContatoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ContatoService service;
	
	private Contato contato;
       
    public CadastroContatoController() throws SQLException {
    	this.service = new ContatoService();
    	this.contato = new Contato();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		try {
			switch (action) {
				
			case "editar":
				editarContato(request, response);
				break;
					
			case "deletar": 
				deletarContato(request, response);
				break;
					
			case "atualizar":
				atualizarContato(request, response);
				break;
					
			case "listar":
				listarContatos(request, response);
				break;
					
			default:
				listarContatos (request, response);
				break;
			}
				
		}catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	private void listarContatos (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		List<Contato> contatos = this.service.listarContato();
		request.setAttribute("contatos", contatos);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro_contato.jsp");
		rd.forward(request, response);
	}
	
	private void deletarContato (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		long id = Long.parseLong(request.getParameter("id"));
		this.service.removerContato(id);
		listarContatos(request, response);
	}
	
	private void editarContato (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Contato contatoExistente = this.service.buscar(id);
		RequestDispatcher rd = request.getRequestDispatcher("At_contato.jsp");
		request.setAttribute("contato", contatoExistente);
		rd.forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		this.contato.setNome(nome);
		this.contato.setEmail(email);
		this.contato.setTelefone(telefone);
		
		try {
			service.salvar(contato);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		try {
			listarContatos(request, response);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	private void atualizarContato (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		System.out.println("Chegou no Atualizar");
		String nome = request.getParameter("nome");
		System.out.println(nome);
		String email = request.getParameter("email");
		System.out.println(email);
		String telefone = request.getParameter("telefone");
		System.out.println(telefone);
		
		Contato contatoAtualizar = new Contato();
		
		contatoAtualizar.setNome(nome);
		contatoAtualizar.setEmail(email);
		contatoAtualizar.setTelefone(telefone);
		contatoAtualizar.setId(id);
		
		this.service.alterar(contatoAtualizar);
		listarContatos(request, response);
	}
}