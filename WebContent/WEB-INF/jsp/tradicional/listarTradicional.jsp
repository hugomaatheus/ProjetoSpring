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
			<header><!-- Cabeça da pagina -->
			<p>Bem vindo, ${usuarioBD.nome}</p>
				<c:url var="url" value="form"/>
				<input id="novo" type="button" onclick="location.href='${url}'"; value="Realizar Pedidos" />
				<c:url var="urlOut" value="/logout/"/> 				
						<input id="btnSair" class="botao" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
			</header>
		
							<article class="tab_container" id="pesquisa">
								<label id="labelnumero"><em>Numero do Pedido:</em></label>
								<input id="caixa_Numero" title="Digite apenas numeros" type="text" pattern="[0-9]+$"/>
								<label id="labeltipo"><em>Tipo:</em></label>
								<select name = "menuTipo">
									<OPTION>
									<OPTION>Todos os Tipos
								</select>
								<label id="labelstatus"><em>Status:</em></label>	
								<select name = "menuStatus">
									<option value="ATENDIDO">ATENDIDO</option>
									<option value="PENDENTE">PENDENTE</option>
									<option value="CANCELADO">CANCELADO</option>
								</select>
											<input id="btnPesquisar" type="submit" value="Pesquisar" />
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
									<c:forEach var="tradicional" items="${tradicionais}" >
										<tr>
											<td class="tabela-coluna"><span>${tradicional.id}</span></td>
											<td class="tabela-coluna"><span><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${tradicional.data.getTime()}" /></span></td>
											<td class="tabela-coluna"><span>${tradicional.total}</span></td>
											<td class="tabela-coluna"><span>${tradicional.status}</span></td>
											<td class="tabela-coluna">
												<span>
													<a href='<c:url value="/tradicional/${tradicional.id}/detalhar"/>' >[Detalhar]</a>
<%-- 													<a href="/cadastroClientesWebString/tradicional/${tradicional.id}/remove"> [Inativar]</a> --%>
												</span>
											</td>
										</tr>
									</c:forEach>
									</table>									
								</article>								
							</article>
							<c:url var="urlBack" value="/funcionario/indexFuncionario" />
							<input id="btnVoltar" class="btn" type="button" onclick="window.location.href='${urlBack}'" value="Voltar" />
			
			<footer><!-- cabeçalho da pagina -->
				
			</footer>
	</body>
</html>