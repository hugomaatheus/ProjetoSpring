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
		<title>titulo da pagina</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloCategoria.css">
	</head>

	<body>
	
	<c:url var="url" value="/categoria/save" />
	
		<header>
			<c:url var="urlList" value="/categoria/listar"/>
			<input id="btnVoltar" class="novo" type="button" onclick="window.location.href='${urlList}'" value="Voltar"/>
			<c:url var="urlOut" value="/logout/"/> 				
			<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
		</header>

		<article class="cont_tab" id="Read">
			<form:form method="post" action="${url}" modelAttribute="categoria">
				<fieldset id="criar"><legend>Cadastrar Categoria</legend>
					<label for="txtNome"><em>Nome:</em></label>
					<form:input path="nome" id="txtNome" required="required" />
					<br />
					<label for="Opstatus"><em>Status:</em></label>
					<form:select id="Opstatus" class="categoria" path="status">
						<form:option value="ATIVO">ATIVO</form:option>
						<form:option value="INATIVO">INATIVO</form:option>
					</form:select>
					<br />
					<input id="btnAdicionar" class="btn" type="submit" value="Adicionar" />
				</fieldset>
			</form:form>
		</article>

	</body>
</html>