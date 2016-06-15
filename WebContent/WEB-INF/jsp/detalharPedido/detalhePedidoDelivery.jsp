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
		<title>Detalhe Pedido</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../../estilos/estiloDetalhar.css">
	</head>
	<body>
		<form id="form">
			<header>
				<c:url var="urlOut" value="/logout/"/>
				<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
			</header>
			
			<fieldset id="criar"><legend>Detalhe Deliverys</legend>
				<article id="pesquisa">
	
							<label id="labelnumero"><em>Numero:${pedido.id}</em></label>

							<label id="labelstatus"><em>Status:${pedido.status}</em></label>

<%-- 						<td align="right">
							<label id="labelqtd"><em>Quantidade:${itemPedido.quantidade}</em></label>
						</td>
						<td align="right">
							<label id="labeltroco"><em>Troco para:</em></label>
						</td> --%>
	
				</article>

				<article class="tabContainer" id="lista">
					<table>
						<thead>
							<tr>
								<th class="tabela-coluna"><span>Codigo</span></th>
								<th class="tabela-coluna"><span>Descricao</span></th>
								<th class="tabela-coluna"><span>Quantidade</span></th>
								<th class="tabela-coluna"><span>Total(R$)</span></th>
							</tr>
						</thead>
					</table>
				<article class="scrollContainer">
					<table>
					<c:forEach var="itemPedido" items="${itemPedidos}" >
						<tr>
							<td class="tabela-coluna"><span>${itemPedido.id}</span></td>
							<td class="tabela-coluna"><span>${itemPedido.cardapio.nome}</span></td>
							<td class="tabela-coluna"><span>${itemPedido.quantidade}</span></td>
							<td class="tabela-coluna"><span>${itemPedido.cardapio.preco}</span></td>
						</tr>
					</c:forEach>
					</table>
				</article>
				</article>
				<article>

						<input id="btnCancelar" class="btn" type="button" onclick="location.href='/cadastroClientesWebString/delivery/${pedido.id}/cancelar'" value="cancelar" />

						<input id="btnVoltar" class="btn" type="button" onclick="javascript:history.back(); self.location.reload();" value="Voltar" />

				</article>
			</fieldset>

			<footer><!-- cabeçalho da pagina -->
				
			</footer>
		</form>
	</body>
</html>