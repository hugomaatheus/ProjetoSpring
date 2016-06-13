<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->

<!DOCTYPE html>
<html>
	<head>
		<title>Seus Pedidos</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloDelivery.css">
	</head>

	<body>	
		<c:url var="url" value="form"/>
		<header>
			<p>Bem vindo, ${usuarioBD.nome}</p>
			<input id="cadastrar" class="novo" type="button" onclick="location.href='${url}'"; value="Realizar Pedidos" />
			<c:url var="urlOut" value="/logout/"/>
			<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
		</header>	
			
			<article id="pesquisa">
					<form:form action="filtrar" method="get" modelAttribute="filtro">
						<label for="txtNumero"><em>Numero do Pedido:</em></label>
						<form:input id="caixa_Numero" path="id" title="Digite apenas numeros" type="text" pattern="[0-9]+$"/>
						<label id="labeltipo"><em>Tipo:</em></label>
								<form:select path="tipo">
									<form:option value=""></form:option>
									<form:option value="DELIVERY">DELIVERY</form:option>
									<form:option value="TRADICIONAL">TRADICIONAL</form:option>
								</form:select>
						<label for="txtStatus"><em>Status:</em></label>
						<form:select path="status">
							<form:option value=""></form:option>
								<form:option value="ATENDIDO">ATENDIDO</form:option>
								<form:option value="ANDAMENTO">ANDAMENTO</form:option>
								<form:option value="CANCELADO">CANCELADO</form:option>
						</form:select>
						<input id="btnPesquisar" class="btn" type="submit" value="Pesquisar" />
					</form:form>	
			</article>

				<article class="tabContainer" id="lista">
					<table>
					<tr>
						<th class="tabela-coluna"><span>Numero</span></th>
						<th class="tabela-coluna"><span>Data</span></th>
						<th class="tabela-coluna"><span>Total(R$)</span></th>
						<th class="tabela-coluna"><span>Status</span></th>
						<th class="tabela-coluna"><span>Acoes</span></th>
					</tr>
					</table>
				<article class="scrollContainer">
					<table>
					    <c:forEach var="pedido" items="${pedidos}" >
						<tr>
							<td class="tabela-coluna"><span>${pedido.id}</span></td>
							<td class="tabela-coluna"><span><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${pedido.data.getTime()}" /></span></td>
							<td class="tabela-coluna"><span>${pedido.total}</span></td>
							<td class="tabela-coluna"><span>${pedido.status}</span></td>
							<td class="tabela-coluna">
								<span>
									<a href='<c:url value="/delivery/${pedido.id}/detalhar"/>' >[Detalhar]</a>								
								</span>
							</td>
						</tr>
						</c:forEach>
					</table>
				</article>
		</article>
	</body>
</html>