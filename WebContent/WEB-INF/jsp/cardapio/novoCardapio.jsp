<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->
<%@ page import=" br.com.util.*"%>


<!DOCTYPE html>
<html>

	<head>
		<title>Cadastra Cardapio</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloCardapio.css">
	</head>

	<body>
	
		<c:url var="url" value="/cardapio/save" />

		<header>
			<c:url var="urlList" value="/cardapio/listar"/>
			<input id="btnVoltar" class="novo" type="button" onclick="window.location.href='${urlList}'" value="Voltar"/>
			<c:url var="urlOut" value="/logout/"/> 				
			<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
		</header>

	<article class="article">
		<form:form method="post" action="${url}" modelAttribute="cardapio" >
 			<fieldset id = criar><legend>Cadastro Cardapio</legend>
 						
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
					<c:url var="urlBack" value="/cardapio/listar"/>
						<input class="btn" type="submit" value="Adicionar" />
						<a class="btn" href="${urlBack}">Voltar</a>
			</fieldset>	
		</form:form>
	</article>	

	</body>

</html>