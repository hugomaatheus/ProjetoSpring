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
        <title>Pe�a seu delivery</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="../../estilos/estiloPedidoDelivery.css">
    </head>

    <body>
        <header>
        <p>Bem vindo, ${usuarioBD.nome}</p>
            <a href="#Sair">Sair</a>
            
        </header>
			
			<c:url var="url" value="/delivery/save" />
			
            <article class="cont_tab" id="Read">
                <fieldset id="criar"><legend>Cadastrar Pedido</legend>
			<article id="Pesquisa">
				
				<form:input type="hidden" path="funcionario.id" items="${usuarioBD}" />
			
				<form:form method="post" action="${url}" modelAttribute="itemPedido">
					<label for="txtStatus"><em>Item:</em></label>
					<form:select id="OpCardapio" class="set" path="cardapio.id" items="${cardapioSelect}" />
					
					<label for="labelQtd"><em>Quantidade:</em></label>
					<form:input id="txtQtd" title="Digite apenas numeros" type="text" path="quantidade" pattern="[0-9]+$" />

					<input id="btnInserir" type="submit" value="Adicionar Item" />
				</form:form>
			</article>

			<article class="tabContainer" id="lista">
				<table>
					<tr>
						<th class="tabela-coluna"><span>Produto</span></th>
						<th class="tabela-coluna"><span>Quantidade</span></th>
						<th class="tabela-coluna"><span>Total(R$)</span></th>
						<th class="tabela-coluna"><span>Acoes</span></th>
					</tr>
				</table>
				<article class="scrollContainer">
					<table>
						<tr>
							<td class="tabela-coluna"><span>coca</span></td>
							<td class="tabela-coluna"><span>2</span></td>
							<td class="tabela-coluna"><span>5,00</span></td>
							<td class="tabela-coluna"><span> <a
									href="Comando para excluir">[Excluir]</a>
							</span></td>
						</tr>
					</table>
				</article>
			</article>

			<table id="TotalDoPedido">
				<tr>
					<td><span>Troco para</span></td>
				</tr>				
			</table>
				</form:form>
			</td>
                            <input id="btnConfirmar" class="btn" type="submit" value="Confirmar" />
                            <input id="btnVoltar" class="btn" type="button" onclick="history.go(-1)" value="Voltar" />
                    </fieldset>
                </div>
            </div>
        </form>


    </body>
</html>