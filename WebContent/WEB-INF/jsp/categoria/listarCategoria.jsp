<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->
 	
<html>
	<head>
		<title>Categoria</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloCategoria.css">
	</head>
	<body>
		<header>
		<c:url var="urlM" value="/gerente/indexGerente"/>
				<input id="menu" class="novo" type="button" onclick="location.href='${urlM}'"; value="Menu" />
			<c:url var="url" value="/categoria/form" />
			<input id="cadatrar" class="novo" type="button" onclick="location.href='${url}'"; value="Cadatrar Categoria" />
			<c:url var="urlOut" value="/logout/"/> 				
			<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
		</header>
			
		<article id="pesquisa"><!-- Centro da pagina -->
			<form:form method="get" action="filtrar" modelAttribute="filtro">
					<label for="txtNumero"><em>Filtrar por:</em></label>
				<br/>
				<label for="txtNumero"><em>Nome:</em></label>
					<form:input id="filtro" path="nome" type="text" />

					<input id="btnPesquisar" type="submit" value="Pesquisar" />
			</form:form>
		</article>
		
		<article class="tabContainer" id="lista">
			<table>
				<tr>
					<th class="tabela-coluna"><span>Codigo</span></th>
					<th class="tabela-coluna"><span>Descricao</span></th>
					<th class="tabela-coluna"><span>Status</span></th>
					<th class="tabela-coluna"><span>Acoes</span></th>
				</tr>
			</table>

		<article class="scrollContainer">
			<table>
			<c:forEach var="categoria" items="${categorias}" >
				<tr>
					<td class="tabela-coluna"><span>${categoria.id}</span></td>
					<td class="tabela-coluna"><span>${categoria.nome}</span></td>
					<td class="tabela-coluna"><span>${categoria.status}</span></td>
					<td class="tabela-coluna">
						<span>
							<a href='<c:url value="/categoria/${categoria.id}/remove" />'>[inativar]</a>
							<a href='<c:url value="/categoria/${categoria.id}/formUpdate" />'>[editar]</a>
						</span>
					</td>
				</tr>
			</c:forEach>	
			</table>
		</article>
		</article>
			
		<footer><!-- cabeÃ§alho da pagina -->
				
		</footer> 
	</body>
</html>