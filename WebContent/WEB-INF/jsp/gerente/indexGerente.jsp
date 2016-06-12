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
<link rel="stylesheet" type="text/css" href="estilos/estiloIndex.css">
</head>
<body>

	<header>
		<c:url var="urlOut" value="/logout/" />
		<input id="btnSair" class="novo" type="button"
			onclick="window.location.href='${urlOut}'" value="Sair" />
	</header>

	<fieldset>
		<legend>Menu</legend>
		<article class="tab_container" id="Pedidos-gerente">

			<c:url var="urlT" value="/tradicional/listar" />
			<input class="botao" type="button"
				onclick="window.location.href='${urlT}'" value="Pagina Pedido"></input>

		</article>
		<article class="tabContainer" id="Reserva">

			<c:url var="urlR" value="/reserva/listar" />
			<input class="botao" type="button"
				onclick="window.location.href='${urlR}'" value="Pagina Reserva"></input>

		</article>
		<article class="tab_container" id="Categoria">

			<c:url var="urlCat" value="/categoria/listar" />
			<input class="botao" type="button"
				onclick="window.location.href=('${urlCat}')"
				value="Pagina Categoria"></input>

		</article>
		<article class="tabContainer" id="Cardapio">

			<c:url var="urlC" value="/cardapio/listar" />
			<input class="botao" type="button"
				onclick="window.location.href=('${urlC}')" value="Pagina Cardapio"></input>

		</article>
		<article class="tab_container" id="Mesa">

			<c:url var="urlMesa" value="/mesa/listar" />
			<input class="botao" type="button"
				onclick="window.location.href=('${urlMesa}')" value="Pagina Mesa"></input>

		</article>
		<article class="tabContainer" id="Funcionario">

			<c:url var="urlF" value="/gerente/listar" />
			<input class="botao" type="button"
				onclick="window.location.href=('${urlF}')"
				value="Pagina Funcionario"></input>

		</article>
	</fieldset>

</body>
</html>