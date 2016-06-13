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
		<title>Reservas</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloReserva.css">
	</head>
	<body>
			<c:url var="url" value="form"/>
			<header><!-- CabeÃ§a da pagina -->
				<p>Bem vindo, ${usuarioBD.nome}</p>
				<input id="cadastra" class="novo" type="button" onclick="location.href='${url}'"; value="Cadatrar Reserva" />
				<c:url var="urlOut" value="/logout/"/> 				
				<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
			</header>
							<article class="tab_container" id="pesquisa"><!-- Centro da pagina -->
							<form:form method="get" action="filtrar" modelAttribute="filtro">
 									<label for="labelfiltrar"><em>Filtrar por:</em></label><br />
									<label for="labelinicio"><em>Data Inicio:</em></label>
									<form:input id="txtinicial" placeholder="dd/mm/aaaa hh:mm" path="dataInicial" maxlength="14" title="Digite no formato dd/mm/yy hh:mm"/>
									
									<label for="labelfim"><em>Data Fim:</em></label>
									<form:input id="txtfinal" placeholder="dd/mm/aaaa hh:mm" path="dataFinal" maxlength="14" title="Digite no formato dd/mm/yy hh:mm"/>
									
									<label for="labelmesa"><em>Mesa:</em></label>
									<form:select id="Opmesa" path="mesa.id" >
									<form:option value="">Selecione</form:option>
									<c:forEach var="mesa" items="${mesas}" >
										<form:option value="${mesa.id}">Mesa - ${mesa.numero}</form:option>
									</c:forEach>
									</form:select>
									<label id="labelresponsavel"><em>Responsavel:</em></label>
									<form:input id="txtresponsavel" path="nome_Responsavel"/>
									<input id="btnPesquisar" type="submit" value="Pesquisar" />
							</form:form>
							</article>
							<article class="tabContainer" id="lista">
								<table>
										<tr>
											<th class="tabela-coluna"><span>Data Inicio</span></th>
											<th class="tabela-coluna"><span>Data Fim</span></th>
											<th class="tabela-coluna"><span>Mesa</span></th>
											<th class="tabela-coluna"><span>responsavel</span></th>
											<th class="tabela-coluna"><span>Acoes</span></th>
										</tr>
								</table>
								<article class="scrollContainer">
									<table>
										<c:forEach var="reserva" items="${reservas}" >
											<tr>
												<td class="tabela-coluna"><span>${reserva.dataInicial}</span></td>
												<td class="tabela-coluna"><span>${reserva.dataFinal}</span></td>
												<td class="tabela-coluna"><span>Mesa - ${reserva.mesa.numero}</span></td>
												<td class="tabela-coluna"><span>${reserva.nome_Responsavel}</span></td>
												<td class="tabela-coluna">
													<span>
													<a href="/cadastroClientesWebString/reserva/${reserva.id}/formUpdate"> [Editar]</a>
													<a href="/cadastroClientesWebString/reserva/${reserva.id}/remove">[Cancelar]</a>
													</span>
												</td>
											</tr>
										</c:forEach>
									</table>					
								</article>
							</article>
			
			<footer><!-- cabeÃ§alho da pagina -->
				
			</footer>
	</body>
</html>