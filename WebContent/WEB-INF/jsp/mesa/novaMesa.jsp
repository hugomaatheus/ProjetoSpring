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
		<title>Cadastrar Mesa</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloMesa.css">
	</head>
	<body>

		<header>
			<c:url var="urlList" value="/mesa/listar"/>
			<input id="btnVoltar" class="novo" type="button" onclick="window.location.href='${urlList}'" value="Voltar"/>
			<c:url var="urlOut" value="/logout/"/> 				
			<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
		</header>
		
		<c:url var="url" value="/mesa/save" />

		<article class="article">
				<fieldset id = criar><legend>Cadastrar Mesa</legend>
					<form:form method="post" action="${url}" modelAttribute="mesa" >
				<br />
					<label id="labeldescricao"><em>Numero:</em></label>
					<form:input id="txtdescricao" path="numero" title="Digite apenas numeros" placeholder="Somente numeros" pattern="[0-9]+$" />
				<br />
					<label id="labelcapacidade"><em>Capacidade:</em></label>
					<form:input id="txtcapacidade" path="capacidade" type="text" pattern="[0-9]+$"/>
				<br />
					<label id="labelreserva"><em>De reserva?</em></label>
					<form:select id="Opreserva" class = "categoria" path="status">
						<form:option value="SIM">SIM</form:option>
						<form:option value="NAO">NAO</form:option>
					</form:select>
				<br />
					<input id="btnAdicionar" class="btn" type="submit" value="Adicionar" />
				</form:form>
			</fieldset>
		</article>
	</body>
</html>