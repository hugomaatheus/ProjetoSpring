<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->
<%@ page import=" br.com.util.*"%>

<html>
	<head>
		<title>titulo da pagina</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="../Plugin js/jquery-1.12.2.min.js"></script>
		<script type="text/javascript" src="../Plugin js/Projeto.js"></script>
	</head>
	<body>
		<formid = "form">
			<header><!-- CabeÃ§a da pagina -->
				<ul class="tabs">
				<c:url var="urlOut" value="/logout/"/>
				<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
				</ul>
			</header>
						
			<section>
				<c:url var="url" value="/gerente/update" />
				<form:form method="post" action="${url}" modelAttribute="funcionario">
					<article class="cont_tab" id="Create">
						<fieldset><legend>Editar Funcionario</legend>
							<article class="tab_Cadastro" id="caixa_1">
								<tbody>
									<tr>
										<td align="right">
											<label id="labellogin"><em>Login:</em></label>
										</td>
										<td align="left">
											<form:input id="txtlogin" path="login" type="text" required=""/>
										</td>
										<td align="right">
											<label id="labelsenha"><em>Senha:</em></label>
										</td>
										<td align="left">
											<form:input id="txtsenha" path="senha" type="password" required="" />
										</td>
										<td align="right">
											<label id="labelNome"><em>Nome:</em></label>
										</td>
										<td align="left">
											<form:input id="txtNome" path="nome" type="text" required="" />
										</td>
										<td align="right">
											<label id="labeltelefone"><em>Telefone:</em></label>
										</td>
										<td align="left">
											<form:input id="txttelefone" type="tel" required="required" maxlength="15" path="endereco.telefone" pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" title="Digite no seguinte formato (xx) xxxxx-xxxx" />
										<td>
									</tr>
								</tbody>
							</article>
							<article class="tab_Cadastro" id="caixa_2">
								<tbody>
									<tr>
										<td align="right">
											<label id="labelemail"><em>Email:</em></label>
										</td>
										<td align="left">
											<form:input id="txtemail" type="email" required="required" class="input-text" path="email" pattern="[a-z0-9._%+-]+@[a-0-9.-]+\.[a-z]{2,4}$" />											
										</td>
										<td align="right">												
											<label id="labelcpf"><em>CPF:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtcpf" Title="Digite no formato mmm.mmm.mmm-mm" type="text" required="" path="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}$"/>
										</td>											
										<td align="right">
											<label id="labelcargo"><em>Cargo:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtcargo" path="cargo" type="text" required="" />
										</td>											
										<td align="right">
											<label id="labelsalario"><em>Salario:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtsalario" type="tel" required="required" maxlength="15" path="salario" pattern="([0-9]{1,3}\.)?[0-9]{1,3},[0-9]{2}$" title="Digite no seguinte formato min: x,xx  max: x.xxx,xx ou " />
										</td>
									</tr>
								</tbody>
							</article>
							<article id= caixa_salvar>
								<tr>
									<td align="right">
										<input id="btnsalvar" type="submit" value="Editar" />
									</td>
								</tr>
							</article>
						</fieldset>
					</article>
				</form:form>
			</section>
			
			<footer><!-- cabeÃ§alho da pagina -->
				
			</footer>
		</form> 
	</body>
</html>