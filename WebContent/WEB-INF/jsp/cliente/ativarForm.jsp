<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ativar Usuário</title>
</head>
<body>
	<c:url var="url" value="/cliente/ativar" />
	
	<form:form method="post" action="${url}" modelAttribute="cliente">
			<h1>Informe seu email para ativar sua conta</h1>
		
			<label id="labelemail"><em>Email:</em></label>
			<form:input id="txtemail" path="email" required="required" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" />
			<form:errors path="email" cssStyle="color:red" />											
			<input id="logar" class="btn" type="submit" value="Ativar"></input>
	</form:form>
</body>
</html>