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
				<a href="#sair">Sair</a>
			</header>
			
			<c:url var="url" value="/cliente/update"/>

			<section>
				<form:form method="post" action="${url}" modelAttribute="cliente">
					<article class="cont_tab" id="Read">
						<fieldset><legend>Editar Usuario</legend>
							<form:hidden path="id"/>

							<article class="tab_Cadastro" id="caixa_1">
								<tbody>
								<form:hidden path="status"/>
								<form:hidden path="tipo"/>
						
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
											<form:input id="txttelefone" type="tel" path="endereco.telefone" required="required" maxlength="15" pattern="\([0-9]{2}\)[0-9]{4,6}-[0-9]{3,4}$" title="Digite no seguinte formato (xx) xxxxx-xxxx" />
										<td>
										<td align="right">
											<label id="labelemail"><em>Email:</em></label>
										</td>
										<td align="left">
											<form:input id="txtemail" path="email" type="email" required="required" pattern="[a-z0-9._%+-]+@[a-0-9.-]+\.[a-z]{2,4}$" />											
										</td>
									</tr>
								</tbody>
							</article>
							<article class="tab_Cadastro" id="caixa_2">
								<tbody>
									<tr>
										<td align="right">
											<label id="labelrua"><em>Rua:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtrua" path="endereco.rua" type="text" required=""/>
										</td>											
										<td align="right">
											<label id="labelnumero"><em>Numero:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtnumero" path="endereco.numero" type="text" required="" pattern="[0-9]+$" />
										</td>											
										<td align="right">
											<label id="labelcomplemento"><em>Complemento:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtcomplemento" path="endereco.complemento" required="required" name="complemento"/>
										</td>
										<td align="right">
											<label id="labelbairro"><em>Bairro:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtbairro" path="endereco.bairro" required="required"/>
										</td>
										<td align="right">
											<label id="labelcep"><em>CEP:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtcep" path="endereco.cep" required="required" maxlength="9" pattern="\d{5}-\d{3}$" />
										</td>
									</tr>
								</tbody>
							</article>
							<article id= caixa_3>
								<tr>
									<td align="right">
										<input id="btnsalvar" type="submit" value="Salvar" />
									</td>
								</tr>
								<tr>
									<td align="right">
										<input id="btnvoltar" type="button" onclick="history.go(-1)" value="Voltar" />
									</td>
								</tr>
								<tr>
									<c:url var="url" value="/cliente/${id}/deactivate }"/>
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