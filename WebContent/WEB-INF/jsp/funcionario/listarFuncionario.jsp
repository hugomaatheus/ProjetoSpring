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
		<title>Lista Funcionarios</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
			<header>
			<c:url var="urlNewF"  value="/funcionario/novoFuncionario"/>
			<input id="novo" type="button" onclick="location.href='${urlNewF}'"; value="Cadatrar Funcionario" />
				<c:url var="urlOut" value="/logout/"/>
				<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
			</header>
			
				<article class="tab_container" id="pesquisa">
					<label for="txtNome"><em>Nome:</em></label>
					<input id="filtro" type="text" />
					<input id="btnPesquisar" type="submit" value="Pesquisar" />
				</article>
				<article class="tabContainer" id="lista">
					<table>
						<thead>
							<tr>
								<th class="tabela-coluna"><span>Nome</span></th>
								<th class="tabela-coluna"><span>CPF</span></th>
								<th class="tabela-coluna"><span>Cargo</span></th>
								<th class="tabela-coluna"><span>Salario</span></th>
								<th class="tabela-coluna"><span>Acoes</span></th>
							</tr>
						</thead>
					</table>
				<article class="scrollContainer">
					<table>
						<tr>
							<td class="tabela-coluna"><span>funcionario.nome</span></td>
							<td class="tabela-coluna"><span>funcionario.cpf</span></td>
							<td class="tabela-coluna"><span>funcionario.cargo</span></td>
							<a href="">[inativar]</a>					
							<td class="tabela-coluna">
								<span>
									<a href="Comando para excluir"> [excluir]</a>
									<a href="Comando para inativar">[Inativar]</a>
								</span>
							</td>
						</tr>
					</table>
				</article>
				</article>
			
			<footer><!-- cabeÃ§alho da pagina -->
				
			</footer>
		</form> 
	</body>
</html>