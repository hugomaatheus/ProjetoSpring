<html>
	<head>
		<title>titulo da pagina</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="estilos/estiloIndex.css">
	</head>
	<body>

			<header>
					<c:url var="urlOut" value="/logout/"/> 				
						<input id="btnSair" class="botao" type="button" onclick="window.location.href='${urlOut}'" value="Sair"/>
			</header>
			
			<fieldset><legend>Menu</legend>
							<article class="tab_container" id="Pedidos-gerente">
								<tr>
									<c:url var="urlT" value="/tradicional/listar" />
									<td>
										<input class="botao" type="button" onclick="window.location.href='${urlT}'" value="Pagina Pedido"></input>
									</td>
								</tr>
							</article>
							<article class="tabContainer" id="Reserva">
								<tr>
									<c:url var="urlR" value="/reserva/listar" />									
									<td>
										<input class="botao" type="button" onclick="window.location.href='${urlR}'" value="Pagina Reserva"></input>
									</td>
								</tr>
							</article>
							<article class="tab_container" id="Categoria">
								<tr>
									<c:url var="urlCat" value="/categoria/listar" />
									<td>
										<input class="botao" type="button" onclick="window.location.href=('${urlCat}')" value="Pagina Categoria"></input>
									</td>
								</tr>
							</article>
							<article class="tabContainer" id="Cardapio">
								<tr>
									<c:url var="urlC" value="/categoria/listar" />
									<td>
										<input class="botao" type="button" onclick="window.location.href=('${urlC}')" value="Pagina Cardapio"></input>
									</td>
								</tr>
							</article>
							<article class="tab_container" id="Mesa">
								<tr><c:url var="urlMesa" value="/mesa/listar" />
									<td>
										<input class="botao" type="button" onclick="window.location.href=('${urlMesa}')" value="Pagina Mesa"></input>
									</td>
								</tr>
							</article>
							<article class="tabContainer" id="Funcionario">
								<tr>
									<c:url var="urlF" value="/funcionario/listar" />
									<td>
										<input class="botao" type="button" onclick="window.location.href=('${urlF}')" value="Pagina Funcionario"></input>
									</td>
								</tr>
							</article>
						</fieldset>
				
			</footer>
		</form>
	</body>
</html>