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
		<title>Edite sua conta</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../../estilos/estiloCadastroCliente.css">
	</head>
	<body>
			<header><!-- CabeÃ§a da pagina -->
			<c:url var="urlM" value="/cliente/indexCliente"/>
				<input id="menu" class="novo" type="button" onclick="location.href='${urlM}'"; value="Menu" />
				<c:url var="urlOut" value="/logout/"/> 				
				<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
			</header>
			
			<c:url var="url" value="/cliente/update"/>

			<section>
				<form:form method="post" action="${url}" modelAttribute="cliente">
					<article class="cont_tab" id="Read">
						<fieldset><legend>Editar Usuario</legend>
							<form:hidden path="id"/>

							<article class="tab_Cadastro" id="caixa_1">
								<table>
								<form:hidden path="status"/>
								<form:hidden path="tipo"/>
						
									<tr>
										
										<td align="right">
											<label id="labellogin"><em>Login:</em></label>
										</td>
										<td align="left">
											<form:input id="txtlogin" required="required" path="login" type="text"/>
											<form:errors path="login" cssStyle="color:red" />
										</td>
										<td align="right">
											<label id="labelsenha"><em>Senha:</em></label>
										</td>
										<td align="left">
											<form:input id="txtsenha" required="required" path="senha" type="password"/>
											<form:errors path="senha" cssStyle="color:red" />
										</td>
										<td align="right">
											<label id="labelNome"><em>Nome:</em></label>
										</td>
										<td align="left">
											<form:input id="txtNome" required="required" path="nome" type="text"/>
											<form:errors path="nome" cssStyle="color:red" />
										</td>
										<td align="right">
											<label id="labeltelefone"><em>Telefone:</em></label>
										</td>
										<td align="left">
											<form:input id="txttelefone" required="required" type="tel" path="endereco.telefone" maxlength="15" pattern="\([0-9]{2}\)[0-9]{4,6}-[0-9]{3,4}$" title="Digite no seguinte formato (xx) xxxxx-xxxx" />
											<form:errors path="endereco.telefone" cssStyle="color:red" />
										<td>
										<td align="right">
											<label id="labelemail"><em>Email:</em></label>
										</td>
										<td align="left">
											<form:input id="txtemail" path="email" required="required" type="email" pattern="[a-z0-9._%+-]+@[a-0-9.-]+\.[a-z]{2,4}$" />
											<form:errors path="email" cssStyle="color:red" />											
										</td>
									</tr>
								</table>
							</article>
							<article class="tab_Cadastro" id="caixa_2">
								<table>
									<tr>
										<td align="right">
											<label id="labelrua"><em>Rua:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtrua" required="required" path="endereco.rua" type="text"/>
											<form:errors path="endereco.rua" cssStyle="color:red" />
										</td>											
										<td align="right">
											<label id="labelnumero"><em>Numero:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtnumero" required="required" path="endereco.numero" type="text" pattern="[0-9]+$" />
										</td>											
										<td align="right">
											<label id="labelcomplemento"><em>Complemento:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtcomplemento" required="required" path="endereco.complemento" name="complemento"/>
										</td>
										<td align="right">
											<label id="labelbairro"><em>Bairro:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtbairro" required="required" path="endereco.bairro" />
										</td>
										<td align="right">
											<label id="labelcep"><em>CEP:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtcep" path="endereco.cep" required="required" maxlength="9" pattern="\d{5}-\d{3}$" />
										</td>
									</tr>
								</table>
							</article>
							<article id= caixa_3>
								<tr>
									<td align="right">
										<input id="btnsalvar" type="submit" value="Salvar" />
									</td>
								</tr>
								<tr>
									<c:url var="urlBack" value="/cliente/indexCliente"/>
									<td align="right">
										<input id="btnvoltar" type="button" onclick="history.go(-1)" value="Voltar" />
									</td>
								</tr>
								<tr>
									<c:url var="url" value="/cliente/${id}/desativar"/>
									<td align="left">
										<a href="${url}">Desativar conta</a>
									</td>
								</tr>
							</article>
						</fieldset>
					</article>
				</form:form>
			</section>

			<footer><!-- cabeÃ§alho da pagina -->
				
			</footer> 
	</body>
</html>