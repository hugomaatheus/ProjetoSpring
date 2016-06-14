<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->
    
    
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="estilos/estiloLogin.css">
    </head>

    <body>
   
            <header>
                 <c:url var="url" value="/logar" />
                 <c:url var="urlAtivar" value="/cliente/ativarForm" />
            </header>
            
            <c:if test="${message != null}">
			
			<div id="alert">
		    	<a href="${urlAtivar}" class="alert">${message}</a>	    	
			</div>	
            </c:if>
            
            <section>
                <article>
                    <fieldset id="criar"><legend>Login</legend>
                    	<form:form action="${url}" method="post" modelAttribute="usuario"> 
                            <label for="txtlogin" id="labellogin"><em>Login:</em></label>
                            <form:input id="txtlogin" type="text" path="login"/>
                             <form:errors path="login" cssStyle="color:red" />                                                         
                        <br />
                            <label for="txtsenha" id="labelsenha"><em>Senha:</em></label>
                       		<form:input id="txtsenha" type="password" path="senha"/>
                        	<form:errors path="senha" cssStyle="color:red" />                         
                       	<br />
                            <input id="logar" class="btn" type="submit" value="Logar"></input>
                         <c:url var="url2" value="/cliente/form" />
                            <input id="novo" class="btn" type="button" onclick="window.location.href='${url2}'" value="Novo Usuario"></input>
                         </form:form>
                    </fieldset>
                </article>      
            </section>
            <footer><!-- cabeÃ§alho da pagina -->
                
            </footer>
    </body>
</html>