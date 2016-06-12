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
			<c:url var="urlList" value="/tradicional/listar"/>
			<input id="btnVoltar" class="novo" type="button" onclick="window.location.href='${urlList}'" value="Voltar"/>
			<c:url var="urlOut" value="/logout/"/> 				
			<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
		</header>	

		<fieldset id="criar"><legend>Pedido Tradicional</legend>
			<article class="tab_container" id="Pesquisa">
			<c:url var="url" value="/tradicional/carrinho" />
			
			<form:form method="post" action="${url}" modelAttribute="itemPedido" >
				
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
			<c:url var="urlS" value="/tradicional/save" />
			<form:form method="post" action="${urlS}" modelAttribute="mesa" >
			<table id="TotalDoPedido">
				<tr>
					<td align="left">Total - ${param.total}</td>
					<td align="right"><label id="labelmesa"><em>Mesa:</em></label>
						<form:select id="Opmesa" class="set" path="id" items="${mesaSelect}"/></td>
				</tr>			
			</table>
				<input id="btnConfirmar" class="btn" type="submit" value="Salvar" />
			</form:form>
		</fieldset>
</body>
</html>