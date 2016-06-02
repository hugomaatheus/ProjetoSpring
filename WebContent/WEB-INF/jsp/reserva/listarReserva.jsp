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
				<input id="novo" type="button" onclick="location.href='${url}'"; value="Cadatrar Reserva" />
				<a href="#Sair">Sair</a>
			</header>
							<article class="tab_container" id="pesquisa"><!-- Centro da pagina -->
									<label for="labelfiltrar"><em>Filtrar por:</em></label>
									<label for="labelinicio"><em>Data Inicio:</em></label>
									<input for="txtinicio" type="date" autofocus="" required="" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$"/>
									<label for="labelfim"><em>Data Fim:</em></label>
									<input for="txtfim" type="date" autofocus="" required="" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$"/>
									<label for="labelmesa"><em>Mesa:</em></label>
									<select id="OpCategoria" class = "categoria" name = "categoria" size=1>
										<c:forEach var="mesa" items="${mesas}" >
											<option value="${mesa.id}">Mesa - ${mesa.numero}</option>
										</c:forEach>
									</select>
									<label id="labelresponsavel"><em>Responsavel:</em></label>
									<input id="txtresponsavel" type="text" autofocus="" required="" />
									<input id="btnPesquisar" type="submit" value="Pesquisar" />
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
												<td class="tabela-coluna"><span>${reserva.datainicial}</span></td>
												<td class="tabela-coluna"><span>${reserva.datafinal}</span></td>
												<td class="tabela-coluna"><span>Mesa - ${reserva.mesa.numero}</span></td>
												<td class="tabela-coluna"><span>${reserva.nome_responsavel}</span></td>
												<td class="tabela-coluna">
													<span>
													<a href="Comando para excluir"> [excluir]</a>
													<a href="Comando para inativar">[Inativar]</a>
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