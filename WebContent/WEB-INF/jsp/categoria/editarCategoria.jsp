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
		<title>Editar Categoria</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../../estilos/estiloCategoria.css">
	</head>

	<body>
	
	<c:url var="url" value="/categoria/update" />
	
		<header>
			<a id="sair" href="#Sair">Sair</a>
		</header>

		<article class="cont_tab" id="Read">
			<form:form method="post" action="${url}" modelAttribute="categoria">
				<fieldset id="criar"><legend>Editar Categoria</legend>
				<form:hidden path="id"/>
					<label for="txtNome"><em>Nome:</em></label>
					<form:input path="nome" id="txtNome" />
					<br />
					<label for="Opstatus"><em>Status:</em></label>
					<form:select id="Opstatus" class="categoria" path="status">
						<form:option value=""></form:option>
						<form:option value="ATIVO">ATIVO</form:option>
						<form:option value="INATIVO">INATIVO</form:option>
					</form:select>
					<br />					
					<input id="btnAdicionar" class="btn" type="submit" value="Adicionar" />
					<c:url var="urlBack" value="/categoria/listar"/>
					<a class="btn" href="${urlBack}">Voltar</a>
				</fieldset>
			</form:form>
		</article>

	</body>
</html>