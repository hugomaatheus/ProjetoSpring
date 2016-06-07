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
		<link rel="stylesheet" type="text/css" href="../estilos/estiloMesa.css">
	</head>
		<c:url var="url" value="form"/>
			<header><!-- CabeÃ§a da pagina -->
				<input id="novo" type="button" onclick="location.href='${url}'"; value="Cadatrar Mesa" />
				<input id="sair" class="novo" type="button" value="logout" />
			</header>
			<article id="pesquisa">
				<form action="filtrar" method="get">
					<label for="txtNumero"><em>Filtrar por:</em></label>
					
					<label for="filtroNome"><em>numero:</em></label>
					<input id="filtroNome" type="text" path="numero"/>
					
					<label for="txtreserva"><em>De reserva:</em></label>
					<select id="OpCategoria" class="categoria" path="categoria">
						<option value="sim">Sim</option>
						<option value="nao">Nao</option>
					</select>
					<input id="btnPesquisar" class="btn" type="submit" value="Pesquisar" />
				</form>
			</article>
			
			<article class="tabContainer" id="lista">
				<table>
					<tr>
						<th class="tabela-coluna"><span>Codigo</span></th>
						<th class="tabela-coluna"><span>Descricao</span></th>
						<th class="tabela-coluna"><span>Capacidade</span></th>
						<th class="tabela-coluna"><span>De reserva?</span></th>
						<th class="tabela-coluna"><span>Acoes</span></th>
					</tr>
				</table>
				<article class="scrollContainer">
					<table>
						<c:forEach var="mesa" items="${mesas}" >
						<tr>
							<td class="tabela-coluna"><span>${mesa.id}</span></td>
							<td class="tabela-coluna"><span>Mesa - ${mesa.numero }</span></td>
							<td class="tabela-coluna"><span>${mesa.capacidade }</span></td>
							<td class="tabela-coluna"><span>${mesa.status }</span></td>
							<td class="tabela-coluna">
								<span>
									<a href='<c:url value="/mesa/${mesa.id}/remove" />'>[remover]</a>
									<a href='<c:url value="/mesa/${mesa.id}/formUpdate" />'>[editar]</a>
								</span>
							</td>
						</tr>
						</c:forEach>
					</table>
				</article>
			</article>
			<c:url var="urlBack" value="/funcionario/indexFuncionario"/>
			<a class="btn" href="${urlBack}">Voltar</a>
			
			<footer><!-- cabeÃ§alho da pagina -->
				
			</footer>
</html>