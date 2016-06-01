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
        <title>Login</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="estilos/estiloLogin.css">
    </head>

    <body>
    <c:url var="url" value="/logar" />
            <header>
                
            </header>
            
            <section>
                <article>
                    <fieldset id="criar"><legend>Login</legend>
                    	<form:form action="${url}" method="post" modelAttribute="usuario"> 
                            <label for="txtlogin" id="labellogin"><em>Login:</em></label>
                            <form:input id="txtlogin" type="text" path="login"></form:input>
                        <br />
                            <label for="txtsenha" id="labelsenha"><em>Senha:</em></label>
                            <form:input id="txtsenha" type="password" path="senha"></form:input>
                        <br />  
                            <input id="logar" class="btn" type="submit" value="Logar"></input>
                            <input id="novo" class="btn" type="button" onclick="window.location.href='../Tela-Cadastro de Usuario/cadastro.html'" value="Novo Usuario"></input>
                    	</form:form>
                    </fieldset>
                </article>      
            </section>
            <footer><!-- cabeÃ§alho da pagina -->
                
            </footer>
    </body>
</html>