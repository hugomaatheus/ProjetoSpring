<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- para funções -->

<!DOCTYPE html>
<html>
<head>
<title>titulo da pagina</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="estilos/estiloGerente.css">
</head>
<body>

	<header>
		<c:url var="urlOut" value="/logout/" />
		<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair" />
	</header>

	<article>
		<fieldset id="criar"><legend>Menu</legend>

			<c:url var="urlT" value="/tradicional/listar" />
			<input id="pedido" class="botao" type="button" onclick="window.location.href='${urlT}'" value="Pagina Pedido"/>

			<c:url var="urlR" value="/reserva/listar" />
			<input id="reserva" class="botao" type="button" onclick="window.location.href='${urlR}'" value="Pagina Reserva"/>

			<c:url var="urlCat" value="/categoria/listar" />
			<input id="categoria" class="botao" type="button" onclick="window.location.href=('${urlCat}')" value="Pagina Categoria"/>
		<br />
			<c:url var="urlC" value="/cardapio/listar" />
			<input id="cardapio" class="botao" type="button" onclick="window.location.href=('${urlC}')" value="Pagina Cardapio"/>

			<c:url var="urlMesa" value="/mesa/listar" />
			<input id="mesa" class="botao" type="button" onclick="window.location.href=('${urlMesa}')" value="Pagina Mesa"/>

			<c:url var="urlF" value="/gerente/listar" />
			<input id="funcionario" class="botao" type="button" onclick="window.location.href=('${urlF}')" value="Pagina Funcionario"/>
			
		</fieldset>
	</article>
</body>
</html>