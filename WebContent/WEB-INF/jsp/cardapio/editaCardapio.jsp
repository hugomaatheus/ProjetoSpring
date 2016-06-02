<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repeti��o e setar vari�veis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formata��es -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para fun��es -->
<%@ page import=" br.com.util.*"%>


<!DOCTYPE html>
<html>

	<head>
		<title>Editar Cardapio</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../../estilos/estiloCardapio.css">
	</head>

	<body>
	
		<c:url var="url" value="/cardapio/update" />

		<header>
			<a id="sair" href="#Sair">Sair</a>
		</header>

	<article class="article">
		<form:form method="post" action="${url}" modelAttribute="cardapio">
 			<fieldset id = criar><legend>Editar Cardapio</legend>
 			 			<form:hidden path="id"/>
 						<label class="label" id="labelCateg"><em>Categoria:</em></label>
                        <form:select id="OpCategoria" class="set" path="categoria.id" items="${categoriasSelect}" />
					<br />
						<label class="label" id="labelNome"><em>Nome:</em></label>
						<form:input path="nome" class="set" id="txtNome" type="text"/>
					<br />
						<label class="label" id="labelpreco"><em>Preco:</em></label>
						<form:input class="set" id="txtpreco" path="preco" />
					<br />
  						<label class="label" id="labelSituacao"><em>Situacao:</em></label>
						<form:select id="Opstatus" class="set" path="status">
							<form:option value="ATIVO">ATIVO</form:option>
							<form:option value="INATIVO">INATIVO</form:option>
						</form:select>
					<br />
						<input class="btn" type="submit" value="Adicionar" />
						<input class="btn" type="button" value="Voltar" />
			</fieldset>	
		</form:form>
	</article>	

	</body>

</html>