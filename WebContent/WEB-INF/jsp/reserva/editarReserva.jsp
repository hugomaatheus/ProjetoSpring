<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->

<!DOCTYPE html>
<html>
	<head>
		<title>Editar Cardapio</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloReserva.css">
	</head>
	<body>
		<header>
			<input id="novo" type="button" onclick="location.href='novoCardapio.html'"; value="Cadatrar Cardapio" />
			<a href="#Sair">Sair</a>
		</header>
			<c:url var="url" value="/reserva/update" />
		<fieldset id="criar"><legend>Editar Reserva</legend>
			<article class="tab_container">
				<form:form method="post" action="${url}" modelAttribute="reserva">
				<form:hidden path="id"/>	
					<label id="labelinicio"><em>Data Inicio:</em></label>
					<form:input id="txtinicio" type="date" maxlength="10" path="dataInicio" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$"/>
				<br/>
					<label id="labelfim"><em>Data Fim:</em></label>
					<<form:hidden path="id"/>input id="txtfim" type="date" maxlength="10" path="dataFim" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$"/>
				<br/>
					<label id="labelrespon"><em>Responsavel:</em></label>
					<<form:hidden path="id"/>input id="txtrespon" type="text"/>
				<br />
					<label id="labelmesa"><em>Mesa:</em></label>
					<form:select id="Opmesa" class="categoria" path="mesa.id" items="${mesaSelect}" />
				<br />
					<input id="btnreservar" class="btn" type="submit" value="Reservar" />
				</form:form>
			</article>
		</fieldset>
	</body>
</html>