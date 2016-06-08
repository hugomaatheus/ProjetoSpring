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
		<title>Seus Pedidos</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloTradicional.css">
	</head>

	<body>
		<header>
			<p>Bem vindo, ${usuarioBD.nome}</p>
			<c:url var="urlOut" value="/logout/"/> 				
						<input id="btnSair" class="botao" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
		</header>	

		<fieldset id="criar"><legend>Pedido Tradicional</legend>
			<article class="tab_container" id="Pesquisa">
			<c:url var="url" value="/tradicional/carrinho" />
			
			<form:form method="post" action="${url}" modelAttribute="itemPedido" >
				<%-- <form:input type="hidden" path="id" items="${usuarioBD}" /> --%>
				
				<label id="labelmesa"><em>Mesa:</em></label>
				<form:select id="Opmesa" class="set" path="tradicional.mesa.id" items="${mesaSelect}"/>
				
				<label id="labelStatus"><em>Item:</em></label>
				<form:select id="OpCategoria" class="set" path="cardapio.id" items="${cardapioSelect}"/>
 				
				<label id="labelQtd"><em>Quantidade:</em></label>
				<form:input id="txtQtd" title="Digite apenas numeros" path="quantidade" pattern="[0-9]+$"/>
				
				<input id="btnInserir" class="btn" type="submit" value="Adicionar Item" />
			</form:form>
			
			</article>
			<article class="tabContainer" id="lista">
				<table>
					<tr>
						<th class="tabela-coluna"><span>Produto</span></th>
						<th class="tabela-coluna"><span>Quantidade</span></th>
						<th class="tabela-coluna"><span>Total(R$)</span></th>
						<th class="tabela-coluna"><span>Acoes</span></th>
					</tr>
				</table>
				<article class="scrollContainer">
					<table>
						<c:forEach var="carrinho" items="${carrinho}" >
							<tr>
								<td class="tabela-coluna"><span>${carrinho.cardapio.nome}</span></td>
								<td class="tabela-coluna"><span>${carrinho.quantidade}</span></td>
								<td class="tabela-coluna"><span>${carrinho.cardapio.preco * carrinho.quantidade}</span></td>
								<td class="tabela-coluna">
									<span>	
										<a href="../Tela-Detalhar Pedido/Detalhe pedido.html">[Excluir]</a>
									</span>
								</td>		
							</tr>
						</c:forEach>	
					</table>
				</article>
			</article>
			<table id="TotalDoPedido">
				<td align="left">Total - ${param.total}</td>
			</table>
			<c:url var="urlS" value="/tradicional/save" />
			<c:url var="urlBack" value="/tradicional/listar"/>
			<form:form method="post" action="${urlS}" >
				<input id="btnConfirmar" class="btn" type="submit" value="Salvar" />
				<a class="btn" href="${urlBack}">Voltar</a>
			</form:form>
		</fieldset>
</body>
</html>