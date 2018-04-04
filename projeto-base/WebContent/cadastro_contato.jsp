<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<title>Cadastro Contato</title>
</head>
<body style="background-color: #E0F8F7;">

	<div class="container">
		<form id="contact" action="CadastroContatoController" method="post">
			<h3>Cadastro de Contato</h3>
			<fieldset>
				<input placeholder="Seu nome" name="nome" type="text" id="nome"
					tabindex="1" required autofocus>
			</fieldset>
			<fieldset>
				<input placeholder="Seu email" name="email" type="email" id="email"
					tabindex="2" required>
			</fieldset>
			<fieldset>
				<input placeholder="Seu telefone" name="telefone" type="tel"
					id="telefone" tabindex="3" required>
			</fieldset>
			<fieldset>
				<button name="Enviar" type="submit" id="contact-submit"
					data-submit="...Sending">Enviar</button>
			</fieldset>
		</form>
	</div>
	<div align="center">
		<h2>Cadastrados</h2>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Telefone</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contatos}" var="contatos">
					<tr>
						<td><c:out value="${contatos.id}" /></td>
						<td><c:out value="${contatos.nome}" /></td>
						<td><c:out value="${contatos.email}" /></td>
						<td><c:out value="${contatos.telefone}" /></td>
						<td>
						<a href="CadastroContatoController?action=editar&id=<c:out value='${contatos.id}'/>"
							class="btn btn-info" class="blacks">Editar</a> 
						<a href="CadastroContatoController?action=deletar&id=<c:out value='${contatos.id}' />"
							class="btn btn-info" class="blacks">Remover</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
	</div>
</body>
</html>