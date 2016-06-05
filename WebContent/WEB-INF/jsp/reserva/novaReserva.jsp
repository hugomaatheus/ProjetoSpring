<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repeti��o e setar vari�veis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formata��es -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para fun��es -->

<!DOCTYPE html>
<html>
	<head>
		<title>Cadatrar Reserva</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloReserva.css">
	</head>
	<body>
	
	<!-- pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" -->
	
		<header>
			<p>Bem vindo, ${usuarioBD.nome}</p>
			<a href="#Sair">Sair</a>
		</header>
		<c:url var="urlR" value="/reserva/save" />
		<fieldset id="criar"><legend>Cadastrar Reserva</legend>
			<article class="tab_container">
				<form:form method="post" action="${urlR}" modelAttribute="reserva" >		
					<label id="labelmesa"><em>Mesa:</em></label>
					<form:select id="Opmesa" path="mesa.id" items="${mesaSelect}" />
				<br />			
 					<label id="labelinicio"><em>Data Inicio:</em></label>
					<form:input id="txtinicio" type="text" maxlength="10" path="dataInicial" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$"/>
				<br/>
					<label id="labelfim"><em>Data Fim:</em></label>
					<form:input id="txtfim" type="text" maxlength="10" path="dataFinal" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$"/>
				<br/>
					<label id="labelrespon"><em>Responsavel:</em></label>
					<form:input id="txtrespon" type="text" path="nome_Responsavel"/>
				<br />
					<label class="label" id="N de Pessoas"><em>N Pessoas:</em></label>
					<form:input class="set" id="txtpessoas" path="num_pessoa" />
				<br />
  					<label class="label" id="labelSituacao"><em>Situacao:</em></label>
					<form:select id="Opstatus" class="set" path="status">
						<form:option value="ATIVO">ATIVO</form:option>
						<form:option value="INATIVO">INATIVO</form:option>
					</form:select>
					<br />
					<input id="btnreservar" class="btn" type="submit" value="Reservar" />
				</form:form>

			</article>
		</fieldset>
	</body>
</html>