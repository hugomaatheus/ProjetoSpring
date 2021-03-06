<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repeti��o e setar vari�veis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formata��es -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para fun��es -->

<!DOCTYPE html>
<html>
	<head>
		<title>Lista Funcionarios</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloFuncionario.css">
	</head>
	<body>
			<header>
			<c:url var="urlM" value="/gerente/indexGerente"/>
				<input id="menu" class="novo" type="button" onclick="location.href='${urlM}'"; value="Menu" />
			<c:url var="urlNewF"  value="/gerente/form"/>
			<input id="cadastrar" class="novo" type="button" onclick="location.href='${urlNewF}'"; value="Cadatrar Funcionario" />
				<c:url var="urlOut" value="/logout/"/>
				<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
			</header>
			
				<article class="tab_container" id="pesquisa">
				<form:form method="get" action="filtrar" modelAttribute="filtro">
					<label for="txtNome"><em>Nome:</em></label>
					<form:input path="nome" />
					<input id="btnPesquisar" type="submit" value="Pesquisar" />
				</form:form>
				</article>
				<article class="tabContainer" id="lista">
					<table>
						<thead>
							<tr>
								<th class="tabela-coluna"><span>Nome</span></th>
								<th class="tabela-coluna"><span>CPF</span></th>
								<th class="tabela-coluna"><span>Cargo</span></th>
								<th class="tabela-coluna"><span>Salario</span></th>
								<th class="tabela-coluna"><span>Status</span></th>
								<th class="tabela-coluna"><span>Acoes</span></th>
							</tr>
						</thead>
					</table>
				<article class="scrollContainer">
					<table>
						<tr>
							<c:forEach var="funcionario" items="${funcionarios}">
								<td class="tabela-coluna"><span>${funcionario.nome}</span></td>
								<td class="tabela-coluna"><span>${funcionario.cpf}</span></td>
								<td class="tabela-coluna"><span>${funcionario.cargo}</span></td>
								<td class="tabela-coluna"><span>${funcionario.salario}</span></td>
								<td class="tabela-coluna"><span>${funcionario.status}</span></td>													
								<td class="tabela-coluna">
								<span>
									<a href='<c:url value="/gerente/${funcionario.id}/remove"/>'>[Inativar/Ativar]</a>
									<a href='<c:url value="/gerente/${funcionario.id}/formUpdate" />'>[Editar]</a>
								</span>
							</td>
							</c:forEach>
						</tr>
					</table>
				</article>
				</article>
			<footer><!-- cabeçalho da pagina -->
				
			</footer>
		</form> 
	</body>
</html>