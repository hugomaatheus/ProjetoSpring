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
			<c:url var="urlList" value="/reserva/listar"/>
			<input id="btnVoltar" class="novo" type="button" onclick="window.location.href='${urlList}'" value="Voltar"/>
			<c:url var="urlOut" value="/logout/"/> 				
			<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
		</header>
		<c:url var="urlR" value="/reserva/save" />
		<fieldset id="criar"><legend>Cadastrar Reserva</legend>
			<article class="tab_container">
				<form:form method="post" action="${urlR}" modelAttribute="reserva" >
					
					<form:input type="hidden" path="usuario.id" required="required" items="${usuarioBD}" />
						
					<label id="labelmesa"><em>Mesa:</em></label>
					<form:select id="Opmesa" path="mesa.id" items="${mesaSelect}" />
				<br />			
 					<label id="labelinicio"><em>Data Inicio:</em></label>
					<form:input id="txtinicio" path="dataInicial" placeholder="dd/mm/aaaa hh:mm" required="required" maxlength="16" title="Digite no formato dd/mm/aaaa hh:mm" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4} [0-9]{2}:[0-9]{2}$"/>
					<form:errors path="dataInicial" />
				<br/>
					<label id="labelfim"><em>Data Fim:</em></label>
					<form:input id="txtfim" path="dataFinal" placeholder="dd/mm/aaaa hh:mm" required="required" maxlength="16" title="Digite no formato dd/mm/aaaa hh:mm" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4} [0-9]{2}:[0-9]{2}$"/>
					<form:errors path="dataFinal"/>
				<br/>
					<label id="labelrespon"><em>Responsavel:</em></label>
					<form:input id="txtrespon" type="text" path="nome_Responsavel" required="required" title="Digite um nome" pattern="[a-zA-Z ]+$"/>
				<br />
					<label class="label" id="N de Pessoas"><em>N Pessoas:</em></label>
					<form:input class="set" id="txtpessoas" path="num_pessoa" required="required" />
				<br />
   					<label class="label" id="labelSituacao"><em>Situacao:</em></label>
					<form:select id="Opstatus" class="set" path="status">
						<form:option value="LIVRE">LIVRE</form:option>
						<form:option value="OCUPADO">OCUPADO</form:option>
					</form:select>
					<br />
					<input id="btnreservar" class="btn" type="submit" value="Reservar" />
				</form:form>

			</article>
		</fieldset>
	</body>
</html>