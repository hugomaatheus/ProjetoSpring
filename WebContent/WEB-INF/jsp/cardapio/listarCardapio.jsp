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
		<title>Lista Cardapio</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloCardapio.css">
	</head>
	<body>
	
		<c:url var="url" value="form"/>
			<header>
				<input id="cadatrar" class="novo" type="button" onclick="location.href='${url}'"; value="Cadatrar Cardapio" />
				<input id="sair" class="novo" type="button" value="logout" />
			</header>
			
				<article id="pesquisa">
				<form:form action="filtrar" method="get">
						<label for="txtNumero"><em>Filtrar por:</em></label>

					<label for="txtNome"><em>nome:</em></label>
					<input id="filtro" type="text" />
					<label for="txtCategoria"><em>Categoria:</em></label>
					<select id="OpCategoria" name="categoria" class="categoria">
						<c:forEach var="categoria" items="${categorias}" >
							<option value="${categoria.id}">${categoria.nome}</option>
						</c:forEach>
					</select>
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
			
			<footer><!-- cabeçalho da pagina -->
				
			</footer>
	</body>
</html>