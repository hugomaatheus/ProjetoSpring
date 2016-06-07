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
			<input id="novo" type="button" onclick="location.href='${url}'"; value="Realizar Pedidos" />
			<p>Bem vindo, ${usuarioBD.nome}</p>
				<a href="#Sair">Sair</a>
		</header>	
			
			<article id="pesquisa">
						<label for="txtNumero"><em>Numero do Pedido:</em></label>
						<input id="caixa_Numero" title="Digite apenas numeros" type="text" pattern="[0-9]+$" autofocus="" required="" />
						<label for="txtStatus"><em>Status:</em></label>
						<SELECT name = "menuStatus" size=1>
							<OPTION></OPTION>
							<OPTION>Atendido</OPTION>
							<OPTION>Pendente</OPTION>
							<OPTION>Cancelado</OPTION>
						</SELECT>
						<input id="btnPesquisar" class="btn" type="submit" value="Pesquisar" />
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
					    <c:forEach var="delivery" items="${deliverys}" >
						<tr>
							<td class="tabela-coluna"><span>${delivery.id}</span></td>
							<td class="tabela-coluna"><span>${delivery.data}</span></td>
							<td class="tabela-coluna"><span>${delivery.total}</span></td>
							<td class="tabela-coluna"><span>${delivery.status}</span></td>
							<td class="tabela-coluna">
								<span>
									<a href="../Tela-Detalhar Pedido/detalhe pedido.html">[Detalhar]</a>
									<a href="Comando para excluir">[Excluir]</a>
								</span>
							</td>
						</tr>
						</c:forEach>
					</table>
				</article>
		</article>
		<c:url var="urlBack" value="/delivery/listar"/>
		<a class="btn" href="${urlBack}">Voltar</a>	
	</body>
</html>