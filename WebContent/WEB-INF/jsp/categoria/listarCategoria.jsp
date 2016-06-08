<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->
 	
<html>
	<head>
		<title>titulo da pagina</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloCategoria.css">
	</head>
	<body>
		<header>
			<c:url var="url" value="/categoria/form" />
			<input id="novo" type="button" onclick="location.href='${url}'"; value="Cadatrar Categoria" />
			<a href="#Sair">Sair</a>
		</header>
			
		<article id="pesquisa"><!-- Centro da pagina -->
			<form method="get" action="filtrar">
					<label for="txtNumero"><em>Filtrar por nome:</em></label>

					<input id="filtro" name="nome" type="text" />

					<input id="btnPesquisar" type="submit" value="Pesquisar" />
			</form>
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
		<c:url var="urlBack" value="/gerente/indexGerente"/>
		<a class="btn" href="${urlBack}">Voltar</a>
			
		<footer><!-- cabeÃ§alho da pagina -->
				
		</footer> 
	</body>
</html>