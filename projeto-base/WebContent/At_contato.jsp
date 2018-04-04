<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<title><c:out value="${contato.nome}" /></title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">
</head>
<body style="background-color: #E0F8F7;">

	<br />

	<div class="container">
		<form id="contact" action="CadastroContatoController" >
			<h3>Atualizar Contato</h3>
			<input type="hidden" readonly="readonly" name="id" id="id"
				value="<c:out value="${contato.id}" />" /> 
			<input type="hidden" readonly="readonly" name="action" id="action" 
				value="atualizar" />
			<fieldset>
				<input placeholder="Seu nome" name="nome" type="text" id="nome"
					tabindex="1" required autofocus
					value=" <c:out value="${contato.nome}"/>">
			</fieldset>
			<fieldset>
				<input placeholder="Seu email" name="email" type="email" id="email"
					tabindex="2" required value="<c:out value="${contato.email}"/>">
			</fieldset>
			<fieldset>
				<input placeholder="seu telefone" name="telefone" type="tel"
					id="telefone" tabindex="3" required
					value="<c:out value="${contato.telefone}"/>">
			</fieldset>
			<fieldset>
				<button name="Enviar" type="submit" id="contact-submit"
					data-submit="...Sending">Enviar</button>
			</fieldset>
		</form>
	</div>
</body>
</html>