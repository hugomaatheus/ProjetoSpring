<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->

<html>
	<head>
		<title>titulo da pagina</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="estilos/estiloIndex.css">
	</head>
	<body>
			<header><!-- CabeÃ§a da pagina -->
				<p>Bem vindo, ${usuarioBD.nome}</p>
				<input id="btnSair" type="submit" value="Sair"/>
			</header>

						<fieldset><legend>Menu</legend>
							<article class="tab_container" id="Pedidos">
								<tr>
									<c:url var="urlT" value="/pedido/tradicional/listar" />
									<td>
										<input class="botao" type="button" onclick="window.location.href='${urlT}'" value="Pagina Pedido"></input>
									</td>
								</tr>
							</article>
							<article class="tabContainer" id="Reserva">
								<tr>
								<c:url var="urlR" value="/reserva/listar" />									
									<td>
										<input class="botao" type="button" onclick="window.location.href='${urlR}'" value="Pagina Reserva"></input>
									</td>
								</tr>
							</article>
						</fieldset>

			<footer><!-- cabeÃ§alho da pagina -->
				
			</footer>
	</body>
</html>