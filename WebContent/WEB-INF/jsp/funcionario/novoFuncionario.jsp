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
		<title>Cadastro Funcionario</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../estilos/estiloFuncionario.css">
	</head>

	<body>

		<header>
			<c:url var="urlList" value="/gerente/listar"/>
			<input id="btnVoltar" class="novo" type="button" onclick="window.location.href='${urlList}'" value="Voltar"/>
			<c:url var="urlOut" value="/logout/"/>
			<input id="btnSair" class="novo" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
		</header>

		<article class="cont_tab" id="Read">
			<c:url var="url" value="/gerente/save" />
			<form:form  method="post" action="${url}" modelAttribute="funcionario">
				<fieldset id="criar"><legend>Cadastrar Funcionario</legend>
					<label for="txtlogin" id="labellogin"><em>Login:</em></label>
					<form:input id="txtlogin" path="login" type="text"/>

					<label id="labelsenha"><em>Senha:</em></label>
					<form:input id="txtsenha" path="senha" type="password" />
				<br/>
					<label id="labelNome"><em>Nome:</em></label>
					<form:input id="txtNome" path="nome" type="text"/>

					<label id="labeltelefone"><em>Telefone:</em></label>
					<form:input id="txttelefone" type="tel" maxlength="15" path="endereco.telefone" pattern="\([0-9]{2}\)[0-9]{4,6}-[0-9]{3,4}$" title="Digite no seguinte formato (xx) xxxxx-xxxx" />
				<br/>
					<label id="labelemail"><em>Email:</em></label>
					<form:input id="txtemail" type="email" class="input-text" path="email" pattern="[a-z0-9._%+-]+@[a-0-9.-]+\.[a-z]{2,4}$" />
		
					<label id="labelcpf"><em>CPF:</em></label>
					<form:input id="txtcpf" Title="Digite no formato mmm.mmm.mmm-mm" type="text" path="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}$"/>
				<br/>
					<label id="labelcargo"><em>Cargo:</em></label>
					<form:input id="txtcargo" type="text" required="" path="cargo" />

					<label id="labelsalario"><em>Salario:</em></label>
					<form:input id="txtsalario" required="required" maxlength="15" path="salario" pattern="([0-9]{1,3}\.)?[0-9]{1,3},[0-9]{2}$" title="Digite no seguinte formato min: x,xx  max: x.xxx,xx ou " />
				<br/>
					<input id="btnsalvar" class="btn" type="submit" value="Salvar" />

				</fieldset>
			</form:form>
		</article>
	</body>
</html>