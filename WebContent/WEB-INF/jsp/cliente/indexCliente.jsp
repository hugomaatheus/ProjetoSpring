<html>
	<head>
		<title>titulo da pagina</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../../estiloIndex.css">
	</head>
	<body>
		<form id="form">
			<header><!-- Cabeça da pagina -->
					<input id="btnSair" type="submit" value="Sair"/>
			</header>
			
			<section>

						<fieldset><legend>Menu</legend>
							<article class="tab_container" id="Pedidos">
								<tr>
									<td>
										<input class="botao" type="button" onclick="window.open('../Tela-Pedidos-Cliente/Tela-Pedido-Cliente.html')" value="Pagina Pedido"></input>
									</td>
								</tr>
							</article>
							<article class="tabContainer" id="Editar">
								<tr>
									<td>
										<input class="botao" type="button" onclick="window.location.href='../Tela-Cadastro de Usuario/Cadastro.html'" value="Editar Usuario"></input>
									</td>
								</tr>
							</article>
						</fieldset>
	
			<footer><!-- cabeçalho da pagina -->
				
			</footer>
		</form>
	</body>
</html>