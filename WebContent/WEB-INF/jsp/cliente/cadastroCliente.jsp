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
		<title>Cadastre-se</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloCadastroCliente.css">
	</head>
	<body>
	
		<c:url var="url" value="/cliente/save" />
		
		<header>

		</header>
		
			<section>
				<form:form method="post" action="${url}" modelAttribute="cliente">
					<article class="cont_tab" id="Read">
						<fieldset><legend>Cadastrar Usuario</legend>
							<article class="tab_Cadastro" id="caixa_1">
								<table>
									<tr>
										<td align="right">
											<label id="labellogin"><em>Login:</em></label>
										</td>
										<td align="left">
											<form:input id="txtlogin" type="text" required="required" path="login" />
											<form:errors path="login" cssStyle="color:red" />
										</td>
										<td align="right">
											<label id="labelsenha"><em>Senha:</em></label>
										</td>
										<td align="left">
											<form:input id="txtsenha" type="password" required="required" path="senha"  />
											<form:errors path="senha" cssStyle="color:red" />
										</td>
										<td align="right">
											<label id="labelNome"><em>Nome:</em></label>
										</td>
										<td align="left">
											<form:input id="txtNome" type="text" required="required" path="nome"/>
											<form:errors path="nome" cssStyle="color:red" />
										</td>
										<td align="right">
											<label id="labeltelefone"><em>Telefone:</em></label>
										</td>
										<td align="left">
											<form:input id="txttelefone" type="tel" prequired="required" path="endereco.telefone" placeholder="(xx)xxxxx-xxxx" maxlength="15" pattern="\([0-9]{2}\)[0-9]{4,6}-[0-9]{3,4}$" title="Digite no seguinte formato (xx) xxxxx-xxxx" />
											<form:errors path="endereco.telefone" cssStyle="color:red" />
										<td>
										<td align="right">
											<label id="labelemail"><em>Email:</em></label>
										</td>
										<td align="left">
											<form:input id="txtemail" type="email" required="required" path="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" />
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
											<form:input id="txtrua" type="text" required="required" path="endereco.rua"/>
											<form:errors path="endereco.rua" cssStyle="color:red" />
										</td>											
										<td align="right">
											<label id="labelnumero"><em>Numero:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtnumero" type="text" required="required" path="endereco.numero" pattern="[0-9]+$" />
											<form:errors path="endereco.numero" cssStyle="color:red" />
										</td>											
										<td align="right">
											<label id="labelcomplemento"><em>Complemento:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtcomplemento" path="endereco.complemento" required="required"/>
											<form:errors path="endereco.complemento" cssStyle="color:red" />
										</td>
										<td align="right">
											<label id="labelbairro"><em>Bairro:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtbairro" path="endereco.bairro" required="required"/>
											<form:errors path="endereco.bairro" cssStyle="color:red" />
										</td>
										<td align="right">
											<label id="labelcep"><em>CEP:</em></label>
										</td>											
										<td align="left">
											<form:input id="txtcep" path="endereco.cep" required="required" placeholder="xxxxx-xxx" maxlength="9" pattern="\d{5}-\d{3}$" />
											<form:errors path="endereco.cep" cssStyle="color:red" />											
										</td>
									</tr>
								</table>
							</article>
							<article id= caixa_3>
								<c:url var="urlBack" value="/cliente/indexCliente"/>
										<input id="btnsalvar" type="submit" value="Salvar" />
										<a class="btn" href="${urlBack}"></a>
							</article>
						</fieldset>
					</article>
				</form:form> 
			</section>

			<footer><!-- cabeÃ§alho da pagina -->
				
			</footer>
	</body>
</html>