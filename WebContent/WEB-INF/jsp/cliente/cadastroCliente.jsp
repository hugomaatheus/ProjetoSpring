<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repeti��o e setar vari�veis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formata��es -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para fun��es -->
<%@ page import=" br.com.util.*"%>

<!DOCTYPE html>
<html>
	<head>
		<title>titulo da pagina</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../../estilos/estiloCliente.css">
		<script type="text/javascript" src="../Plugin js/jquery-1.12.2.min.js"></script>
		<script type="text/javascript" src="../Plugin js/Projeto.js"></script>
	</head>
	<body>
	
		<c:url var="url" value="/cliente/save" />
		
		<header>
			<a id="sair" href="#Sair">Sair</a>
		</header>
		
			<section>
				<form:form method="post" action="${url}" modelAttribute="cliente">
					<article class="cont_tab" id="Read">
						<fieldset><legend>Cadastrar Usuario</legend>
							<article class="tab_Cadastro" id="caixa_1">
								<tbody>
									<tr>
										<td align="right">
											<label id="labellogin"><em>Login:</em></label>
										</td>
										<td align="left">
											<form:input id="txtlogin" type="text" path="login" required=""/>
										</td>
										<td align="right">
											<label id="labelsenha"><em>Senha:</em></label>
										</td>
										<td align="left">
											<form:input id="txtsenha" type="password" path="senha" required="" />
										</td>
										<td align="right">
											<label id="labelNome"><em>Nome:</em></label>
										</td>
										<td align="left">
											<form:input id="txtNome" type="text" path="nome" required="" />
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
											<form:input id="txtemail" type="email" path="email" required="required" name="email" pattern="[a-z0-9._%+-]+@[a-0-9.-]+\.[a-z]{2,4}$" />											
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
											<form:input id="txtrua" type="text" path="endereco.rua" required=""/>
										</td>											
										<td align="right">
											<label id="labelnumero"><em>Numero:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtnumero" type="text" path="endereco.numero" required="" pattern="[0-9]+$" />
										</td>											
										<td align="right">
											<label id="labelcomplemento"><em>Complemento:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtcomplemento" path="endereco.complemento" required="required"/>
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
										<input id="btnvoltar" type="button" onclick="window.location.href='../Tela-Login/Tela-Login.html'" value="Voltar" />
									</td>
								</tr>
							</article>
						</fieldset>
					</article>
				</form>
			</section>

			<footer><!-- cabeçalho da pagina -->
				
			</footer>
		</form:form> 
	</body>
</html>