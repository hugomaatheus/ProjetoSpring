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
		<title>Lista Cardapio</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloCardapio.css">
	</head>
	<body>
	
		<c:url var="url" value="form"/>
			<header>
				<input id="cadatrar" class="novo" type="button" onclick="location.href='${url}'"; value="Cadatrar Cardapio" />
				<c:url var="urlOut" value="/logout/"/> 				
				<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
			</header>
			
				<article id="pesquisa">
				<form:form action="filtrar" method="get" modelAttribute="filtro">
						<label for="txtNumero"><em>Filtrar por:</em></label>

					<label for="txtNome"><em>nome:</em></label>
					<form:input id="filtro" type="text" path="nome"/>
					<label for="txtCategoria"><em>Categoria:</em></label>
					<form:select id="OpCategoria" path="categoria.id" class="categoria">
						<c:forEach var="categoria" items="${categorias}" >
							<form:option value="">Selecione</form:option>
							<form:option value="${categoria.id}">${categoria.nome}</form:option>
						</c:forEach>
					</form:select>
					<input id="btnPesquisar" class="btn" type="submit" value="Pesquisar" />
				</form:form>
				</article>

				<article class="tabContainer" id="lista">
					<table>
						<tr>
							<th class="tabela-coluna"><span>Codigo</span></th>
							<th class="tabela-coluna"><span>Descricao</span></th>
							<th class="tabela-coluna"><span>Preco</span></th>
							<th class="tabela-coluna"><span>Status</span></th>
							<th class="tabela-coluna"><span>Categoria</span></th>
							<th class="tabela-coluna"><span>Acoes</span></th>
						</tr>
					</table>
				<article class="scrollContainer">
					<table>
					<c:forEach var="cardapio" items="${cardapios}" >
						<tr>
							<td class="tabela-coluna"><span>${cardapio.id}</span></td>
							<td class="tabela-coluna"><span>${cardapio.nome}</span></td>
							<td class="tabela-coluna"><span>${cardapio.preco}</span></td>
							<td class="tabela-coluna"><span>${cardapio.status}</span></td>
							<td class="tabela-coluna"><span>${cardapio.categoria.nome}</span></td>
							<td class="tabela-coluna">
								<span>
									<a href='<c:url value="/cardapio/${cardapio.id}/remove" />'>[remover]</a>
									<a href='<c:url value="/cardapio/${cardapio.id}/formUpdate" />'>[editar]</a>
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