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
        <title>Novo Pedido</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>

    <body>
        <header>
            <a href="#Sair">Sair</a>
        </header>

            <article class="cont_tab" id="Read">
                <fieldset id="criar"><legend>Cadastrar Pedido</legend>
                        <article id="Pesquisa">
                            
                            <label for="txtStatus"><em>Item:</em></label>
                            <SELECT class = "menuCardapio" name = "menuCardapio" size=1>
                                <OPTION>
                                <OPTION>Cardapios
                            </SELECT>
                            <label for="labelQtd"><em>Quantidade:</em></label>
                            <input id="txtQtd" title="Digite apenas numeros" type="text" pattern="[0-9]+$" required="" />
                            
                            <input id="btnInserir" type="submit" value="Adicionar Item" />
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
                                        <td class="tabela-coluna">
                                            <span>
                                                <a href="Comando para excluir">[Excluir]</a>
                                            </span>
                                        </td>
                                    </tr>
                                </table>
                                </article>
                            </article>

                        <table id="TotalDoPedido">
                            <tr>
                                <td>
                                    <span>Troco para</span>
                                </td>
                            </tr>
                        </table>
                        </td>
                            <input id="btnConfirmar" class="btn" type="submit" value="Confirmar" />
                            <input id="btnVoltar" class="btn" type="submit" value="Voltar" />
                    </fieldset>
                </div>
            </div>
        </form>


    </body>
</html>